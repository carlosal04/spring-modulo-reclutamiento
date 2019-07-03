package com.example.demo.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.models.entity.Vacant;
import com.example.demo.models.repository.VacantRepository;

@Service
public class VacantServiceImp implements VacantService{
	
	@Autowired
	private VacantRepository vacantRepository;

	@Override
	public List<Vacant> findAll() {
		
		return (List<Vacant>) vacantRepository.findAll();
	}

	@Override
	public void save(Vacant vacant) {
		vacantRepository.save(vacant);
	}

	@Override
	public Vacant findOne(Long id) {

		return vacantRepository.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		
		vacantRepository.deleteById(id);
	}

	@Override
	public Page<Vacant> findAll(Pageable pageable) {
		
		return vacantRepository.findAll(pageable);
	}

}
