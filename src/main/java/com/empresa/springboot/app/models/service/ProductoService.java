package com.empresa.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.empresa.springboot.app.models.dao.IProdCrud;
import com.empresa.springboot.app.models.dao.IProductoDao;
import com.empresa.springboot.app.models.entity.Producto;

@Service
public class ProductoService implements IProductoService{

	@Autowired
	private IProductoDao productodao;
	
	@Autowired
	private IProdCrud prodcrud;
	
	@Transactional(readOnly=true)
	@Override
	public List<Producto> findAll() {
		// TODO Auto-generated method stub
		return productodao.findAll();
	}
	
	@Transactional(readOnly=true)
	@Override
	public Producto findOne(Long id) {
		// TODO Auto-generated method stub
		return productodao.findOne(id);
	}

	@Transactional
	@Override
	public void guardar(Producto producto) {
		productodao.guardar(producto);
		
	}

	@Transactional
	@Override
	public void delete(Long id) {
		productodao.delete(id);
		
	}

	@Transactional
	@Override
	public void update(Producto producto) {
		productodao.update(producto);
		
	}
	
	@Transactional
	@Override
	public List<Producto> findByNombre(String term) {
		
		return prodcrud.findByNombre(term);
	}
	
	@Transactional
	@Override
	public List<Producto> findByCategoria(Long cate){
		
		return prodcrud.findByCategoria(cate);
	}

}
