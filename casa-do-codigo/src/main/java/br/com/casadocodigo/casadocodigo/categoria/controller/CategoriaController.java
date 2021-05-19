package br.com.casadocodigo.casadocodigo.categoria.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.casadocodigo.casadocodigo.categoria.domain.Categoria;
import br.com.casadocodigo.casadocodigo.categoria.domain.CategoriaRepository;
import br.com.casadocodigo.casadocodigo.categoria.domain.CategoriaRequestDTO;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private VerificaNomeDuplicadoCategoriaValidador verificaNomeDuplicadoCategoriaValidador;
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(verificaNomeDuplicadoCategoriaValidador);
	}
	
	@PostMapping
	public ResponseEntity<?> novaCategoria(@RequestBody @Valid CategoriaRequestDTO categoriaDTO){
		
		Categoria categoria = categoriaDTO.transformarParaCategoria();
		
		categoriaRepository.save(categoria);
		
		return ResponseEntity.ok().build();
		
	}
	
	
}
