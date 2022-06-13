package com.github.youssfbr.clients.api.controller.handlers;

import com.github.youssfbr.clients.api.dtos.ErrorResponse;
import com.github.youssfbr.clients.domain.services.exceptions.EmailExistsException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException exception,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request
    ) {
        ErrorResponse body = ErrorResponse.builder()
                .statusCode(status.value())
                .status(status.getReasonPhrase())
                .cause(exception.getClass().getSimpleName())
                .timestamp(LocalDateTime.now())
                .message("Um ou mais campos estão inválidos. Faça o preenchimento correto e tente novamente.")
                .errors(convertFieldErrors(exception.getBindingResult().getFieldErrors()))
                .build();

        return new ResponseEntity<>(body, status);
    }

    @ExceptionHandler(EmailExistsException.class)
    public ResponseEntity<Object> emailExists(EmailExistsException exception) {

        ErrorResponse message = getError(HttpStatus.BAD_REQUEST, exception);

        return ResponseEntity.status(message.getStatusCode()).body(message);
    }

    private Map<String, List<String>> convertFieldErrors(List<FieldError> fieldErrors) {
        HashMap<String, List<String>> errors = new HashMap<>();
        fieldErrors.stream().forEach(fieldError -> {
            String field = fieldError.getField();
            if (errors.containsKey(field)) {
                errors.get(field).add(fieldError.getDefaultMessage());
            } else {
                errors.put(
                        field,
                        Stream.of(fieldError.getDefaultMessage()).collect(Collectors.toList())
                );
            }
        });
        return errors;
    }

    private ErrorResponse getError(HttpStatus status, Exception exception) {
        return ErrorResponse.builder()
                .statusCode(status.value())
                .status(status.getReasonPhrase())
                .cause(exception.getClass().getSimpleName())
                .timestamp(LocalDateTime.now())
                .message(exception.getMessage())
                .build();
    }

}
