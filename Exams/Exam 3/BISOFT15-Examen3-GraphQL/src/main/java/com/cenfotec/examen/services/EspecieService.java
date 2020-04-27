package com.cenfotec.examen.services;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cenfotec.examen.entities.Especie;
import com.cenfotec.examen.repositories.EspecieRepository;

@Service
public class EspecieService {
	@Autowired
	EspecieRepository especieRepository;

	public List<Especie> getAllEspecies() {
		return this.especieRepository.findAll().stream().collect(Collectors.toList());
	}

	public Especie getEspecie(String guid) {
		return this.especieRepository.getByGuid(guid);
	}

	public Especie createEspecie(String nombre, String nombre_descubierto, String tipo) {
		Especie especie = new Especie();
		especie.setNombre(nombre);
		especie.setNombre_descubierto(nombre_descubierto);
		especie.setTipo(tipo);
		especie.setGuid(generateGUID());
		return this.especieRepository.save(especie);
	}

	public Especie updateEspecie(String nombre, String nombre_descubierto, String fecha, String tipo,
			String guid) {
		Especie existing = especieRepository.getByGuid(guid);
		Especie especie = new Especie(nombre, nombre_descubierto, tipo);
		copyNonNullProperties(especie, existing);
		return this.especieRepository.save(existing);
	}
	
	public boolean deleteEspecie(String guid) {
		Especie especie = especieRepository.getByGuid(guid);
		this.especieRepository.delete(especie);
		return true;
	}

	public String generateGUID() {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject("http://localhost:8083/api/guid", String.class);
	}

	public static void copyNonNullProperties(Object src, Object target) {
		BeanUtils.copyProperties(src, target, getNullPropertyNames(src));
	}

	public static String[] getNullPropertyNames(Object source) {
		final BeanWrapper src = new BeanWrapperImpl(source);
		java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

		Set<String> emptyNames = new HashSet<String>();
		for (java.beans.PropertyDescriptor pd : pds) {
			Object srcValue = src.getPropertyValue(pd.getName());
			if (srcValue == null)
				emptyNames.add(pd.getName());
		}
		String[] result = new String[emptyNames.size()];
		return emptyNames.toArray(result);
	}

}
