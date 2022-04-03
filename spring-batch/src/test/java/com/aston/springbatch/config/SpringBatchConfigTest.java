package com.aston.springbatch.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.aston.springbatch.dao.BankTransaction;

import java.io.UnsupportedEncodingException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {SpringBatchConfig.class})
@ExtendWith(SpringExtension.class)
class SpringBatchConfigTest {
    @MockBean
    private Step step;

    @MockBean
    private ItemReader<BankTransaction> itemReader;

    @MockBean
    private ItemWriter<BankTransaction> itemWriter;

    @MockBean
    private Job job;

    @MockBean
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private SpringBatchConfig springBatchConfig;

    @MockBean
    private StepBuilderFactory stepBuilderFactory;

    @Test
    void testBankJob() {
        // TODO: This test is incomplete.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by bankJob()
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        this.springBatchConfig.bankJob();
    }

    @Test
    void testStep1() {
        // TODO: This test is incomplete.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by step1()
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        this.springBatchConfig.step1();
    }

    @Test
    void testStep12() {
        // TODO: This test is incomplete.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by step1()
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        this.springBatchConfig.step1();
    }

    @Test
    void testItemProcessor1() {
        // TODO: This test is incomplete.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by itemProcessor1()
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        this.springBatchConfig.itemProcessor1();
    }

    @Test
    void testItemProcessor2() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by itemProcessor2()
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        BankTransactionItemAnalyticsProcessor actualItemProcessor2Result = (new SpringBatchConfig()).itemProcessor2();
        assertEquals(0.0, actualItemProcessor2Result.getTotalCredit());
        assertEquals(0.0, actualItemProcessor2Result.getTotalDebit());
    }

    @Test
    void testCompositeProcessor() {
        assertTrue(this.springBatchConfig
                .compositeProcessor() instanceof org.springframework.batch.item.support.CompositeItemProcessor);
    }

    @Test
    void testFlatFileItemReader() throws UnsupportedEncodingException {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalStateException: @Bean method SpringBatchConfig.flatFileItemReader called as bean reference for type [org.springframework.batch.item.file.FlatFileItemReader] but overridden by non-compatible bean instance of type [org.mockito.codegen.ItemReader$MockitoMock$418160375]. Overriding bean of same name declared in: null
        //       at org.springframework.context.annotation.ConfigurationClassEnhancer$BeanMethodInterceptor.resolveBeanReference(ConfigurationClassEnhancer.java:386)
        //       at org.springframework.context.annotation.ConfigurationClassEnhancer$BeanMethodInterceptor.intercept(ConfigurationClassEnhancer.java:334)
        //       at com.aston.springbatch.config.SpringBatchConfig$$EnhancerBySpringCGLIB$$17c36750.flatFileItemReader(<generated>)
        //   In order to prevent flatFileItemReader(Resource)
        //   from throwing IllegalStateException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   flatFileItemReader(Resource).
        //   See https://diff.blue/R013 to resolve this issue.

        SpringBatchConfig springBatchConfig = new SpringBatchConfig();
        assertTrue(springBatchConfig.flatFileItemReader(new ByteArrayResource("AAAAAAAA".getBytes("UTF-8"))).isSaveState());
    }

    @Test
    void testLineMapper() {
        assertTrue(
                this.springBatchConfig.lineMapper() instanceof org.springframework.batch.item.file.mapping.DefaultLineMapper);
    }
}

