package br.com.casadocodigo.casadocodigo.pais.controller;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.casadocodigo.casadocodigo.pais.domain.Estado;
import br.com.casadocodigo.casadocodigo.pais.domain.EstadoRepository;
import br.com.casadocodigo.casadocodigo.pais.domain.EstadoRequestDTO;
import br.com.casadocodigo.casadocodigo.pais.domain.Pais;

@RestController
@RequestMapping("/estados")
public class EstadoController {
	
	@Autowired
	EstadoRepository estadoRepository;
	
	@PersistenceContext
	EntityManager manager;
	
	@PostMapping
	public ResponseEntity<?> novoEstado(@RequestBody @Valid EstadoRequestDTO estadoDTO){
		
		Estado estado = estadoDTO.transformarParaEstado(manager);
		String nomeEstado = estadoDTO.getNome();
		Long idPais = estado.getPais().getId();
		
		Query query = manager.createQuery("select e  from Estado e  where e.nome = :nomeEstado    and e.pais.id = :idPais");
		query.setParameter("nomeEstado", nomeEstado);
		query.setParameter("idPais", idPais);
		
	  
		
		if(query.getResultList().size()>0) {
			return ResponseEntity.badRequest().build();
		}
		estadoRepository.save(estado);
		return ResponseEntity.ok().build();
	}
}
