package com.cenfotec.springbootexamen2.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cenfotec.springbootexamen2.domain.Bodega;
import com.cenfotec.springbootexamen2.domain.Producto;
import com.cenfotec.springbootexamen2.service.BodegaService;
import com.cenfotec.springbootexamen2.service.ProductoService;

@Controller
public class ProductoController {
	@Autowired
	private ProductoService productoService;
	
	@Autowired
	private BodegaService bodegaService;
	
	@RequestMapping("/producto")
	public String index(Model model) {
		
		Producto producto = new Producto();
		List<Bodega> listaBodegas = bodegaService.getAllBodegas();
		
		model.addAttribute("producto", producto);
		model.addAttribute("bodegas", listaBodegas);
		
		return "producto";
	}

	@PostMapping("/producto")
	public String addProducto(Producto producto) {
		// ResponseEntity<String>
		productoService.saveProducto(producto);
		//return new ResponseEntity<>(HttpStatus.CREATED);
		return "redirect:/success";
	}
	
	@RequestMapping("/success")
    public String success(Model model) 
    {
         return "addSuccess";
    }
	
	
	
	@RequestMapping("/producto/lista")
	public String productoLista(Model model) {
		
		List<Producto> listaProductos = productoService.getAllProductos();
		List<Bodega> listaBodegas = bodegaService.getAllBodegas();
		
		model.addAttribute("productos", listaProductos);
		model.addAttribute("bodegas", listaBodegas);
		
		return "producto_lista";
	}
	
	/*@RequestMapping("/productos/{id_bodega}")
	public String productoListaDatatables(@PathVariable("id_bodega") Long id_bodega, Model model) {
		List<Producto> listaProductos = productoService.getProductoByIdBodega(id_bodega);
		model.addAttribute("productos", listaProductos);
		return "datatables";
	}*/
	
	@RequestMapping("/productos")
	public String productoListaDatatables(Model model) {
		List<Bodega> listaBodegas = bodegaService.getAllBodegas();
		model.addAttribute("bodegas", listaBodegas);
		return "datatables";
	}	
	
	// API
	
	@RequestMapping(path="/api/producto", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Producto>> producto(Model model) {
		List<Producto> listaProductos = productoService.getAllProductos();
		return new ResponseEntity<List<Producto>>(listaProductos, HttpStatus.CREATED);
	}
	
	@RequestMapping(path="/api/producto/{id_bodega}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Producto>> producto(@PathVariable("id_bodega") Long id_bodega) {
		List<Producto> listaProductos = productoService.getProductoByIdBodega(id_bodega);
		return new ResponseEntity<List<Producto>>(listaProductos, HttpStatus.CREATED);
	}
}