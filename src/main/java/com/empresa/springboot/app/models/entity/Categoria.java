package com.empresa.springboot.app.models.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="tblcategoria")
public class Categoria implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cat_id")
	private Long id;
	
	@Column(name="cat_sup_cat")
	private String supercat;
	
	
	private static final long serialVersionUID = 1L;
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSupercat() {
		return supercat;
	}

	public void setSupercat(String supercat) {
		this.supercat = supercat;
	}

	
	

}
