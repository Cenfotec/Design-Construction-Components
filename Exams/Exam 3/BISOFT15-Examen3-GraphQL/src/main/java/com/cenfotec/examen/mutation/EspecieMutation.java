package com.cenfotec.examen.mutation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cenfotec.examen.entities.Especie;
import com.cenfotec.examen.services.EspecieService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;

@Component
public class EspecieMutation implements GraphQLMutationResolver {
	@Autowired
	private EspecieService especieService;

	public Especie createEspecie(String nombre, String nombre_descubierto, String tipo) {
		return this.especieService.createEspecie(nombre, nombre_descubierto, tipo);
	}
	
	public Especie updateEspecie(String guid, String nombre, String nombre_descubierto, String fecha, String tipo) {
		return this.especieService.updateEspecie(nombre, nombre_descubierto, fecha, tipo, guid);
	}
	
	public boolean deleteEspecie(String guid) {
		return this.especieService.deleteEspecie(guid);
	}
}
