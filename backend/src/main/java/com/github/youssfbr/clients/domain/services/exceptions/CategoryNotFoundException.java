package com.github.youssfbr.clients.domain.services.exceptions;

public class CategoryNotFoundException extends RuntimeException {

    public CategoryNotFoundException() {
        super("Categoria não encontrada.");
    }

    public CategoryNotFoundException(String message) {
        super(message);
    }

}
