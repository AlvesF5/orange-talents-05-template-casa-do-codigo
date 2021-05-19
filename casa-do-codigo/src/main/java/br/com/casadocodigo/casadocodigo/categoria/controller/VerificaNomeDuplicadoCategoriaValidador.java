/**
 * 
 */
package br.com.casadocodigo.casadocodigo.categoria.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.casadocodigo.casadocodigo.categoria.domain.Categoria;
import br.com.casadocodigo.casadocodigo.categoria.domain.CategoriaRepository;
import br.com.casadocodigo.casadocodigo.categoria.domain.CategoriaRequestDTO;

/**
 * @author Matheus.Cruz
 *
 */
@Component
public class VerificaNomeDuplicadoCategoriaValidador implements Validator{
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		return CategoriaRequestDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		if(errors.hasErrors()) {
			return;
		}
		
		CategoriaRequestDTO request = (CategoriaRequestDTO) target;
		
		Optional<Categoria> possivelCategoria = categoriaRepository.findByNome(request.getNome());
		
		if(possivelCategoria.isPresent()) {
			errors.rejectValue("nome", null, "Já existe uma categoria com esse nome");
		}
		
	}

}
