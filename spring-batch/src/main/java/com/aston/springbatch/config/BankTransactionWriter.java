package com.aston.springbatch.config;

import com.aston.springbatch.dao.BankTransaction;
import com.aston.springbatch.dao.BankTransactionRepo;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BankTransactionWriter implements ItemWriter<BankTransaction> {

    @Autowired
    private BankTransactionRepo bankTransactionRepo;

    @Override
    public void write(List<? extends BankTransaction> list) throws Exception {
        bankTransactionRepo.saveAll(list);
    }
}
