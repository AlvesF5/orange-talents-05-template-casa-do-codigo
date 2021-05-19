package br.com.casadocodigo.casadocodigo.categoria.domain;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
	Optional<Categoria> findByNome(String nome);
}
