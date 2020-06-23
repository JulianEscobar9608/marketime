package com.empresa.springboot.app.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.empresa.springboot.app.models.dao.ICargoDao;
import com.empresa.springboot.app.models.dao.IEmpleadoDao;
import com.empresa.springboot.app.models.entity.Cargo;
import com.empresa.springboot.app.models.entity.Empleado;

@Controller
@RequestMapping(value = "/admin")
public class EmpleadoController {

	@Autowired
	private IEmpleadoDao empleadodao;
	
	@Autowired
	private ICargoDao cargodao;

	@GetMapping(value = { "/index", "/", "" })
	public String principal() {

		return "admin/super/principal";
	}

	@GetMapping(value = "/empleados")
	public String crear(Map<String, Object> modelo) {

		Empleado empleado = new Empleado();
		modelo.put("empleado", empleado);
		return "admin/super/agregar_empleados";
	}

	@RequestMapping(value = "/empleados", method = RequestMethod.POST)
	public String guardar(@Valid @ModelAttribute("empleado") Empleado empleado,BindingResult result,@RequestParam("car") Long car ) {

		if (result.hasErrors()) {

			return "admin/super/agregar_empleados";
			
		} else {
			
			Cargo cargo = cargodao.findOne(car);
			empleado.setCargo(cargo);
			empleadodao.guardar(empleado);
			return "redirect:index";
		}

	}

	@GetMapping(value = "/find/{id}")
	public String found(@PathVariable(value = "id") Long id, Model modelo) {
		Empleado emp = null;

		if (id != 0 || id != null) {

			emp = empleadodao.findOne(id);
		} else {

			return "redirect:index";
		}
		modelo.addAttribute("emple", emp);
		return "admin/super/modal_empleado";
	}

	@RequestMapping(value = "/listar")
	public String listar(Model modelo) {
		Empleado empe = new Empleado();
		modelo.addAttribute("emple", empe);
		modelo.addAttribute("empleados", empleadodao.findAll());
		return "admin/super/modificar_empleados";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String editar(@Valid @ModelAttribute("emple") Empleado empleado, BindingResult resul,@RequestParam("categ")Long catego) {

		if (resul.hasErrors()) {

			return "admin/super/modal_empleado";

		} else {
			Cargo cargo = cargodao.findOne(catego);
			empleado.setCargo(cargo);
			empleadodao.update(empleado);
			return "redirect:listar";

		}

	}
	
	@RequestMapping(value="/eliminar/{id}")
	public String eliminar(@PathVariable(value="id") Long id){
		
		empleadodao.delete(id);
		return "redirect:/admin/listar";
		
	}

	/*
	 * 
	 * @RequestMapping(value = "/editar", ) public String
	 * buscarUno(HttpServletRequest request, Map<String, Object> mapa) { String id =
	 * String.valueOf(request.getParameter("id")); String empleado; empleado =
	 * empleadodao.findOne(id); if (empleado.equals("no")) { return
	 * "redirect:index"; } else { mapa.put("empleadouno", empleado); return
	 * "admin/super/modificar_empleados"; }
	 * 
	 * 
	 * 
	 * 
	 * }
	 */
}
