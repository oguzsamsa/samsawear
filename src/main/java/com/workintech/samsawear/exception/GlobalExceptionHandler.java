package com.workintech.samsawear.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ApiErrorResponse> handleException(ApiException apiException){
        log.error("ApiException occurred! " + apiException.getLocalizedMessage());
        ApiErrorResponse errorResponse = new ApiErrorResponse(apiException.getMessage(), apiException.getHttpStatus(), System.currentTimeMillis());

        return new ResponseEntity<>(errorResponse, apiException.getHttpStatus());
    }

    @ExceptionHandler
    public ResponseEntity<ApiErrorResponse> handleException(Exception exception){
        log.error("Exception occurred! " + exception.getLocalizedMessage());
        ApiErrorResponse errorResponse = new ApiErrorResponse(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, System.currentTimeMillis());

        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
