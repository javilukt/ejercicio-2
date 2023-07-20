package com.midominio.ejercicio2.web.app.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ciudades")
public class TestCiudadesController {
	
	
	Random random = new Random();
	
	@GetMapping("/un-test")
	public String m(Model model) {
		
		// Listados de fotos y su correspondencia con ciudad
		
		List<String> listaCiudadesNombres = new ArrayList<>(List.of("Atenas", "Barcelona", "Berlín",
				"Londres", "Moscú", "Nueva York", "París", "Roma", "Sidney"));
		
		List<String> listaCiudadesImages = new ArrayList<>(List.of("atenas", "barcelona", "berlin",
				"londres", "moscu", "nueva-york", "paris", "roma", "sidney"));	
		List<String[]> miTest = new ArrayList<>();
		
		// Elegir 4 posiciones aleatorias
		for(int i=0; i < 4; i++) {
			int posicion = random.nextInt(0, listaCiudadesNombres.size());
			String[] ciudad = {listaCiudadesNombres.get(posicion), listaCiudadesImages.get(posicion)};  
			miTest.add(ciudad);
			listaCiudadesNombres.remove(posicion);
			listaCiudadesImages.remove(posicion);
		}
		
		// Nos quedamos solo con una que tenga solución, el resto null
		
		
		int posicion = random.nextInt(0, miTest.size());
		String imagen = miTest.get(posicion)[1];
		for(int i= 0; i < miTest.size(); i++) {
			if(i != posicion) {
				miTest.get(i)[1] = null;
			}
		}
		
		// Lo mezclamos
		
		Collections.shuffle(miTest);
		
		// Pasamos los datos a la vista
		
		model.addAttribute("header", "Adivina la ciudad");
		model.addAttribute("titulo", "¿Cuál es la ciudad de la imagen?");
		model.addAttribute("test", miTest);
		model.addAttribute("imagen", imagen);
		
		return "test-ciudad/un-test";
	}
	
	@GetMapping("/ok")
	public String okHandler(Model model) {
		
		model.addAttribute("header", "Adivina la ciudad");
		model.addAttribute("titulo", "Resultado");
		model.addAttribute("acierto", "Acertaste");
		
		return "test-ciudad/resultado-test";
	}
	
	@GetMapping("/nok")
	public String nokHandler(Model model) {
		
		model.addAttribute("header", "Adivina la ciudad");
		model.addAttribute("titulo", "Resultado");
		model.addAttribute("acierto", "No acertaste");
		
		return "test-ciudad/resultado-test";
	}
	
}
