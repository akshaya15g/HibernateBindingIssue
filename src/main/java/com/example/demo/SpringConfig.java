package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.ArrayList;

@Configuration
@EnableScheduling
public class SpringConfig {

    @Autowired
    private InProcessBankGuaranteeRepository repository;

    @Scheduled(fixedDelay = 60000)
    public void scheduleFixedDelayTask() {
        System.out.println(
                "Fixed delay task - " + System.currentTimeMillis() / 60000);

        var cifs = new ArrayList<String>();
        cifs.add("659086");


        var excludedTcs = new ArrayList<String>();
        excludedTcs.add("G90");
        excludedTcs.add("G91");

        var guarantees =
                repository.findMostRecentMatching( cifs, "GA3123-14831");

        System.out.println("Output");
        System.out.println(guarantees);


    }

}