package br.com.casadocodigo.casadocodigo.cliente.domain;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;

import org.hibernate.validator.constraints.CompositionType;
import org.hibernate.validator.constraints.ConstraintComposition;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

@CPF
@CNPJ
@ConstraintComposition(CompositionType.OR) 
@ReportAsSingleViolation 
@Constraint(validatedBy = {} ) 
@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CPForCNPJ {
	
	String message() default "Documento inválido! Insira um CPF ou um CNPJ";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
   
    
}
