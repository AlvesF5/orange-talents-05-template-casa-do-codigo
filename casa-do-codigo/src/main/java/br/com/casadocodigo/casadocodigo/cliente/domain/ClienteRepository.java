package br.com.casadocodigo.casadocodigo.cliente.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
}
