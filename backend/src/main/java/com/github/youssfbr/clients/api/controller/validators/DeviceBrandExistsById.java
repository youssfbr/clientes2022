package com.github.youssfbr.clients.api.controller.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DeviceBrandExistsByIdValidator.class)
public @interface DeviceBrandExistsById {

    String message() default "Marca do Dispositivo com id ${validatedValue} não existe.";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
