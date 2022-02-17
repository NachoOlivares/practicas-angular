package com.whiteam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.whiteam.modelo.Pais;
import com.whiteam.service.PaisesService;

@CrossOrigin("*")
@RestController
public class PaisController {

	@Autowired
	PaisesService app;

	@GetMapping(value="continentes", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<String> Continentes(){
		return app.ConsultaContinentes();
	}
	
	//consumes solo para peticiones post o put
	@GetMapping(value = "paises/{continente}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<String> Paises(@PathVariable("continente") String continente) {
		return app.ConsultaPais(continente);
	}
	
	@GetMapping(value="masHabitantes", produces = MediaType.APPLICATION_JSON_VALUE)
	public Pais PaisMasHabitantes(){
		return app.PaisMasPoblado();
	}
}
