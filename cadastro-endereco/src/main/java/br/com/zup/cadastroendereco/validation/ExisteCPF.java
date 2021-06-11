package br.com.zup.cadastroendereco.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = ValidacaoCPF.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ExisteCPF {
	String message() default "Este CPF já existe!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
