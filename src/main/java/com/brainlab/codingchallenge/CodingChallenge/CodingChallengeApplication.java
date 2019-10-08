package com.brainlab.codingchallenge.CodingChallenge;

import java.lang.invoke.MethodHandles;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class CodingChallengeApplication {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    public static void main(String[] args) {
        LOGGER.info("\nWeb Service to add two ransom numbers started\n");
        SpringApplication.run(CodingChallengeApplication.class, args);
    }

}
