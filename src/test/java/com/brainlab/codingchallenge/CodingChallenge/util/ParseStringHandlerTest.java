package com.brainlab.codingchallenge.CodingChallenge.util;

import com.brainlab.codingchallenge.CodingChallenge.exceptions.InconvertibleToNumberException;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class ParseStringHandlerTest {

    private ParseStringHandler testObject;

    @Before
    public void setUp() throws Exception {
        testObject = new ParseStringHandler();
    }

    @Test
    @Parameters(method = "dataStringToIntegersArrayTest")
    public void stringToIntegersArrayTest(String stringToParse, List<String> expectedArray) {
        try {
            testObject.stringToNumbersArray(stringToParse);
            assertEquals(testObject.getNumericInputs(), expectedArray);
        } catch (InconvertibleToNumberException e) {
            e.printStackTrace();
        }
    }

    @Test
    @Parameters(method = "dataForFormatStringTest")
    public void formatStringTest(String stringToFormat, int requiredLength, String expectedNumberInNewFormat) {
        String result = testObject.formatString(stringToFormat, requiredLength);
        assertEquals(expectedNumberInNewFormat, result);
    }

    private Object[] dataForFormatStringTest() {
        return new TestData().testCase("123", 5, "00123")
                .testCase("-2", 5, "-00002")
                .testCase("252", 3, "252")
                .testCase("-252", 3, "-252")
                .getData();
    }

    private Object[] dataStringToIntegersArrayTest() {
        return new TestData()
                //empty String cases
                .testCase("", Collections.EMPTY_LIST)
                .testCase(null, Collections.EMPTY_LIST)
                .testCase(",,", Collections.EMPTY_LIST)
                //exception
                .testCase(" , , ", Collections.EMPTY_LIST)
                //one element list
                .testCase("25424", new ArrayList<String>(Arrays.asList("25424")))
                .testCase("-25424", new ArrayList<String>(Arrays.asList("-25424")))
                .testCase("+25424", new ArrayList<String>(Arrays.asList("+25424")))
                //numbers with length = 1
                .testCase("1,2,-3,+5", new ArrayList<String>(Arrays.asList("1", "2", "-3", "+5")))
                //input with spaces and empty elements
                .testCase("+1,2  ,-3,+5", new ArrayList<String>(Arrays.asList("+1", "2", "-3", "+5")))

                .testCase("1234,-44454410135456,102,563", new ArrayList<String>(Arrays.asList("00000000001234", "-44454410135456", "00000000000102", "00000000000563")))
                .testCase("+1234,-44454410135456,102,563", new ArrayList<String>(Arrays.asList("+00000000001234", "-44454410135456", "00000000000102", "00000000000563")))
                .testCase("1234,44454410135456,102,563", new ArrayList<String>(Arrays.asList("00000000001234", "44454410135456", "00000000000102", "00000000000563")))
                .testCase("1234,-44454410135456,102,563", new ArrayList<String>(Arrays.asList("00000000001234", "-44454410135456", "00000000000102", "00000000000563")))
                .getData();
    }
}