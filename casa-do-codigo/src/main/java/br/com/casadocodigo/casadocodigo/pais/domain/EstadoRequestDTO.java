package br.com.casadocodigo.casadocodigo.pais.domain;

import javax.persistence.EntityManager;

import br.com.casadocodigo.casadocodigo.autor.domain.UniqueValue;
import br.com.casadocodigo.casadocodigo.categoria.domain.Categoria;
import br.com.casadocodigo.casadocodigo.livro.domain.ExisteId;

public class EstadoRequestDTO {
	
	
	private String nome;
	@ExisteId(domainClass = Pais.class, fieldName = "id", message = "pais não existente")
	private Long idPais;
	
	
	public Estado transformarParaEstado(EntityManager manager) {
		Pais pais = manager.find(Pais.class, idPais);
		return new Estado(nome,pais);
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}


	public Long getIdPais() {
		return idPais;
	}


	public void setIdPais(Long idPais) {
		this.idPais = idPais;
	}




	
	
	
	
}
