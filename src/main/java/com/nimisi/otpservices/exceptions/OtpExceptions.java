package com.nimisi.otpservices.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class OtpExceptions  extends RuntimeException{
    public OtpExceptions(String message){
        super(message);
    }
}
