package com.javalearn.employeecollectionv2.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmployeeIllegalNameException extends RuntimeException {
    public EmployeeIllegalNameException(String msg) {
        super(msg);
    }
}
