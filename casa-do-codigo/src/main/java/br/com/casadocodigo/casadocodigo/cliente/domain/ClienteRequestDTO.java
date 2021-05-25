package br.com.casadocodigo.casadocodigo.cliente.domain;



import java.util.Optional;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.lang.Nullable;

import com.sun.istack.NotNull;


import br.com.casadocodigo.casadocodigo.autor.domain.UniqueValue;
import br.com.casadocodigo.casadocodigo.livro.domain.ExisteId;
import br.com.casadocodigo.casadocodigo.pais.domain.Estado;
import br.com.casadocodigo.casadocodigo.pais.domain.Pais;

@ExisteEstadoPais(domainClass = Estado.class, fieldName = "pais_id")
public class ClienteRequestDTO {
	
	@UniqueValue(domainClass = Cliente.class, fieldName = "email") 
	@Email @NotBlank 
	private String email;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	private String sobrenome;
	
	@UniqueValue(domainClass = Cliente.class, fieldName = "documento")
    @NotBlank @CPForCNPJ
	private String documento;
	
	@NotBlank
	private String endereco;
	
	@NotBlank
	private String complemento;
	
	@NotBlank
	private String cidade;
	
	@NotNull
	@ExisteId(domainClass = Pais.class, fieldName = "id", message = "País não existente")
	private Long idPais;
	
	
	private Long idEstado;
	
    @NotBlank
	private String telefone;
	
    @NotBlank
	private String cep;
    
    
    
    public Cliente transformarParaCliente(EntityManager manager) {
    	
    	Pais pais = manager.find(Pais.class, idPais);
    	
    	Estado  estado = null;
    	
    	Optional<Long> possivelEstado = Optional.ofNullable(idEstado);
    	
    	
    	if(possivelEstado.isPresent()) {
    		 estado = manager.find(Estado.class, idEstado);  
    	}	  
    
    	return new Cliente(email,nome,sobrenome,documento,endereco,complemento,cidade,pais, estado, telefone,cep);
    	
    }
    
	

	public String getEmail() {
		return email;
	}


	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}


	public String getDocumento() {
		return documento;
	}


	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getEndereco() {
		return endereco;
	}


	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCidade() {
		return cidade;
	}


	public Long getIdPais() {
		return idPais;
	}



	public Long getIdEstado() {
		return idEstado;
	}



	public String getTelefone() {
		return telefone;
	}



	public String getCep() {
		return cep;
	}


    
    
    
	
}
