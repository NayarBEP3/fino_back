package com.tiamat.fino.errorhandler;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Data
public class ErrorResponse {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Date timestamp;
    private int code;
    private String status;
    private String message;

    public ErrorResponse(Exception e, HttpStatus status) {
        this.timestamp = new Date();
        this.code = status.value();
        this.status = status.name();
        this.message = e.getMessage();
    }
}
