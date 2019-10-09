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
   /* private SumCalculator testObject;

    @Before
    public void setUp() throws Exception {
        testObject = new SumCalculator();
    }


    @Test
    @Parameters(method = "dataForInitializeMatrixTest")
    public void initializeMatrixTest(List<String> list, int[][] expectedMatrix) {

        testObject.setList(list);

        testObject.initializeMatrix();

        Assert.assertArrayEquals(expectedMatrix, testObject.getBaset10Matrix());

    }

    @Test
    @Parameters(method = "dataFillBase10SumTableTest")
    public void fillBase10SumArrayTest(int[][] entryMatrix, Integer[] expectedBase10Array) {
        testObject.setBaset10Matrix(entryMatrix);
        testObject.fillBase10SumArray();
        Assert.assertArrayEquals(testObject.getBase10SumArray(), expectedBase10Array);

    }

    private Object[] dataForInitializeMatrixTest() {
        return new TestData().testCase(new ArrayList<String>(Arrays.asList("001", "002", "-103", "-005")), new int[][]{{0, 0, 1}, {0, 0, 2}, {-1, 0, -3}, {0, 0, -5}})
                .testCase(new ArrayList<>(Arrays.asList("1", "2", "-3", "-5")), new int[][]{{1}, {2}, {-3}, {-5}})
                .testCase(new ArrayList<>(Arrays.asList("001", "102", "-003", "-005")), new int[][]{{0, 0, 1}, {1, 0, 2}, {0, 0, -3}, {0, 0, -5}})
                .testCase(new ArrayList<>(Arrays.asList("000000001", "950000002", "-000000003", "-000000005")), new int[][]{{0, 0, 0, 0, 0, 0, 0, 0, 1}, {9, 5, 0, 0, 0, 0, 0, 0, 2}, {0, 0, 0, 0, 0, 0, 0, 0, -3}, {0, 0, 0, 0, 0, 0, 0, 0, -5}})
                .testCase(new ArrayList<>(Arrays.asList("+001", "+002", "-103", "-005")), new int[][]{{0, 0, 1}, {0, 0, 2}, {-1, 0, -3}, {0, 0, -5}})
                .testCase(new ArrayList<>(Arrays.asList("001")), new int[][]{{0, 0, 1}})
                .testCase(null, null)
                .getData();
    }

    @Test
    @Parameters(method = "dataCalculateSum")
    public void calculateSumTest(Integer[] entryArray, BigInteger excpectedBigInteger) {
        testObject.setBase10SumArray(entryArray);

        assertEquals(excpectedBigInteger, testObject.calculateSum());

    }

    private Object[] dataFillBase10SumTableTest() {
        return new TestData().testCase(new int[][]{{0, 0, 1}, {0, 0, 2}, {-1, 0, -3}, {0, 0, -5}}, new Integer[]{-1, 0, -5})
                .testCase(new int[][]{{1}, {2}, {-3}, {-5}}, new Integer[]{-5})
                .testCase(new int[][]{{0, 0, 1}, {1, 0, 2}, {0, 0, -3}, {0, 0, -5}}, new Integer[]{1, 0, -5})
                .testCase(new int[][]{{0, 0, 0, 0, 0, 0, 0, 0, 1}, {9, 5, 0, 0, 0, 0, 0, 0, 2}, {0, 0, 0, 0, 0, 0, 0, 0, -3}, {0, 0, 0, 0, 0, 0, 0, 0, -5}}, new Integer[]{9, 5, 0, 0, 0, 0, 0, 0, -5})
                .testCase(new int[][]{{0, 0, 1}, {0, 0, 2}, {-1, 0, -3}, {0, 0, -5}}, new Integer[]{-1, 0, -5})
                .testCase(new int[][]{{0, 0, 1}}, new Integer[]{0, 0, 1})
                .testCase(null, null)
                .getData();
    }
    private Object[] dataCalculateSum() {
        return new TestData().testCase(new Integer[]{2, 2, 2}, BigInteger.valueOf(222))
                .testCase(new Integer[]{1, 0, 0},  BigInteger.valueOf(100))
                .testCase(new Integer[]{12, 10, -5},  BigInteger.valueOf(1295))
                .testCase(new Integer[]{2},  BigInteger.valueOf(2))
                .testCase(new Integer[]{0, 0, 0, 20},  BigInteger.valueOf(20))
                .getData();

    }*/
}