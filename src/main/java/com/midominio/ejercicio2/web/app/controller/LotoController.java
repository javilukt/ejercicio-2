package com.midominio.ejercicio2.web.app.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/loto")
public class LotoController {
	
	private Random random = new Random();
	
	@GetMapping("/menu")
	public String menuHandler(Model model) {

		model.addAttribute("header", "Loto");
		model.addAttribute("titulo", "Generación de combinaciones de loto internacional");

		return "loto/home";
	}
	
	@GetMapping("/genera/{totalBolas}/{numBolas}/{pais}")
	public String menuHandler(
			@PathVariable int totalBolas, 
			@PathVariable int numBolas,
			@PathVariable String pais,
			Model model) {		
		
		// Lista de premiados, de momento en blanco		
		List<Integer> premiados = new ArrayList<>();
		
		// Llenamos el bombo
		List<Integer> bombo = new ArrayList<>();
		for(int i = 1; i <= totalBolas; i++) {
			bombo.add(i);
		}
		
		// Extraemos las bolas premiadas
		for(int i = 1; i <= numBolas; i++) {
			 int posicion = random.nextInt(0, bombo.size());
			 premiados.add(bombo.get(posicion));
			 bombo.remove(posicion);
		}
		
		model.addAttribute("header", "Loto");
		model.addAttribute("titulo", "Generación de combinaciones de loto internacional");
		model.addAttribute("pais", pais);
		model.addAttribute("totalBolas", totalBolas);
		model.addAttribute("numBolas", numBolas);
		model.addAttribute("premiados", premiados);
		
		return "loto/una-loto";
	}
	
}
