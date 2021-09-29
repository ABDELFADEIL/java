package com.aston.springbatch.controller;

import com.aston.springbatch.config.BankTransactionItemAnalyticsProcessor;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class JobRestController {

    @Autowired
    private JobLauncher jobLauncher;
    @Autowired
    private Job job;
    @Autowired
    private BankTransactionItemAnalyticsProcessor analyticsProcessor;
    @GetMapping("/startJob")
    public BatchStatus load() throws Exception {
    Map<String, JobParameter> params = new HashMap<>();
        params.put("time", new JobParameter(System.currentTimeMillis()));
    JobParameters jobParameters = new JobParameters(params);
    JobExecution jobExecution = jobLauncher.run(job, jobParameters);
    while (jobExecution.isRunning()){
        System.out.println("running ....");
    }
    return jobExecution.getStatus();
    }

    @GetMapping("/analytics")
    public Map<String, String> analytics() {
        Map<String, String> map = new HashMap<>();
        map.put("totalCredit", String.valueOf(analyticsProcessor.getTotalCredit()));
        map.put("totalDebit", String.valueOf(analyticsProcessor.getTotalDebit()));
        return map;
    }
}
