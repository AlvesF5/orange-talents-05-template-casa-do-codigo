package br.com.casadocodigo.casadocodigo.livro.domain;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import br.com.casadocodigo.casadocodigo.autor.domain.UniqueValueValidator;

@Documented
@Constraint(validatedBy =  ExisteIdValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExisteId {
	
	String message() default "Id não encontrado";
	 
    Class<?>[] groups() default {};
 
    Class<? extends Payload>[] payload() default {};
 
    String fieldName();
    
    Class<?> domainClass();
}
