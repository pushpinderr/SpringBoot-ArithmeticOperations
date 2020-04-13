package com.springboot.arithemeticservice.infrastructure.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@SuppressWarnings({"unchecked", "rawtypes"})
@ControllerAdvice
public class ArithmeticServiceExceptionHandler {
    @ExceptionHandler(ServletRequestBindingException.class)
    public final ResponseEntity<Object> handleHeaderException(Exception exception, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(exception.getLocalizedMessage());
        return new ResponseEntity(new ArithmeticServiceErrorResponse("Bad Request", details), BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public final ResponseEntity<Object> handleArithmeticDataExceptions(Exception exception, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(exception.getLocalizedMessage());
        return new ResponseEntity(new ArithmeticServiceErrorResponse("Bad Request: Data request is not readable.", details), BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception exception, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(exception.getLocalizedMessage());
        return new ResponseEntity(new ArithmeticServiceErrorResponse("Arithmetic Server Error", details), INTERNAL_SERVER_ERROR);
    }
}