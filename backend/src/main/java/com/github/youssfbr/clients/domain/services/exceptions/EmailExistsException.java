package com.github.youssfbr.clients.domain.services.exceptions;

public class EmailExistsException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public EmailExistsException() {
        super("Email já cadastrado.");
    }

    public EmailExistsException(String message) {
        super(message);
    }

}
