package com.cenfotec.springbootexamen2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cenfotec.springbootexamen2.domain.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
	public List<Producto> findByIdBodega(Long id_bodega);
}
