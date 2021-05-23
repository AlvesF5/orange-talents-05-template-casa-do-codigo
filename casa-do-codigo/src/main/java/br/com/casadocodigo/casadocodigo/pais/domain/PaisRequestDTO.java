package br.com.casadocodigo.casadocodigo.pais.domain;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import br.com.casadocodigo.casadocodigo.autor.domain.UniqueValue;


public class PaisRequestDTO {
	@NotEmpty
	@UniqueValue(domainClass = Pais.class, fieldName = "nome")
	private String nome;
	private List<Estado> estados;
	
	
	
	public Pais transformarParaPais() {
		return new Pais(nome);
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Estado> getEstados() {
		return estados;
	}
	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}
	
	
	
}
