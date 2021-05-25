package br.com.casadocodigo.casadocodigo.cliente.domain;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.casadocodigo.casadocodigo.pais.domain.Estado;





public class ExisteEstadoPaisValidator implements ConstraintValidator<ExisteEstadoPais, ClienteRequestDTO> {

	private String domainAttribute;
	private Class<?> classe;
	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public void initialize(ExisteEstadoPais params) {
		domainAttribute = params.fieldName();
		classe = params.domainClass();
	}
	

	@Override
	public boolean isValid(ClienteRequestDTO cliente, ConstraintValidatorContext context) {
		
		Long idPais = cliente.getIdPais();
		Optional<Long> idEstado = Optional.ofNullable(cliente.getIdEstado());
		
		
		Query query =  manager.createQuery("select 1 from " + classe.getName()+" where " +domainAttribute+"=:value");
		query.setParameter("value",idPais);
		
		List<?> list = query.getResultList();
		
		Estado estado = null;
		
		if(idEstado.isPresent()) {
			estado = manager.find(Estado.class, cliente.getIdEstado());
		}
	
		
		if(list.size() > 0 && estado!=null && estado.getPais().getId() == idPais ) {
			return true;
		}else if(list.size()==0)
			return true;
		
        return false;
	}
	

}
