package br.com.casadocodigo.casadocodigo.autor.controller;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import br.com.casadocodigo.casadocodigo.autor.domain.Autor;
import br.com.casadocodigo.casadocodigo.autor.domain.AutorRepository;
import br.com.casadocodigo.casadocodigo.autor.domain.AutorRequestDTO;
import br.com.casadocodigo.casadocodigo.autor.domain.AutorResponseDTO;

@RestController
@RequestMapping("/autores")
public class AutorController {
	
	@Autowired
	private AutorRepository autorRepository;
	
	@PostMapping
	public ResponseEntity<AutorResponseDTO> salvarAutor(@RequestBody @Valid AutorRequestDTO autorDTO) {
		
		Autor autor = autorDTO.transformarParaAutor();
		
		autorRepository.save(autor);
		
		return ResponseEntity.ok().build();
		
	}
	
}
