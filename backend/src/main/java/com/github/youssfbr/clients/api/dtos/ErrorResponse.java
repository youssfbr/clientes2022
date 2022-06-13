package com.github.youssfbr.clients.api.dtos;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class ErrorResponse {

    private Integer status;
    private LocalDateTime timestamp;
    private String error;
    private String cause;
    private String message;
    private List<Field> fields;


    public static class Field {
        private String name;
        private String message;

        public Field(String name, String message) {
            this.name = name;
            this.message = message;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }


}
