package com.github.youssfbr.clients.api.controller.handlers;

import com.github.youssfbr.clients.api.dtos.ErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException exception,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request
    ) {

        ArrayList<ErrorResponse.Field> fields = new ArrayList<>();

        List<ObjectError> allErrors = exception.getBindingResult().getAllErrors();

        for (ObjectError error : allErrors) {
            String name = ((FieldError) error).getField();
            String message = error.getDefaultMessage();

            fields.add(new ErrorResponse.Field(name, message));
        }

        ErrorResponse body = ErrorResponse.builder()
                .status(status.value())
                .error(status.getReasonPhrase())
                .cause(exception.getClass().getSimpleName())
                .timestamp(LocalDateTime.now())
                .message("Um ou mais campos estão inválidos. Faça o preenchimento correto e tente novamente.")
                .fields(fields)
                .build();

        return new ResponseEntity<>(body, status);
    }
}
