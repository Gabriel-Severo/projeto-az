package com.gabriel.projeto.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
