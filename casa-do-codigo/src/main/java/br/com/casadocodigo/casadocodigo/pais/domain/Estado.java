package br.com.casadocodigo.casadocodigo.pais.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

@Entity
public class Estado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty @Column(nullable=false)
	private String nome;
	
	@ManyToOne
	private Pais pais;
	

	public Estado() {
	}


	public Estado(String nome, Pais pais) {
		this.nome = nome;
		this.pais = pais;
	}


	public Long getId() {
		return id;
	}


	public String getNome() {
		return nome;
	}


	public Pais getPais() {
		return pais;
	}
	
	
	
}
