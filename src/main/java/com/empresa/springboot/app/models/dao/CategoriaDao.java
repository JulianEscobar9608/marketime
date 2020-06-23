package com.empresa.springboot.app.models.dao;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.empresa.springboot.app.models.entity.Categoria;


@Repository
public class CategoriaDao implements ICategoriaDao {
	
	@PersistenceContext
	EntityManager entitycat;
	
	
	@Transactional
	@Override
	public Categoria findOne(Long id) {
		
		return entitycat.find(Categoria.class, id);
	}

}
