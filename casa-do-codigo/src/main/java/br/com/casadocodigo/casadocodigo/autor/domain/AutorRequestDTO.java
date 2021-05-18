package br.com.casadocodigo.casadocodigo.autor.domain;

import javax.persistence.Lob;

public class AutorRequestDTO {
   private String nome;
   private String email;
   private String descricao;
   
   
   
    public void setNome(String nome) {
    	this.nome = nome;
    }


	public void setEmail(String email) {
		this.email = email;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Autor transformarParaAutor() {
		   return new Autor(nome,email,descricao);
	}


	public String getEmail() {
		return email;
	}
	
	
	
	
}
