package com.auto.getremont.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)

public class RemontNotFoundException extends RuntimeException {

    public RemontNotFoundException( Long id) {
        super(String.format("%s not found with %s : '%s'", id));
    }

    public RemontNotFoundException( String name) {
        super(String.format("%s not found with %s : '%s'", name));
    }


}
