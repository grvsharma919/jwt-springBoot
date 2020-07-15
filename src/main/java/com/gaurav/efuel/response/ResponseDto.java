package com.gaurav.efuel.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDto <T>{

    private LocalDateTime timestamp;

    private  int status;

    private  String message;

    private boolean success;

    private T data;

    private Object error;
}
