package com.brainlab.codingchallenge.CodingChallenge.util;

import java.util.ArrayList;
import java.util.List;

/**
 * class to manage the execution of several test cases for the same method
 */
public class TestData {
    private final List<Object[]> cases = new ArrayList<>();

    public TestData testCase(Object... parameters) {
        cases.add(parameters);
        return this;
    }

    public Object[] getData() {
        return cases.toArray();
    }
}
