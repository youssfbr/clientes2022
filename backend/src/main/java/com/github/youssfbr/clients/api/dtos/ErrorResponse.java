package com.github.youssfbr.clients.api.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {

    private Integer statusCode;
    private String status;
    private OffsetDateTime timestamp;
    private String cause;
    private String message;
    private Map<String, List<String>> errors;

}
