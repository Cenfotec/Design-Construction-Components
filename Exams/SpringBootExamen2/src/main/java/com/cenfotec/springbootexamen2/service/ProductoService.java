package com.cenfotec.springbootexamen2.service;

import java.util.List;

import com.cenfotec.springbootexamen2.domain.Producto;

public interface ProductoService {
	public List<Producto> getAllProductos();

	public void saveProducto(Producto newProducto);
	
	public List<Producto> getProductoByIdBodega(Long idBodega);
}