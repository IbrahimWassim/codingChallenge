package com.brainlab.codingchallenge.CodingChallenge.util;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class SumCalculatorTest {
    private SumCalculator testObject;

    @Before
    public void setUp() throws Exception {
        testObject = new SumCalculator();
    }

    @Test
    @Parameters(method = "dataForFillBase10Array")
    public void fillBase10ArrayTest(List<String> list, List<Integer> expectedArray) {

        testObject.setList(list);
        testObject.fillBase10Array();
        List<Integer> foundList = testObject.getBase10SumArray();

        assertEquals(expectedArray, foundList);

    }
    @Test
    @Parameters(method = "dataForCalculateSum")
    public void calculateSumTest(List<Integer> list, List<Integer> expectedArray) {

        testObject.setBase10SumArray(list);
        List<Integer> foundList =   testObject.calculateSum(list);
        assertEquals(expectedArray, foundList);

    }

    private Object[] dataForFillBase10Array() {
        return new TestData()
                .testCase((Arrays.asList("0001", "0005", "1500")), (Arrays.asList(1, 5, 0, 6)))
                .testCase((Arrays.asList("0000", "0000", "0000")), (Arrays.asList(0, 0, 0, 0)))
                .testCase((Arrays.asList("4444444444444")), (Arrays.asList(4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4)))
                .testCase((Arrays.asList("-4444444444444")), (Arrays.asList(-4, -4, -4, -4, -4, -4, -4, -4, -4, -4, -4, -4, -4)))
                .testCase((Arrays.asList("-4444444444444", "3333333333333")), (Arrays.asList(-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1)))
                .testCase((Arrays.asList("-4444444444444")), (Arrays.asList(-4, -4, -4, -4, -4, -4, -4, -4, -4, -4, -4, -4, -4)))
                .testCase((Arrays.asList("001", "-500", "060")), (Arrays.asList(-5, 6, 1)))
                .testCase((Arrays.asList("-001", "-500", "-060")), (Arrays.asList(-5, -6, -1)))
                .getData();

    }

    private Object[] dataForCalculateSum() {
        return new TestData()
                .testCase((Arrays.asList(1, 5, 0, 6)),(Arrays.asList(1, 5, 0, 6)))
                .testCase((Arrays.asList(0, 0, 0, 0)),(Arrays.asList(0, 0, 0, 0)))
                .testCase((Arrays.asList(4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4)),(Arrays.asList(4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4)))
                .testCase((Arrays.asList(-4, -4, -4, -4, -4, -4, -4, -4, -4, -4, -4, -4, -4)),(Arrays.asList(-4, -4, -4, -4, -4, -4, -4, -4, -4, -4, -4, -4, -4)))
                .getData();

    }
}