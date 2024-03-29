package br.com.dalessio.auto.category.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import br.com.dalessio.auto.category.utils.ValidateCpfCnpj;

@Constraint(validatedBy = { ValidateCpfCnpj.class })
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(value = RetentionPolicy.RUNTIME)
public @interface CpfCnpj {

	String message() default "{validation.CpfCnpj.message}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
