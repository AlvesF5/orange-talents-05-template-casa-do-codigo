package br.com.casadocodigo.casadocodigo.autor.domain;


public class AutorRequestDTO {
	
   private String nome;
   @UniqueValue(domainClass = Autor.class, fieldName = "email")
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
