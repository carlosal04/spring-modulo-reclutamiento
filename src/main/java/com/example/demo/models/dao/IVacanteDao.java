package com.example.demo.models.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.demo.models.entity.Vacante;

public interface IVacanteDao extends PagingAndSortingRepository<Vacante, Long>{

}
