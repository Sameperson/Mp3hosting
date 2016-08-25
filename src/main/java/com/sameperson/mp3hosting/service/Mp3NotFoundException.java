package com.sameperson.mp3hosting.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class Mp3NotFoundException extends RuntimeException {
    public Mp3NotFoundException() { super("Mp3 not found"); }
}
