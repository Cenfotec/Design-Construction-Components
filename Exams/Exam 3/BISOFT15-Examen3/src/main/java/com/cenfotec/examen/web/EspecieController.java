package com.cenfotec.examen.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.cenfotec.examen.domain.Especie;
import com.cenfotec.examen.service.EspecieService;

@Controller
public class EspecieController {

	@Autowired
	private EspecieService especieService;

	@PostMapping("/api/especie")
	public ResponseEntity<Especie> createEspecie(@RequestBody Especie especie) {
		RestTemplate restTemplate = new RestTemplate();
		String guid = "";
		try {
			guid = restTemplate.getForObject("http://localhost:8083/api/guid", String.class);
			especie.setGuid(guid);
		} catch (Exception exception) {
			return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
		}
		especieService.saveEspecie(especie);
		return new ResponseEntity<Especie>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path="/api/especie", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Especie>> getAllEspecies(Model model) {
		List<Especie> listaEspecies = especieService.getAllEspecies();
		return new ResponseEntity<List<Especie>>(listaEspecies, HttpStatus.OK);
	}
	
	@RequestMapping(path="/api/especie/{guid}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Especie> getEspecie(@PathVariable("guid") String guid) {
		Especie especie = especieService.getEspecieByGuid(guid);
		return new ResponseEntity<Especie>(especie, HttpStatus.OK);
	}
	
	@DeleteMapping(path="/api/especie/{guid}")
	public ResponseEntity<Long> deleteEspecie(@PathVariable("guid") Long id) {
		especieService.deleteEspecie(id);
		return new ResponseEntity<Long>(id, HttpStatus.OK);
	}
	
	@PutMapping(path="/api/especie/{guid}")
	public ResponseEntity<Especie> deleteEspecie(@RequestBody Especie especie, @PathVariable("guid") String guid) {
		Especie updatedEspecie = especieService.updateEspecie(especie, guid);
		return new ResponseEntity<Especie>(updatedEspecie, HttpStatus.OK);
	}

}
