package com.example.demo.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.models.entity.Vacante;

public interface IVacanteService {
	
	public List<Vacante> findAll();
	
	public void save(Vacante vacante);
	
	public Vacante findOne(Long id);
	
	public void delete(Long id);
	
	public Page<Vacante> findAll(Pageable pageable);

}
