package com.student.sms.exception;

import com.student.sms.service.StudentUpdateException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.sql.Date;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(value= StudentUpdateException.class)

    public ResponseEntity <ErrorMessage> CustomException(StudentUpdateException ex, WebRequest request) {
        ErrorMessage message=new ErrorMessage(
                HttpStatus.NOT_FOUND.value(),
                new Date(0),
                ex.getMessage(),
                request.getDescription(false));

        return new ResponseEntity<ErrorMessage>(message, HttpStatus.NOT_FOUND);
    }
}
