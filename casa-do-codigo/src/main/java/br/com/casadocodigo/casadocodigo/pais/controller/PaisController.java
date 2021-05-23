package br.com.casadocodigo.casadocodigo.pais.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.casadocodigo.casadocodigo.pais.domain.Pais;
import br.com.casadocodigo.casadocodigo.pais.domain.PaisRepository;
import br.com.casadocodigo.casadocodigo.pais.domain.PaisRequestDTO;

@RestController
@RequestMapping("pais")
public class PaisController {
	
	@Autowired
	PaisRepository paisRepository;
	
	@PostMapping
	public ResponseEntity<?> novoPais(@RequestBody @Valid PaisRequestDTO paisDTO){
		Pais pais = paisDTO.transformarParaPais();
		paisRepository.save(pais);
		return ResponseEntity.ok().build();
	}
	
}
