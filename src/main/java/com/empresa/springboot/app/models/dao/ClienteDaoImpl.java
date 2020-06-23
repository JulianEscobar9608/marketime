package com.empresa.springboot.app.models.dao;

import java.util.List;

import javax.persistence.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.empresa.springboot.app.models.entity.Cliente;


@Repository
public class ClienteDaoImpl implements IClienteDao {
	
	@PersistenceContext
	private EntityManager entitymanager;
	

	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	@Override
	public List<Cliente> findAll() {
		
		return entitymanager.createQuery("from Cliente").getResultList();
	}
	
	
	@Override 
	@Transactional
	public void save(Cliente cliente) {
		entitymanager.persist(cliente);
		
	}

}
