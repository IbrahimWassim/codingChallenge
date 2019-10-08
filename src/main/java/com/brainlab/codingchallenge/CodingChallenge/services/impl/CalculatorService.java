package com.brainlab.codingchallenge.CodingChallenge.services.impl;

import com.brainlab.codingchallenge.CodingChallenge.exceptions.InconvertibleToNumberException;
import com.brainlab.codingchallenge.CodingChallenge.util.SumCalculator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class CalculatorService {
    private static final Logger LOG = LoggerFactory.getLogger(CalculatorService.class);

    private SumCalculator sumCalculator;

    /**
     * interacts with the controller and returns the  sum.
     *
     * @param operandsString
     * @return
     */
    public String calculateSum(String operandsString) {
        sumCalculator = new SumCalculator();

        String sum = null;
        try {
            sum = sumCalculator.calculateFinalSum(operandsString);

        } catch (InconvertibleToNumberException e) {
            LOG.error("Error in parsing input String : " + operandsString, e);
            //e.printStackTrace();
        }

        if (sum == null)
            return "{ \"sum\" : " + Double.NaN + "}";
        return "{ \"sum\" : " + sum + "}";
    }
}
