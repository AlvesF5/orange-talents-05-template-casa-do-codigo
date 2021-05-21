package br.com.casadocodigo.casadocodigo.livro.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.casadocodigo.casadocodigo.livro.domain.Livro;
import br.com.casadocodigo.casadocodigo.livro.domain.LivroRepository;
import br.com.casadocodigo.casadocodigo.livro.domain.LivroRequestDTO;

@RestController
@RequestMapping("/livros")
public class LivroController {
	
	@Autowired
	private LivroRepository livroRepository;
	
	@PersistenceContext
	private EntityManager manager;
	
	
	@PostMapping
	public ResponseEntity<?> novoLivro(@RequestBody @Valid LivroRequestDTO livroDTO){
		
		Livro livro = livroDTO.transformarParaLivro(manager);
		
		livroRepository.save(livro);
		
		return ResponseEntity.ok().build();
	}
	
}
