package com.empresa.springboot.app.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.empresa.springboot.app.models.dao.IClienteDao;
import com.empresa.springboot.app.models.entity.Cliente;

@Controller 
@RequestMapping(value= {"/",""})
public class ClienteController { 
	
	@Autowired
	private IClienteDao clienteDao;
	
	
	@RequestMapping(value= {"/index","","/"})
	public String inicio() {
		
		return "cliente/principal";
	}
	
	@RequestMapping(value="/carnicos")
	public String carnicos(){
		
		return "cliente/carnicos";
	}
	
	
	
	
	//Handlers para usar clienteDao
	
	@RequestMapping(value="/listar", method=RequestMethod.GET) 
	public String listar(Model modelo) {
		modelo.addAttribute("titulo","Listado de clientes");
		modelo.addAttribute("clientes",clienteDao.findAll());
		return "listar";
		
	}
	
	@RequestMapping(value="/formulario")
	public String crear(Map <String,Object> modelo) {
		Cliente cliente = new Cliente();
		modelo.put("titulo","Formulario clientes");
		modelo.put("cliente",cliente);
		return "form";
	}
	
	
	@RequestMapping(value="/formulario", method=RequestMethod.POST)
	public String guardar(Cliente cliente){
		clienteDao.save(cliente);
		return "redirect:listar";
	}
	

	
	
	
}
