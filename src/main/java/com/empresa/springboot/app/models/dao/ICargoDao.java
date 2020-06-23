package com.empresa.springboot.app.models.dao;

import com.empresa.springboot.app.models.entity.Cargo;

public interface ICargoDao {
	
	public Cargo findOne(Long id);

}
