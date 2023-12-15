package com.javalearn.employeecollectionv2.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException() {
    }

    public EmployeeNotFoundException(String msg) {
        super(msg);
    }

    public EmployeeNotFoundException(Throwable cause) {
        super(cause);
    }

    public EmployeeNotFoundException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public EmployeeNotFoundException(String msg, Throwable cause,
                                     boolean enableSuppression,
                                     boolean whriableStackTrace) {
        super(msg, cause, enableSuppression, whriableStackTrace);
    }
}
