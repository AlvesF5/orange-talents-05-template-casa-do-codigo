package br.com.casadocodigo.casadocodigo.categoria.domain;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonCreator;

public class CategoriaRequestDTO {
	@NotEmpty
	private String nome;
	
	@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
	public CategoriaRequestDTO(String nome) {
		this.nome = nome;
	}

	

	public Categoria transformarParaCategoria() {
		return new Categoria(this.nome);
	}

	public String getNome() {
		return this.nome;
	}
	
	
	
	
}
