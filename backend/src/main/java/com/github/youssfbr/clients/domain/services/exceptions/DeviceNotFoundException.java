package com.github.youssfbr.clients.domain.services.exceptions;

public class DeviceNotFoundException extends RuntimeException {

    public DeviceNotFoundException() {
        super("Dispositivo não encontrado.");
    }

    public DeviceNotFoundException(String message) {
        super(message);
    }

}
