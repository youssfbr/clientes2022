package com.github.youssfbr.clients.domain.services.exceptions;

import javax.persistence.EntityNotFoundException;

public class ClientNotFoundException extends EntityNotFoundException {

    public ClientNotFoundException() {
        super("Cliente não encontrado.");
    }

    public ClientNotFoundException(String message) {
        super(message);
    }

}
