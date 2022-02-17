package com.whiteam.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.whiteam.modelo.Pais;

@Service
public class PaisesServiceImpl implements PaisesService {

	String urlBase = "https://restcountries.com/v2/all";

	@Autowired
	RestTemplate template;

	@Override
	public List<String> ConsultaPais(String continente) {
		List<Pais> todos = List.of(template.getForObject(urlBase, Pais[].class));
		List<String> ans = todos.stream().filter(t->t.getContinente().equals(continente)).map(Pais::getNombre).distinct().collect(Collectors.toList());
		return ans;
	}

	@Override
	public List<String> ConsultaContinentes() {
		List<Pais> todos = List.of(template.getForObject(urlBase, Pais[].class));
		List<String> ans = todos.stream().map(Pais::getContinente).distinct().collect(Collectors.toList());
		return ans;
	}

	@Override
	public Pais PaisMasPoblado() {
		List<Pais> todos = List.of(template.getForObject(urlBase, Pais[].class));
		Pais ans = todos.stream().max(Comparator.comparing(Pais::getHabitantes)).get();
		return ans;
	}

}
