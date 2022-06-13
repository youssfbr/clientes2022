package com.github.youssfbr.clients.api.dtos;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Data
@Builder
public class ErrorResponse {

    private Integer statusCode;
    private String status;
    private LocalDateTime timestamp;
    private String cause;
    private String message;
    private Map<String, List<String>> errors;

}
