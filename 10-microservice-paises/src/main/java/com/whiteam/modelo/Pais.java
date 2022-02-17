package com.whiteam.modelo;

import java.awt.Image;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Pais {

	@JsonProperty(value="name")
	private String nombre;
	@JsonProperty(value="region")
	private String continente;
	private String capital;
	@JsonProperty(value="flag")
	private String bandera;
	@JsonProperty(value="population")
	private int habitantes;
	public Pais(String nombre, String continente, String capital, String bandera, int habitantes) {
		super();
		this.nombre = nombre;
		this.continente = continente;
		this.capital = capital;
		this.bandera = bandera;
		this.habitantes = habitantes;
	}

	public Pais() {
		super();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContinente() {
		return continente;
	}

	public void setContinente(String continente) {
		this.continente = continente;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public String getBandera() {
		return bandera;
	}

	public void setBandera(String bandera) {
		this.bandera = bandera;
	}

	public int getHabitantes() {
		return habitantes;
	}

	public void setHabitantes(int habitantes) {
		this.habitantes = habitantes;
	}
	
}
