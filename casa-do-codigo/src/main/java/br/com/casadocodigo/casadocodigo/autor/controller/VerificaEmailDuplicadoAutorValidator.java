package br.com.casadocodigo.casadocodigo.autor.controller;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.casadocodigo.casadocodigo.autor.domain.Autor;
import br.com.casadocodigo.casadocodigo.autor.domain.AutorRepository;
import br.com.casadocodigo.casadocodigo.autor.domain.AutorRequestDTO;

@Component
public class VerificaEmailDuplicadoAutorValidator implements Validator {
	
	@Autowired
	private AutorRepository autorRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		return AutorRequestDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		if(errors.hasErrors()) {
			return;
		}
		
		AutorRequestDTO request = (AutorRequestDTO) target;
	
		
		Optional<Autor> possivelAutor = autorRepository.findByEmail(request.getEmail());
		
		if(possivelAutor.isPresent()) {
			errors.rejectValue("email", null, "Já existe um autor com esse email");
		}
		
		
	}

}
