package com.cenfotec.examen.web;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GUIDController {
	@RequestMapping("/api/guid")
	public ResponseEntity<String> index(Model model) {
		UUID uuid = UUID.randomUUID();
        String uuidString = uuid.toString();
		return new ResponseEntity<String>(uuidString, HttpStatus.CREATED);
	}
}
