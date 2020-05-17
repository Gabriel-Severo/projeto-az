package com.gabriel.projeto.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gabriel.projeto.domain.model.Automovel;

@Repository
public interface AutomovelRepository extends JpaRepository<Automovel, Long>{
	
}
