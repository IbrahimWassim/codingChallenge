package com.brainlab.codingchallenge.CodingChallenge.errorHandaling;


import com.brainlab.codingchallenge.CodingChallenge.exceptions.InconvertibleToNumberException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandlingController {

    @ExceptionHandler(InconvertibleToNumberException.class)
    public ResponseEntity<ExceptionResponse> generalException(InconvertibleToNumberException e) throws Exception {
        ExceptionResponse eR = new ExceptionResponse();
        eR.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        eR.setDescription(e.getDescription());
        return new ResponseEntity<ExceptionResponse>(eR, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}