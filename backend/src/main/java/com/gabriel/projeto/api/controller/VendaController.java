package com.gabriel.projeto.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.gabriel.projeto.domain.exception.AutomovelVendidoException;
import com.gabriel.projeto.domain.model.Automovel;
import com.gabriel.projeto.domain.repository.AutomovelRepository;

@CrossOrigin
@RestController
public class VendaController {
	
	@Autowired
	private AutomovelRepository automovelRepository;
	
	@GetMapping("/venda/{automovelId}")
	public ResponseEntity<Automovel> vender(@PathVariable Long automovelId) {
		if(!automovelRepository.existsById(automovelId)) {
			return ResponseEntity.notFound().build();
		}
		Automovel automovel = automovelRepository.findById(automovelId).get();
		if (automovel.isVendido()) {
			throw new AutomovelVendidoException("Automovel já vendido");
		}
		automovel.setVendido(true);
		automovelRepository.save(automovel);
		return ResponseEntity.ok(automovel);
	}
}
