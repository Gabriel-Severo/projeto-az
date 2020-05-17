package com.gabriel.projeto.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gabriel.projeto.domain.model.Automovel;
import com.gabriel.projeto.domain.repository.AutomovelRepository;

@RestController
@RequestMapping("/automoveis")
public class AutomovelController {
	
	
	@Autowired
	private AutomovelRepository automovelRepository;
	
	@GetMapping
	public List<Automovel> listar(){
		return automovelRepository.findAll();
	}
	
	@GetMapping("/{automovelId}")
	public ResponseEntity<Automovel> buscar(@PathVariable Long automovelId) {
		Optional<Automovel> automovel = automovelRepository.findById(automovelId);
		
		if(automovel.isPresent()){
			return ResponseEntity.ok(automovel.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Automovel adicionar(@RequestBody Automovel automovel) {
		return automovelRepository.save(automovel);
	}
	
	@PutMapping("/{automovelId}")
	public ResponseEntity<Automovel> atualizar(@PathVariable Long automovelId, @RequestBody Automovel automovel){
		if(!automovelRepository.existsById(automovelId)) {
			return ResponseEntity.notFound().build();
		}
		automovel.setId(automovelId);
		automovel = automovelRepository.save(automovel);
		return ResponseEntity.ok(automovel);
	}
	
	@DeleteMapping("/{automovelId}")
	public ResponseEntity<Automovel> deletar(@PathVariable Long automovelId){
		if(!automovelRepository.existsById(automovelId)) {
			return ResponseEntity.notFound().build();
		}
		automovelRepository.deleteById(automovelId);
		return ResponseEntity.noContent().build();
	}
}
