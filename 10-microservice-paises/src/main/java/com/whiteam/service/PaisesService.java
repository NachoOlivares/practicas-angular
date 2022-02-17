package com.whiteam.service;

import java.util.List;

import com.whiteam.modelo.Pais;

public interface PaisesService {


	List<String> ConsultaContinentes();

	Pais PaisMasPoblado();

	List<String> ConsultaPais(String continente);
}
