package com.brainlab.codingchallenge.CodingChallenge.exceptions;

import org.springframework.stereotype.Component;

/**
 * @author wassim
 * This exceptions is raised when the given input contains an error in the numbers
 */
@Component
public class InconvertibleToNumberException extends Exception {
    /**
     *
     */
    private static final long serialVersionUID = 6520215012144322290L;
    private int code;
    private String InconvertibleNumber;
    private String description;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInconvertibleNumber() {
        return InconvertibleNumber;
    }

    public void setInconvertibleNumber(String inconvertibleNumber) {
        InconvertibleNumber = inconvertibleNumber;
    }
}