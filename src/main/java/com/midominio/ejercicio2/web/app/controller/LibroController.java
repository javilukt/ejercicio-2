package com.midominio.ejercicio2.web.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.midominio.ejercicio2.web.app.model.Libro;

@Controller
@RequestMapping("/libros")
public class LibroController {
	
	@GetMapping("/listar")
	public String listaHandler(Model model) {
		
		model.addAttribute("header", "Libros");
		model.addAttribute("titulo", "Listado de libros");
		model.addAttribute("libros", Libro.getListaLibros());
		model.addAttribute("volverAHome", true);

		return "libro/lista";
	}
	
	@GetMapping("/titulo/{titulo}")
	public String listaHandler(@PathVariable String titulo, Model model) {
		Libro elLibro = null;
		if(titulo == null) {
			elLibro = null;
		} else {
			for(Libro libro: Libro.getListaLibros()) {
				if (titulo.equals(libro.getTitulo())) {
					elLibro = libro;
					break;
				}
			}
		}
		
		model.addAttribute("header", "Libros");
		model.addAttribute("titulo", "Datos de un libro");
		model.addAttribute("libro", elLibro);
		return "libro/un-libro";
	}
	
	@GetMapping("/listar/autor/{autor}")
	public String listaFiltradaAutorHandler(
			@PathVariable String autor,
			Model model) {
		
		List<Libro> listaFiltrada = new ArrayList<>();
		
		for(Libro libro: Libro.getListaLibros()) {
			if (libro == null) continue;
			if (autor == null) break;
			if(autor.equals(libro.getAutor())) {
				listaFiltrada.add(libro);
			}
		}
			
		model.addAttribute("header", "Libros");
		model.addAttribute("titulo", "Listado de libros filtrados por autor");
		model.addAttribute("libros", listaFiltrada);
		model.addAttribute("volverAHome", false);

		return "libro/lista";
	}
	
	@GetMapping("/listar/genero/{genero}")
	public String listaFiltradaGeneroHandler(
			@PathVariable String genero,
			Model model) {
		
		List<Libro> listaFiltrada = new ArrayList<>();
		
		for(Libro libro: Libro.getListaLibros()) {
			if (libro == null) continue;
			if (genero == null) break;
			if(genero.equals(libro.getGenero().getDescripcion())) {
				listaFiltrada.add(libro);
			}
		}
			
		model.addAttribute("header", "Libros");
		model.addAttribute("titulo", "Listado de libros filtrados por genero");
		model.addAttribute("libros", listaFiltrada);
		model.addAttribute("volverAHome", false);

		return "libro/lista";
	}
	
}
