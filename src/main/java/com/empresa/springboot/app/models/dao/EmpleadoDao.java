package com.empresa.springboot.app.models.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.empresa.springboot.app.models.entity.Empleado;

@Repository
public class EmpleadoDao implements IEmpleadoDao {

	@PersistenceContext
	private EntityManager entity;
	

	@Override
	@Transactional
	public void guardar(Empleado empleado) {

		entity.persist(empleado);
	}

	@Override
	@Transactional
	public Empleado findOne(Long id) {
		
		return entity.find(Empleado.class,id); 
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	@Override
	public List<Empleado> findAll() {
		
			return entity.createQuery("from Empleado").getResultList();
		
	}

	@Override
	@Transactional
	public void update(Empleado empleado) {
		
		entity.merge(empleado);
		
	}

	@Override
	@Transactional
	public void delete(Long id) {
		
		Empleado empleado = findOne(id);
		entity.remove(empleado);
		
		 
		
	}

}
