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
import static org.junit.Assert.assertThat;

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

    @Test
    @Parameters(method = "dataForInputStringValidation")
    public void validateInputString(String inputString, boolean expectedResult) throws InconvertibleToNumberException {
        assertEquals(testObject.validateInputString(inputString),expectedResult);

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
                .testCase("a random string", null)
                .testCase(null, Collections.EMPTY_LIST)
                .testCase(",,", null)
                //exception
                .testCase(" , , ", null)
                //one element list
                .testCase("25424",Arrays.asList("25424"))
                .testCase("-25424", Arrays.asList("-25424"))
                .testCase("+25424", Arrays.asList("+25424"))
                //numbers with length = 1
                .testCase("1,2,-3,+5", Arrays.asList("1", "2", "-3", "+5"))
                //input with spaces and empty elements
                .testCase("+1,2  ,-3,+5", Arrays.asList("+1", "2", "-3", "+5"))

                .testCase("1234,-44454410135456,102,563",Arrays.asList("00000000001234", "-44454410135456", "00000000000102", "00000000000563"))
                .testCase("+1234,-44454410135456,102,563",Arrays.asList("+00000000001234", "-44454410135456", "00000000000102", "00000000000563"))
                .testCase("1234,44454410135456,102,563",Arrays.asList("00000000001234", "44454410135456", "00000000000102", "00000000000563"))
                .testCase("1234,-44454410135456,102,563", Arrays.asList("00000000001234", "-44454410135456", "00000000000102", "00000000000563"))
                .getData();
    }

    private  Object[] dataForInputStringValidation() {
        return new TestData()
                .testCase("a random string", false)
                .testCase("123", true)
                .testCase("-123", true)
                .testCase("-252 3", true)
                .testCase("-252 3,200114", true)
                .testCase("-2523, ", false)
                .testCase("-2523, 5", true)
                .testCase("  -2523, ,", false)
                .testCase("  ,, ,", false)
                .testCase("0000", true)
                .getData();

    }
}