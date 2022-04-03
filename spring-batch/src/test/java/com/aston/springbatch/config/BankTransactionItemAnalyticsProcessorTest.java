package com.aston.springbatch.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import com.aston.springbatch.dao.BankTransaction;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.junit.jupiter.api.Test;

class BankTransactionItemAnalyticsProcessorTest {
    @Test
    void testProcess() throws Exception {
        BankTransactionItemAnalyticsProcessor bankTransactionItemAnalyticsProcessor = new BankTransactionItemAnalyticsProcessor();

        BankTransaction bankTransaction = new BankTransaction();
        bankTransaction.setAccountId(1234567890L);
        bankTransaction.setAmount(10.0);
        bankTransaction.setId(123L);
        bankTransaction.setStrTransactionDate("2020-03-01");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        bankTransaction.setTransactionDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        bankTransaction.setTransactionType("Transaction Type");
        assertSame(bankTransaction, bankTransactionItemAnalyticsProcessor.process(bankTransaction));
    }

    @Test
    void testProcess2() throws Exception {
        BankTransactionItemAnalyticsProcessor bankTransactionItemAnalyticsProcessor = new BankTransactionItemAnalyticsProcessor();

        BankTransaction bankTransaction = new BankTransaction();
        bankTransaction.setAccountId(1234567890L);
        bankTransaction.setAmount(10.0);
        bankTransaction.setId(123L);
        bankTransaction.setStrTransactionDate("2020-03-01");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        bankTransaction.setTransactionDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        bankTransaction.setTransactionType("D");
        assertSame(bankTransaction, bankTransactionItemAnalyticsProcessor.process(bankTransaction));
        assertEquals(10.0, bankTransactionItemAnalyticsProcessor.getTotalDebit());
    }

    @Test
    void testProcess3() throws Exception {
        BankTransactionItemAnalyticsProcessor bankTransactionItemAnalyticsProcessor = new BankTransactionItemAnalyticsProcessor();

        BankTransaction bankTransaction = new BankTransaction();
        bankTransaction.setAccountId(1234567890L);
        bankTransaction.setAmount(10.0);
        bankTransaction.setId(123L);
        bankTransaction.setStrTransactionDate("2020-03-01");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        bankTransaction.setTransactionDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        bankTransaction.setTransactionType("C");
        assertSame(bankTransaction, bankTransactionItemAnalyticsProcessor.process(bankTransaction));
        assertEquals(10.0, bankTransactionItemAnalyticsProcessor.getTotalCredit());
    }
}

