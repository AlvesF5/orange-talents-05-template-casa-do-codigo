package br.com.casadocodigo.casadocodigo.autor.domain;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long>{
	Optional<Autor> findByEmail(String email);
}
