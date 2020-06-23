package com.empresa.springboot.app.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.empresa.springboot.app.models.dao.ICategoriaDao;

import com.empresa.springboot.app.models.entity.Categoria;
import com.empresa.springboot.app.models.entity.Producto;
import com.empresa.springboot.app.models.service.IProductoService;

@Controller
@RequestMapping(value = "/admin")
public class ProductoController {

	@Autowired
	IProductoService productoService;

	@Autowired
	ICategoriaDao categoriadao;

	@RequestMapping(value = "/producto")
	public String agregarPro(Model modelo) {

		Producto producto = new Producto();
		modelo.addAttribute("producto", producto);
		Producto product = null;
		modelo.addAttribute("success",product);
		return "admin/super/agregar_productos";

	}

	@RequestMapping(value = "/producto", method = RequestMethod.POST)
	public String guardarPro(@Valid @ModelAttribute("producto") Producto producto, BindingResult result,
			@RequestParam("cat") Long cat, Model modelo, @RequestParam("phot") MultipartFile pixel, RedirectAttributes flash) {

		if (result.hasErrors()) {
			
			flash.addFlashAttribute("success",result.getFieldError());
			return "redirect:producto";

		} else {

			if (!pixel.isEmpty()) {
				try {
					byte[] img = pixel.getBytes();
					producto.setImagen(img);

				} catch (IOException e) {

					e.printStackTrace();
				}

			}

			Categoria categoria = categoriadao.findOne(cat);
			producto.setCategoria(categoria);

			List<Producto> prod = productoService.findByNombre(producto.getNombre());

			if (prod.size() == 0) {

				productoService.guardar(producto);
				return "redirect:index";

			} else {
				modelo.addAttribute("tit", "Ya existe un producto con el mismo nombre");
				return "admin/super/agregar_productos";
			}

		}

	}

	@RequestMapping("/inventario")
	public String modificarPro(Model modelo) {
		modelo.addAttribute("tit", "");
		return "admin/super/buscar_productos";
	}

	@RequestMapping(value = "/cargar", method = RequestMethod.POST)
	public String cargarProductos(@RequestParam("nom") String nom, Model modelo) {

		List<Producto> productos = productoService.findByNombre(nom);
		if (productos.size() == 1) {
			modelo.addAttribute("titulo", "Lista de productos");
			modelo.addAttribute("productos", productos);
			return "admin/super/modificar_producto";

		} else {
			List<Producto> produ = new ArrayList<Producto>();
			modelo.addAttribute("titulo", "No se encontro el producto en especifico");
			modelo.addAttribute("productos", produ);
			return "admin/super/modificar_producto";
		}

	}

	@RequestMapping(value = "/categoria", method = RequestMethod.POST)
	public String cargarPorCat(@RequestParam("cate") Long cate, Model modelo) {

		List<Producto> produc = productoService.findByCategoria(cate);
		modelo.addAttribute("productos", produc);
		return "admin/super/modificar_producto";

	}

	@GetMapping(value = "/findpro/{id}")
	public String found(@PathVariable(value = "id") Long id, Model modelo) {
		Producto prod = null;

		if (id != 0 || id != null) {

			prod = productoService.findOne(id);
		} else {

			return "redirect:index";
		}
		modelo.addAttribute("prod", prod);
		return "admin/super/modal_producto";
	}

	@RequestMapping(value = "/guardarpro", method = RequestMethod.POST)
	public String editarPro(@Valid @ModelAttribute("prod") Producto producto, BindingResult resul,
			@RequestParam("catego") Long catego) {

		if (resul.hasErrors()) {

			return "admin/super/modal_producto";

		} else {
			Categoria categoria = categoriadao.findOne(catego);
			producto.setCategoria(categoria);
			productoService.update(producto);
			return "redirect:inventario";

		}

	}

	@RequestMapping("/eliminarpro/{id}")
	public String eliminarpro(@PathVariable(value = "id") Long id) {

		productoService.delete(id);
		return "admin/super/buscar_productos";

	}

}
