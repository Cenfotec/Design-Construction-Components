package com.cenfotec.springbootexamen2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import com.cenfotec.springbootexamen2.domain.Bodega;
import com.cenfotec.springbootexamen2.repository.BodegaRepository;

@Service
public class BodegaServiceImpl implements BodegaService {

	@Autowired
	private BodegaRepository bodegaRepo;
	
	@Override
	public List<Bodega> getAllBodegas() {
		return bodegaRepo.findAll();
	}

}
