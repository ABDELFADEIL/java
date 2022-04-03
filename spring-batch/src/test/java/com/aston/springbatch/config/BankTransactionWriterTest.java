package com.aston.springbatch.config;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.aston.springbatch.dao.BankTransaction;
import com.aston.springbatch.dao.BankTransactionRepo;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {BankTransactionWriter.class})
@ExtendWith(SpringExtension.class)
class BankTransactionWriterTest {
    @MockBean
    private BankTransactionRepo bankTransactionRepo;

    @Autowired
    private BankTransactionWriter bankTransactionWriter;

    @Test
    void testWrite() throws Exception {
        when(this.bankTransactionRepo.saveAll((Iterable<BankTransaction>) any())).thenReturn(new ArrayList<>());
        this.bankTransactionWriter.write(new ArrayList<>());
        verify(this.bankTransactionRepo).saveAll((Iterable<BankTransaction>) any());
    }
}

