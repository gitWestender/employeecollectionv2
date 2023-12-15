package com.javalearn.employeecollectionv2.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmployeeAlreadyAddedException extends RuntimeException {
    public EmployeeAlreadyAddedException() {
    }

    public EmployeeAlreadyAddedException(String msg) {
        super(msg);
    }

    public EmployeeAlreadyAddedException(Throwable cause) {
        super(cause);
    }

    public EmployeeAlreadyAddedException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public EmployeeAlreadyAddedException(String msg, Throwable cause,
                                         boolean enableSuppression,
                                         boolean whriableStackTrace) {
        super(msg, cause, enableSuppression, whriableStackTrace);
    }
}
