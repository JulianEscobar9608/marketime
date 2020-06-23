package com.empresa.springboot.app.models.dao;

import com.empresa.springboot.app.models.entity.Categoria;

public interface ICategoriaDao {
	
	public Categoria findOne(Long id);

}
