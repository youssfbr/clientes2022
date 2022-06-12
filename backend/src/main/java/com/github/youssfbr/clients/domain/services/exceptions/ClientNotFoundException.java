package com.github.youssfbr.clients.domain.services.exceptions;

public class ClientNotFoundException extends RuntimeException {

    public ClientNotFoundException() {
        super("Cliente não encontrado.");
    }

    public ClientNotFoundException(String message) {
        super(message);
    }

}
