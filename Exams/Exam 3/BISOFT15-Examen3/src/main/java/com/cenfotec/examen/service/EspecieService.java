package com.cenfotec.examen.service;

import java.util.List;

import com.cenfotec.examen.domain.Especie;

public interface EspecieService {
	public List<Especie> getAllEspecies();

	public void saveEspecie(Especie especie);

	public Especie getEspecieByGuid(String guid);
	
	public void deleteEspecie(Long id);
	
	public Especie updateEspecie(Especie especie, String guid);
}
