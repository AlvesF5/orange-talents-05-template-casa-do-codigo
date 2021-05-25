package br.com.casadocodigo.casadocodigo.cliente.domain;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import br.com.casadocodigo.casadocodigo.livro.domain.ExisteIdValidator;

@Documented
@Constraint(validatedBy =  ExisteEstadoPaisValidator.class)
@Target({ElementType.FIELD, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExisteEstadoPais {
	
	String message() default "País com estado cadastrado, por favor, insira o estado";
	 
    Class<?>[] groups() default {};
 
    Class<? extends Payload>[] payload() default {};
 
    String fieldName();
    
    Class<?> domainClass();
    
}
