package com.empresa.springboot.app.models.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.empresa.springboot.app.models.entity.Cargo;

@Repository
public class CargoDao implements ICargoDao{
	
	@PersistenceContext
	private EntityManager entitycar;
	
	@Transactional
	@Override
	public Cargo findOne(Long id) {
		return entitycar.find(Cargo.class, id);
	}

}
