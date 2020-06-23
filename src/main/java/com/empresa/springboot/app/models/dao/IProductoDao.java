package com.empresa.springboot.app.models.dao;

import java.util.List;

import com.empresa.springboot.app.models.entity.Producto;


public interface IProductoDao {
	 
	public List<Producto> findAll();
	
	public Producto findOne(Long id);
	
	public void guardar(Producto producto);
	
	public void delete(Long id);
	
	public void update(Producto producto);
	
	

}
