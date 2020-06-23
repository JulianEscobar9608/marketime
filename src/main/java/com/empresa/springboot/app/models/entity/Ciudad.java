package com.empresa.springboot.app.models.entity;


import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="tblciudad")
public class Ciudad implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ciu_id")
	private int id;
	
	@Column(name="ciu_Nombre")
	private String nombre;
	
	@Column(name="ciu_Cod_Post")
	private String codigo;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	
	

}
