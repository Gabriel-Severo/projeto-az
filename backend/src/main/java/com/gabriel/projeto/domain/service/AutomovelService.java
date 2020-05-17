package com.gabriel.projeto.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabriel.projeto.domain.exception.AutomovelVendidoException;
import com.gabriel.projeto.domain.model.Automovel;
import com.gabriel.projeto.domain.repository.AutomovelRepository;

@Service
public class AutomovelService {
	@Autowired
	private AutomovelRepository automovelRepository;
	
	public Automovel adicionar(Automovel automovel) {
		//É preciso obter o automovel direto no banco de dados porque pode ser passado
		//pelo body que o veículo não foi vendido
		Automovel automovelDB = automovelRepository.findById(automovel.getId()).get();
		if(automovelDB.isVendido()) {
			throw new AutomovelVendidoException("Automovel já vendido");
		}
		
		return automovelRepository.save(automovel);
	}
	
	public void excluir(Long automovelId) {
		Automovel automovel = automovelRepository.findById(automovelId).get();
		if(automovel.isVendido()) {
			throw new AutomovelVendidoException("Automovel já vendido");
		}
		automovelRepository.deleteById(automovelId);
	}
	
}
