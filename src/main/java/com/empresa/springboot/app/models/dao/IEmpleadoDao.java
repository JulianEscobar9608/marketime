package com.empresa.springboot.app.models.dao;

import java.util.List;

import com.empresa.springboot.app.models.entity.Empleado;

public interface IEmpleadoDao {
	
	public void guardar(Empleado empleado);
	
	public Empleado findOne(Long id);
	
	public List<Empleado> findAll();
	
	public void update(Empleado empleado);
	
	public void delete(Long id);

}
