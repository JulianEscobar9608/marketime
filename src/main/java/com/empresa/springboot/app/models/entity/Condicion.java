package com.empresa.springboot.app.models.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="tblcondicion")
public class Condicion implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="conId")
	private int id;
	
	@Column(name="conEstado")
	private String estado;
	
	

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getEstado() {
		return estado;
	}



	public void setEstado(String estado) {
		this.estado = estado;
	}



	private static final long serialVersionUID = 1L;

}
