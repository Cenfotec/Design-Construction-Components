package com.cenfotec.examen.query;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cenfotec.examen.entities.Especie;
import com.cenfotec.examen.services.EspecieService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;

@Component
public class EspecieQuery implements GraphQLQueryResolver {

	@Autowired
	private EspecieService especieService;

	public List<Especie> getEspecies() {
		return this.especieService.getAllEspecies();
	}

	public Especie getEspecie(String guid) {
		return this.especieService.getEspecie(guid);
	}
}
