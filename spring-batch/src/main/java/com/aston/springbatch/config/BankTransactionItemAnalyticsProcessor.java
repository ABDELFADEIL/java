package com.aston.springbatch.config;

import com.aston.springbatch.dao.BankTransaction;
import lombok.Getter;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.logging.Level;

// @Component
public class BankTransactionItemAnalyticsProcessor implements ItemProcessor<BankTransaction, BankTransaction>{
    @Getter private double totalDebit = 0;
    @Getter private double totalCredit = 0;
    @Override
    public BankTransaction process(BankTransaction item) throws Exception {
        if(item.getTransactionType().equals("D")) totalDebit += item.getAmount();
        if(item.getTransactionType().equals("C")) totalCredit += item.getAmount();
        return item;
    }
}
