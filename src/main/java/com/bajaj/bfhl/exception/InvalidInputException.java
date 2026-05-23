package com.bajaj.bfhl.exception;

/**
 * Custom runtime exception to handle invalid input payloads.
 */
public class InvalidInputException extends RuntimeException {

    public InvalidInputException(String message) {
        super(message);
    }
}
