package br.com.casadocodigo.casadocodigo.livro.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import br.com.casadocodigo.casadocodigo.autor.domain.Autor;
import br.com.casadocodigo.casadocodigo.categoria.domain.Categoria;

@JsonInclude(Include.NON_EMPTY.NON_ABSENT)
public class LivroResponseDTO {
	
	private Long id;
	private String titulo;
	private  String resumo;
	private String sumario;
	private BigDecimal preco;
	private Integer numeroPaginas;
	private String isbn;
	private LocalDate dataPublicacao;
	private Categoria categoria;
	private Autor autor;

	//Construtor usado no endpoint para listar todos os livros trazendo apenas o id e o título
	public LivroResponseDTO(Livro livro) {
		this.id=livro.getId();
		this.titulo=livro.getTitulo();
		
	}
	
	//Construtor usado no endpoint para listar o detalhes de um livro passando seu id como parâmetro
	public LivroResponseDTO(Optional<Livro> livro) {
		this.id=livro.get().getId();
		this.titulo=livro.get().getTitulo();
		this.resumo=livro.get().getResumo();
		this.sumario=livro.get().getSumario();
		this.preco=livro.get().getPreco();
		this.numeroPaginas=livro.get().getNumeroPaginas();
		this.isbn=livro.get().getIsbn();
		this.dataPublicacao=livro.get().getDataPublicacao();
		this.categoria=livro.get().getCategoria();
		this.autor=livro.get().getAutor();
		
	}


	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}
	
	
	public String getResumo() {
		return resumo;
	}
	

	public String getSumario() {
		return sumario;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public Autor getAutor() {
		return autor;
	}

	public static List<LivroResponseDTO> converter(List<Livro> livros){
		
		return livros.stream().map(LivroResponseDTO::new).collect(Collectors.toList());
		
	}
	
	
	
	
}
