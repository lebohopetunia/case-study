package com.java.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FOUND)
public class CustomerAlreadyExist extends Exception{
    public CustomerAlreadyExist(String message) {
        super(message);
    }
}
