package com.brainlab.codingchallenge.CodingChallenge.services.impl;

import com.brainlab.codingchallenge.CodingChallenge.exceptions.InconvertibleToNumberException;
import com.brainlab.codingchallenge.CodingChallenge.util.SumCalculator;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class CalculatorService {
    private SumCalculator sumCalculator;

    /**
     * interacts with the controller and returns the  sum.
     *
     * @param operandsString
     * @return
     */
    public String calculateSum(String operandsString) throws InconvertibleToNumberException {
        sumCalculator = new SumCalculator();

        BigInteger sum = sumCalculator.calculateFinalSum(operandsString);
        if (sum == null)
            return "{ \"sum\" : " + Double.NaN + "}";
        return "{ \"sum\" : " + sum + "}";

    }
}
