package com.github.youssfbr.clients.api.controller.validators;

import com.github.youssfbr.clients.domain.repositories.IClientRepository;
import com.github.youssfbr.clients.domain.repositories.IDeviceBrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
@RequiredArgsConstructor
public class DeviceBrandExistsByIdValidator implements ConstraintValidator<DeviceBrandExistsById, Long> {

    private final IDeviceBrandRepository repository;

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        return repository.existsById(value);
    }

}
