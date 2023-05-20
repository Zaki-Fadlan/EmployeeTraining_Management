package com.example.aeon.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintDeclarationException;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends ConstraintDeclarationException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
