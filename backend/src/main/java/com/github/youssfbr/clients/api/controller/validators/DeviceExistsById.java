package com.github.youssfbr.clients.api.controller.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DeviceExistsByIdValidator.class)
public @interface DeviceExistsById {

    String message() default "Dispositivo com id ${validatedValue} não existe.";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
