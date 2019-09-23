package com.brainlab.codingchallenge.CodingChallenge.controllers;

import com.brainlab.codingchallenge.CodingChallenge.exceptions.InconvertibleToNumberException;
import com.brainlab.codingchallenge.CodingChallenge.services.impl.CalculatorService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Controller for the calculator webaervice
 */
@RestController
@RequestMapping("/calculator")
public class CalculatorController  {
    @Resource
    CalculatorService calculatorService;
    @RequestMapping(value = "/add", method = RequestMethod.GET, produces = "application/json")
    public String add(@RequestParam("operands") String operands) throws InconvertibleToNumberException {
        System.out.println(operands);
        return calculatorService.calculateSum(operands);
    }
}
