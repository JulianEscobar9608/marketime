package com.empresa.springboot.app.models.dao;

import java.util.List;

import com.empresa.springboot.app.models.entity.Cliente;

public interface IClienteDao {
	
	public List<Cliente> findAll();
	public void save(Cliente cliente);
	//public void update(Cliente cliente);
		
		
	

}
