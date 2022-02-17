package com.gamestock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamestock.dao.JuegosDao;
import com.gamestock.model.Juego;

@Service
public class JuegosServiceImpl implements JuegosService {

	JuegosDao daoJuegos;

	public JuegosServiceImpl(@Autowired JuegosDao daoJuegos) {
		this.daoJuegos = daoJuegos;
	}

	@Override
	public boolean AddGame(Juego juego) {
		Juego Juego = daoJuegos.getById(juego.getNombre());
		if (Juego == null) {
			daoJuegos.save(juego);
			return true;
		}
		return false;
	}

	@Override
	public Juego searchGame(String nombre) {
		return daoJuegos.findById(nombre).orElse(null);
	}

	@Override
	public boolean removeGame(String nombre) {
		Juego juego = daoJuegos.getById(nombre);
		if (juego.getNombre() != null) {
			daoJuegos.deleteById(nombre);
			return true;
		}
		return false;
	}

	@Override
	public List<Juego> ListGames() {
		return daoJuegos.findAll();
	}

	@Override
	public boolean UpdateGame(Juego juego) {
		Juego JuegoComp = ListGames().stream().filter(t -> t.getNombre().equals(juego.getNombre())).findFirst()
				.orElse(null);
		if (JuegoComp != null) {
			daoJuegos.getById(juego.getNombre()).setGenero(juego.getGenero());
			daoJuegos.getById(juego.getNombre()).setYear(juego.getYear());
			return true;
		}
		return false;
	}

	@Override
	public List<Juego> ListGameYear(int year) {
		return daoJuegos.ListGameYear(year);
	}
}
