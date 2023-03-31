package com.example.FusionPersona.exception.exceptions;

public class BadRequestException extends RuntimeException {

    private static final String GENERIC_DESCRIPTION = "Invalid Request: ";

    public BadRequestException(String detail) {
        super(GENERIC_DESCRIPTION.concat(detail));
    }
}
