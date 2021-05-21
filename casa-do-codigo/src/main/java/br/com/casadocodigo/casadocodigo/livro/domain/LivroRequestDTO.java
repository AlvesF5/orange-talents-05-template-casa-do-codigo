package br.com.casadocodigo.casadocodigo.livro.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.ISBN;
import org.hibernate.validator.constraints.ISBN.Type;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import br.com.casadocodigo.casadocodigo.autor.domain.Autor;
import br.com.casadocodigo.casadocodigo.autor.domain.AutorRepository;
import br.com.casadocodigo.casadocodigo.autor.domain.UniqueValue;
import br.com.casadocodigo.casadocodigo.categoria.domain.Categoria;
import br.com.casadocodigo.casadocodigo.categoria.domain.CategoriaRepository;

public class LivroRequestDTO {
	
	@NotBlank
	@UniqueValue(domainClass = Livro.class, fieldName = "titulo", message = "Já existe um livro com este titulo")
	private String titulo;
	
	@NotBlank
	@Size(max = 500)
	private String resumo;
	

	private String sumario;
	
	@NotNull
	@Min(20)
	private BigDecimal preco;
	
	@NotNull
	@Min(100)
	private int numeroPaginas;
	
	@NotBlank
	
	@UniqueValue(domainClass = Livro.class, fieldName = "isbn", message = "Já existe um livro com este isbn")
	@NotBlank
	@ISBN(type = Type.ANY)
	private String isbn;
	
	@Future @JsonFormat(pattern="dd/MM/yyyy", shape = Shape.STRING)
	private LocalDate dataPublicacao;
	
	@NotNull
	@ExisteId(domainClass = Categoria.class, fieldName = "id", message = "categoria não existente")
	private Long idCategoria;
	
	@NotNull
	@ExisteId(domainClass = Autor.class, fieldName = "id", message = "autor não existente")
	private Long idAutor;
	
	
	
	
	public Livro transformarParaLivro(EntityManager manager) {
		Categoria categoria = manager.find(Categoria.class, idCategoria);
		Autor autor = manager.find(Autor.class, idAutor);
		return new Livro(titulo,resumo,preco,numeroPaginas,isbn,dataPublicacao,categoria,autor);
	}




	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}


	public String getSumario() {
		return sumario;
	}

	public void setSumario(String sumario) {
		this.sumario = sumario;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public int getNumeroPaginas() {
		return numeroPaginas;
	}

	public void setNumeroPaginas(int numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(LocalDate dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public Long getIdCategoria() {
		return idCategoria;
	}


	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}

	public Long getIdAutor() {
		return idAutor;
	}

	public void setIdAutor(Long idAutor) {
		this.idAutor = idAutor;
	}


	
	
	
}
