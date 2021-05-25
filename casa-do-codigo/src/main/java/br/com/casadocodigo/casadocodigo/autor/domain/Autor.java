package br.com.casadocodigo.casadocodigo.autor.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;



@Entity
public class Autor {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotBlank @Column(nullable=false)
	private String nome;
	@Email(message="Insira um e-mail válido") @NotBlank @Column(nullable=false)
	private String email;
	@NotBlank  @Length(max= 400) @Column(nullable=false)
	private String descricao;
	@NotNull @Column(nullable=false)
	private LocalDateTime dataCriacao = LocalDateTime.now();
	
	
	@Deprecated
	public Autor() {
	}

	public Autor(String nome, String email, String descricao) {
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getDescricao() {
		return descricao;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	@Override
	public String toString() {
		return "Autor [nome=" + nome + ", email=" + email + ", descricao=" + descricao + ", dataCriacao="
				+ dataCriacao + "]";
	}
	
	
	
	
}
