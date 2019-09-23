package com.brainlab.codingchallenge.CodingChallenge.exceptions;

/**
 *
 */
public class ExceptionThrower {
    public void throwGeneralException() throws Exception {
        Exception e = new Exception("Erro from a general Exception");
        throw e;

    }

    public void throwCategoryNotFoundException(String nonConvetableNumber) throws InconvertibleToNumberException {
        InconvertibleToNumberException e = new InconvertibleToNumberException();
        e.setCode(500);
        e.setDescription("The found string" + e.getInconvertibleNumber() + " is not convertible to a  valid number");
        throw e;

    }
}
