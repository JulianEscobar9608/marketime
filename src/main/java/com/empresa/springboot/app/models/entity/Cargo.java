package com.empresa.springboot.app.models.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="tblcargo")
public class Cargo implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="car_Id")
	private Long Cargo;
	
	@Column(name="car_Nombre")
	private String nombre;
	
	
	public Long getCargo() {
		return Cargo;
	}


	public void setCargo(Long cargo) {
		Cargo = cargo;
	}


	public String getNombre() {
		return nombre;
	}




	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




	private static final long serialVersionUID = 1L;

}
