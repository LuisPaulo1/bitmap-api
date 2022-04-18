package com.bitmap.service.validation;

import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({PARAMETER})
@Retention(RUNTIME)
@Constraint(validatedBy = { VetorSizeValidator.class })
public @interface VetorSize {
	
	String message() default "tamanho do vetor inválido";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
	
	int max();

}
