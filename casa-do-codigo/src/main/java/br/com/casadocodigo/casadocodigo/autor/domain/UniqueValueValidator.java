package br.com.casadocodigo.casadocodigo.autor.domain;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.Assert;

public class UniqueValueValidator implements ConstraintValidator<UniqueValue, Object> {
	
	private String domainAttribute;
	private Class<?> classe;
	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public void initialize(UniqueValue params) {
		domainAttribute = params.fieldName();
		classe = params.domainClass();
	}
	

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		
		Query query =  manager.createQuery("select 1 from "+classe.getName()+" where " +domainAttribute+"=:value");
		query.setParameter("value",value);
		List<?> list = query.getResultList();
		Assert.state(list.size() <=1, "Foi encontrado mais de um"+classe+"com o atributo"+domainAttribute);
		return list.isEmpty();
	}

}
