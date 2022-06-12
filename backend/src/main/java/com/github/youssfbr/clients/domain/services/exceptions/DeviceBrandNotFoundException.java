package com.github.youssfbr.clients.domain.services.exceptions;

public class DeviceBrandNotFoundException extends RuntimeException {

    public DeviceBrandNotFoundException() {
        super("Marca não encontrada.");
    }

    public DeviceBrandNotFoundException(String message) {
        super(message);
    }

}
