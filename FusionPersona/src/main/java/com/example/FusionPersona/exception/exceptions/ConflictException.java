package com.example.FusionPersona.exception.exceptions;

import java.util.List;

public class ConflictException extends RuntimeException{

    private static final String GENERIC_DESCRIPTION = "Conflict in: ";

    public ConflictException(String detail) {
        super(GENERIC_DESCRIPTION.concat(detail));
    }
}
