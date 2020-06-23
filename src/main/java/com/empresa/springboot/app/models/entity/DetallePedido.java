package com.empresa.springboot.app.models.entity;

import java.io.Serializable;

import javax.persistence.*;


@Entity
@Table(name="tbldetallepedido")
public class DetallePedido implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="dp_Id")
	private int id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="dpProdCod")
	private Producto producto;
	
	@Column(name="dpCantidad")
	private Integer cantidad;
	
	@Column(name="dpVlTotal")
	private Double total;
	
	private static final long serialVersionUID = 1L;
	
	
	
	public Double calcularParcial(){
		
		return cantidad.doubleValue()*producto.getValor();
	}
	
	
	public int getId() {
		return id;
	}
 
	public void setId(int id) {
		this.id = id;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	
}
