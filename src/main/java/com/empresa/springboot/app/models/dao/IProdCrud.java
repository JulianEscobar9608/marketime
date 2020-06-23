package com.empresa.springboot.app.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.empresa.springboot.app.models.entity.Producto;

public interface IProdCrud extends CrudRepository<Producto,Long>{
	
	@Query("select p from Producto p where p.nombre like %?1%")
	public List<Producto> findByNombre(String term);
	
	
	@Query(value="select * from tblproducto  where prod_Categ = :cate",nativeQuery=true)
	public List<Producto> findByCategoria(Long cate);

	
	

}
