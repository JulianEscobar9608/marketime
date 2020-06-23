package com.empresa.springboot.app.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*; 

@Entity
@Table(name = "tblpedido")
public class Pedido implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "pedFecha")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha; 
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Cliente cliente;
	
	@Column(name="pedEmpDes")
	private String despachador;
	
	@Column(name="pedEmpCond")
	private String conductor;
	
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="dpPedId")
	private List<DetallePedido> items;
	
	private static final long serialVersionUID = 1L;
	
	
	
	public Pedido() {
		
		this.items = new ArrayList<DetallePedido>();
		
	}

	@PrePersist
	public void prePersist(){
		
	fecha = new Date();
	}
	
	public void agregarItem(DetallePedido item){
		
		this.items.add(item);
	}
	
	public Double calcularTotal(){
		
		Double total = 0.0;
		int cantidad = this.items.size();
		
		for(int i=0;i<cantidad;i++){
			
			total += this.items.get(i).calcularParcial();
		}
		
		return total;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getDespachador() {
		return despachador;
	}

	public void setDespachador(String despachador) {
		this.despachador = despachador;
	}

	public String getConductor() {
		return conductor;
	}

	public void setConductor(String conductor) {
		this.conductor = conductor;
	}

	public List<DetallePedido> getItems() {
		return items;
	}

	public void setItems(List<DetallePedido> items) {
		this.items = items;
	}
	
	

 }
