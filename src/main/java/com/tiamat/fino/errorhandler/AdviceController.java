package com.tiamat.fino.errorhandler;

import com.tiamat.fino.exceptions.BadDataException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AdviceController {

    @ExceptionHandler(BadDataException.class)
    public ResponseEntity<ErrorResponse> badDataException(Exception e) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        return new ResponseEntity<ErrorResponse>(new ErrorResponse(e, status), status);
    }

}
