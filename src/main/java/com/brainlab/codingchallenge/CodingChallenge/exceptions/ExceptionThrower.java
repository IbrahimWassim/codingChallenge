package com.brainlab.codingchallenge.CodingChallenge.exceptions;

/**
 *
 */
public class ExceptionThrower {
    public void throwGeneralException() throws Exception {
        Exception e = new Exception("Error from a general Exception");
        throw e;

    }

    public void throwInconvertibleToNumberException(String stringToparse) throws InconvertibleToNumberException {
        InconvertibleToNumberException e = new InconvertibleToNumberException();
        e.setCode(500);
        e.setDescription("Unable to parse  the  input : "+stringToparse);
        System.out.println("\n\n\n\n\n11111111111111111\n\n\n");
        throw e;

    }
}
