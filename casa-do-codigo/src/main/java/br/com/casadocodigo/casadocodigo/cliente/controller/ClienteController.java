package br.com.casadocodigo.casadocodigo.cliente.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.casadocodigo.casadocodigo.cliente.domain.Cliente;
import br.com.casadocodigo.casadocodigo.cliente.domain.ClienteRepository;
import br.com.casadocodigo.casadocodigo.cliente.domain.ClienteRequestDTO;
import br.com.casadocodigo.casadocodigo.cliente.domain.ClienteResponse;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@PersistenceContext
	EntityManager manager;
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@PostMapping
	public ResponseEntity<ClienteResponse> novoCliente(@RequestBody @Valid ClienteRequestDTO clienteDTO){
		Cliente cliente = clienteDTO.transformarParaCliente(manager);
		clienteRepository.save(cliente);
		return ResponseEntity.ok(new ClienteResponse(cliente));
	}
}
