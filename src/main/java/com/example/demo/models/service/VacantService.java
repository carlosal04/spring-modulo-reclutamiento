package com.example.demo.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.models.entity.Vacant;

public interface VacantService {
	
	public List<Vacant> findAll();
	
	public void save(Vacant vacant);
	
	public Vacant findOne(Long id);
	
	public void delete(Long id);
	
	public Page<Vacant> findAll(Pageable pageable);

}
