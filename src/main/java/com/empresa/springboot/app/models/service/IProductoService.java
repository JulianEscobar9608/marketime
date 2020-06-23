package com.empresa.springboot.app.models.service;

import java.util.List;


import com.empresa.springboot.app.models.entity.Producto;

public interface IProductoService {
	
	public List<Producto> findAll();
	
	public Producto findOne(Long id);
	
	public void guardar(Producto producto);
	
	public void delete(Long id);
	
	public void update(Producto producto);
	
	public List<Producto> findByNombre(String term);
	
	public List<Producto> findByCategoria(Long cate);

}
