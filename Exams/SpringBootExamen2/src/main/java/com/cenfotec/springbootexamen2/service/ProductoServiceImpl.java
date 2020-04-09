package com.cenfotec.springbootexamen2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cenfotec.springbootexamen2.domain.Producto;
import com.cenfotec.springbootexamen2.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService {
	@Autowired
	ProductoRepository productoRepo;

	@Override
	public List<Producto> getAllProductos() {
		return productoRepo.findAll();
	}

	@Override
	public void saveProducto(Producto newProducto) {
		productoRepo.save(newProducto);
	}

	@Override
	public List<Producto> getProductoByIdBodega(Long id_bodega) {
		return productoRepo.findByIdBodega(id_bodega);
	}
}
