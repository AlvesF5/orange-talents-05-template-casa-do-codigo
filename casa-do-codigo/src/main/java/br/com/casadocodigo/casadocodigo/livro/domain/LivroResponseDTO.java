package br.com.casadocodigo.casadocodigo.livro.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.casadocodigo.casadocodigo.autor.domain.Autor;
import br.com.casadocodigo.casadocodigo.categoria.domain.Categoria;

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
	
	
	public static String  detalhesLivro(Optional<Livro> livro) {
		return livro.toString();
	}
	
	
}
