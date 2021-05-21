package br.com.casadocodigo.casadocodigo.livro.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LivroResponseDTO {
	
	private Long id;
	private String titulo;
	
	public LivroResponseDTO(Livro livro) {
		this.id=livro.getId();
		this.titulo=livro.getTitulo();
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}
	
	
	public static List<LivroResponseDTO> converter(List<Livro> livros){
		
		return livros.stream().map(LivroResponseDTO::new).collect(Collectors.toList());
		
	}
	
	
	
}
