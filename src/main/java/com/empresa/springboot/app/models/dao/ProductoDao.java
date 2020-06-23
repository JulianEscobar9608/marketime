package com.empresa.springboot.app.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;


import com.empresa.springboot.app.models.entity.Producto;


@Repository
public class ProductoDao implements IProductoDao{
	
	@PersistenceContext
	EntityManager entitypro;

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Producto> findAll() {
		
		return entitypro.createQuery("from Producto").getResultList();
	}
	
	
	@Override
	public Producto findOne(Long id) {
		
		return entitypro.find(Producto.class, id);
	}
	
	
	@Override
	public void guardar(Producto producto) {
		
		entitypro.persist(producto);
		
	}

	
	@Override
	public void delete(Long id) {
		Producto producto = findOne(id);
		entitypro.remove(producto);
		
		
	}
	
	
	@Override
	public void update(Producto producto) {
		
		entitypro.merge(producto);
	}



}
