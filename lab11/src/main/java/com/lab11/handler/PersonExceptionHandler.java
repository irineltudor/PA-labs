package com.lab11.handler;

import com.lab11.exception.InvalidFieldException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice
public class PersonExceptionHandler {

    @ExceptionHandler
    @ResponseBody
    public String handleInvalidFieldException(InvalidFieldException exception){
        return exception.getMessage();
    }
}
