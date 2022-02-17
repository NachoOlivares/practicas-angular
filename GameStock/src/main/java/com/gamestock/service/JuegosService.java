package com.gamestock.service;

import java.util.List;

import com.gamestock.model.Juego;

public interface JuegosService {

	boolean AddGame(Juego juego);
	
	boolean removeGame(String nombre);
	
	Juego searchGame(String nombre);


	List<Juego> ListGames();


	List<Juego> ListGameYear(int year);

	boolean UpdateGame(Juego juego);

}