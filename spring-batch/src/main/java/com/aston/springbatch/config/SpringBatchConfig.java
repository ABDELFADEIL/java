package com.aston.springbatch.config;

import com.aston.springbatch.dao.BankTransaction;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.support.CompositeItemProcessor;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableBatchProcessing
public class SpringBatchConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    @Autowired
    private StepBuilderFactory stepBuilderFactory;
    @Autowired
    private ItemReader<BankTransaction> itemReader;
    @Autowired
    private ItemWriter<BankTransaction> itemWriter;
    // @Autowired private ItemProcessor<BankTransaction, BankTransaction> itemBankTransactionProcessor;

    @Bean
    public Job bankJob(){
        return jobBuilderFactory.get("bank-data-loader-job")
                .start(step1()).build();
    }
    @Bean
    public Step step1(){
        return stepBuilderFactory.get("step-load-data")
                .<BankTransaction, BankTransaction>chunk(100)
                .reader(flatFileItemReader(null))
                .processor(compositeProcessor())
                .writer(itemWriter)
                .build();
    }
    @Bean
    public BankTrasactionItemProcessor itemProcessor1(){
        return new BankTrasactionItemProcessor();
    }

    @Bean
    public BankTransactionItemAnalyticsProcessor itemProcessor2(){
        return new BankTransactionItemAnalyticsProcessor();
    }

    @Bean
    public ItemProcessor<? super BankTransaction,? extends BankTransaction> compositeProcessor() {
       List<ItemProcessor<BankTransaction, BankTransaction>> itemProcessors = new ArrayList<>();
       itemProcessors.add(itemProcessor1());
        itemProcessors.add(itemProcessor2());

        CompositeItemProcessor<BankTransaction, BankTransaction> compositeItemProcessor = new CompositeItemProcessor<BankTransaction, BankTransaction>();
        compositeItemProcessor.setDelegates(itemProcessors);
        return compositeItemProcessor;
    }

    @Bean
   public FlatFileItemReader<BankTransaction> flatFileItemReader(@Value("${inputFile}") Resource inputFile){
     FlatFileItemReader<BankTransaction> flatFileItemReader = new FlatFileItemReader<>();
     flatFileItemReader.setName("csv-reader");
     flatFileItemReader.setLinesToSkip(1);
     flatFileItemReader.setResource(inputFile);
     flatFileItemReader.setLineMapper(lineMapper());
     return flatFileItemReader;
   }

   @Bean
   public LineMapper<BankTransaction> lineMapper() {
       DefaultLineMapper<BankTransaction> lineMapper = new DefaultLineMapper<>();
       DelimitedLineTokenizer delimiterTokenizer = new DelimitedLineTokenizer();
       delimiterTokenizer.setDelimiter(",");
       delimiterTokenizer.setStrict(false);
       delimiterTokenizer.setNames("id", "accountId", "strTransactionDate", "transactionType", "amount");
       lineMapper.setLineTokenizer(delimiterTokenizer);
       BeanWrapperFieldSetMapper<BankTransaction> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
       fieldSetMapper.setTargetType(BankTransaction.class);
       lineMapper.setFieldSetMapper(fieldSetMapper);
       return lineMapper;
   }

}
