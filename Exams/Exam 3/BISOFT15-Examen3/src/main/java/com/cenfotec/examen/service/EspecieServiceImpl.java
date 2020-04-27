package com.cenfotec.examen.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cenfotec.examen.domain.Especie;
import com.cenfotec.examen.repository.EspecieRepository;

@Service
public class EspecieServiceImpl implements EspecieService {

	@Autowired
	EspecieRepository especieRepository;

	@Override
	public List<Especie> getAllEspecies() {
		return especieRepository.findAll();
	}

	@Override
	public void saveEspecie(Especie especie) {
		especieRepository.save(especie);

	}

	@Override
	public Especie getEspecieByGuid(String guid) {
		return especieRepository.getByGuid(guid);
	}

	@Override
	public void deleteEspecie(Long id) {
		especieRepository.deleteById(id);
	}

	@Override
	public Especie updateEspecie(Especie especie, String guid) {
		Especie existing = especieRepository.getByGuid(guid);
		Especie especieDataFrom = new Especie(especie.getNombre(), especie.getNombre_descubierto(), especie.getTipo());
		copyNonNullProperties(especieDataFrom, existing);
		return this.especieRepository.save(existing);
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