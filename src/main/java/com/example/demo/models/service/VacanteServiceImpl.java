package com.example.demo.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.models.dao.IVacanteDao;
import com.example.demo.models.entity.Vacante;

@Service
public class VacanteServiceImpl implements IVacanteService{
	
	@Autowired
	private IVacanteDao vacanteDao;

	@Override
	public List<Vacante> findAll() {
		
		return (List<Vacante>) vacanteDao.findAll();
	}

	@Override
	public void save(Vacante vacante) {
		vacanteDao.save(vacante);
	}

	@Override
	public Vacante findOne(Long id) {

		return vacanteDao.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		
		vacanteDao.deleteById(id);
	}

	@Override
	public Page<Vacante> findAll(Pageable pageable) {
		
		return vacanteDao.findAll(pageable);
	}

}
