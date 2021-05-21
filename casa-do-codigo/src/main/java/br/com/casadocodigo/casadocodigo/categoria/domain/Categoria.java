package br.com.casadocodigo.casadocodigo.categoria.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Categoria {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty @Column(nullable=false)
	private String nome;
	
	@Deprecated
	public Categoria() {
		
	}


	public Categoria(String nome) {
		this.nome = nome;
	}


	public String getNome() {
		return nome;
	}


	public Long getId() {
		return id;
	}
	
	
	
	
}
