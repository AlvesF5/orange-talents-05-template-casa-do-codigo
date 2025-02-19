package br.com.casadocodigo.casadocodigo.pais.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

@Entity
public class Pais {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty @Column(nullable=false)
	private String nome;
	
	@OneToMany(mappedBy="pais")
	private List<Estado> estados;
	
	
	@Deprecated
	public Pais() {
	}

	public Pais(String nome) {
		this.nome=nome;
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	
	
	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	
	
}
