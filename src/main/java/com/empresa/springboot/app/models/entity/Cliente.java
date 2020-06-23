package com.empresa.springboot.app.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name="tblcliente")
public class Cliente implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="cliNombre")
	private String nombre;
	
	@Column(name="cliApe")
	private String apellido;
	
	@Column(name="cliTel")
	private String telefono;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cliCiudad")
	private Ciudad ciudad;
	
	@Column(name="cliDir")
	private String direccion;
	
	@Column(name="cliEmail")
	private String email;
	
	@OneToMany(mappedBy="cliente",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<Pedido> pedidos;

	private static final long serialVersionUID = 1L;
	
	 
	 
	public Cliente() {
		
		pedidos = new ArrayList<Pedido>(); 
		
	}

	public void agregarPedido(Pedido pedido){	
		pedidos.add(pedido);
	}
	
	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	 

}
