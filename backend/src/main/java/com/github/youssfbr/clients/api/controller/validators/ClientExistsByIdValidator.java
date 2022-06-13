package com.github.youssfbr.clients.api.controller.validators;

import com.github.youssfbr.clients.domain.repositories.IClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
@RequiredArgsConstructor
public class ClientExistsByIdValidator implements ConstraintValidator<ClientExistsById, Long> {

    private final IClientRepository repository;

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        return repository.existsById(value);
    }

}
