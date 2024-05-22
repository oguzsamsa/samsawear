package com.workintech.samsawear.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class ApiErrorResponse {
    private String message;
    private HttpStatus httpStatus;
    private Long timestamp;
}
