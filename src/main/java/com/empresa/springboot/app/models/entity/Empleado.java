package com.empresa.springboot.app.models.entity;

import java.io.Serializable;
import java.util.Date;
//import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name = "tblempleado")
@NamedQuery(name="Empleado.findOne",query="SELECT e.documento FROM Empleado e WHERE e.documento = :id")
public class Empleado implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	@Column(name = "emp_Nombre")
	private String nombre;
	
	@NotEmpty
	@Column(name = "emp_Ape")
	private String apellido;
	
	@NotEmpty
	@Column(name="emp_Docu")
	private String documento;
	
	@NotEmpty
	@Column(name = "emp_Direc")
	private String direccion;
	
	@NotEmpty
	@Column(name = "emp_Tel")
	private String telefono;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "empCargo")
	private Cargo cargo;

	//@ManyToOne(fetch = FetchType.LAZY)
	//@JoinColumn(name = "empCond")
	//private Condicion condicion;
	
	@NotEmpty
	@Column(name = "emp_Contrasena",length=30)
	private String contrasena;
	
	  
	@Column(name = "emp_FechaIngr")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;
	
	@Column(name = "emp_FechaActuali")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaUp;
	
	private Boolean enabled;
	
	/*
	
	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private List<Roles> roles;
	
	*/
	@PrePersist
	public void prePersist(){
		
		this.fecha = new Date();
		
	}
	@PreUpdate
	public void preUpdate(){
		
		this.fechaUp = new Date();
		
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
	
	
	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
/*
	public Condicion getCondicion() {
		return condicion;
	}

	public void setCondicion(Condicion condicion) {
		this.condicion = condicion;
	}
	*/
	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	/*

	public List<Roles> getRoles() {
		return roles;
	}
	public void setRoles(List<Roles> roles) {
		this.roles = roles;
	}
	
	
	*/

	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}




	private static final long serialVersionUID = 1L;

}
