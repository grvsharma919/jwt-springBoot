package com.gaurav.efuel.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {
    public static Map<String, Object> getFieldErrorResponse(BindingResult bindingResult) {
        Map<String, Object> map = new HashMap<>();
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            if (map.put(fieldError.getField(), fieldError.getDefaultMessage()) != null) {
                throw new IllegalStateException("Duplicate key");
            }
        }
        return map;
    }

    public static ResponseEntity generateResponse(HttpStatus status, boolean success,
                                                  String message, Object responseData, Object error) {
        return new ResponseEntity<>(
                ResponseDto.builder().timestamp(LocalDateTime.now())
                        .status(status.value())
                        .message(message)
                        .success(success)
                        .data(responseData)
                        .error(error)
                        .build(), status);
    }

}
