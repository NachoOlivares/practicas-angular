package com.gamestock.controller;

import java.util.List;

import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gamestock.model.Juego;
import com.gamestock.service.JuegosService;

@CrossOrigin("*")
@RestController
public class GameController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	JuegosService service;

	// Peticion get, tambien podria ser post para postear datos
	// Le indicamos tambien la direccion asociada a este metodo
	@PostMapping(value = "AddGame", consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean AddGame(@RequestBody Juego juego) {
		if (service.searchGame(juego.getNombre())==null) {
			service.AddGame(juego);
			return true;
		}
		return false;
	}
	
	@PutMapping(value = "UpdateGame", consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean UpdateGame(@RequestBody Juego juego) {
		if (service.searchGame(juego.getNombre())==null) {
			service.UpdateGame(juego);
			return true;
		}
		return false;
	}

	@GetMapping(value = "SearchGames/{nombre}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Juego JuegoBuscado(@PathVariable("nombre") String key) {
		//Juego error = new Juego("Error", "El juego que busca no existe", 404);
		//if (service.searchGame(key) != null) {
			return service.searchGame(key);
		//} else {
		//	return error;
		//}

	}
	
	@GetMapping(value="ListGames", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Juego> Games() {
		return service.ListGames();

	}

	@DeleteMapping(value="DeleteGame/{nombre}")
	public boolean Delete(@PathVariable("nombre") String nombre) {
		if(service.searchGame(nombre)!=null) {
			service.removeGame(nombre);
			return true;
		}
		return false;
	}

	@GetMapping(value="ListGameYear/{year}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Juego> GamesYear(@PathVariable("year") int year) {
		List<Juego> juegosNull = null;
		if(service.ListGameYear(year)!=null) {
			return service.ListGameYear(year);
		}
		return juegosNull;
	}
}
