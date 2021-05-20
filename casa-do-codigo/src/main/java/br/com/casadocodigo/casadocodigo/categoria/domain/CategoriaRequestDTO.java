package br.com.casadocodigo.casadocodigo.categoria.domain;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonCreator;

import br.com.casadocodigo.casadocodigo.autor.domain.Autor;
import br.com.casadocodigo.casadocodigo.autor.domain.UniqueValue;

public class CategoriaRequestDTO {
	@NotEmpty
	@UniqueValue(domainClass = Categoria.class, fieldName = "nome")
	private String nome;
	
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public Categoria transformarParaCategoria() {
		return new Categoria(nome);
	}

	public String getNome() {
		return this.nome;
	}
	
	
	
	
}
