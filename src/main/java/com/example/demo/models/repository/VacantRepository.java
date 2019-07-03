package com.example.demo.models.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.demo.models.entity.Vacant;

public interface VacantRepository extends PagingAndSortingRepository<Vacant, Long>{

}
