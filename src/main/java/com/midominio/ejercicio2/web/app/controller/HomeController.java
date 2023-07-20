package com.midominio.ejercicio2.web.app.controller;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	private Random random = new Random();
	private String[][] todosLosProverbios = todosLosProverbios();
	

	@GetMapping({"/", "/home", ""})
	public String homeHandler(Model model) {
		
		String[] unProverbio = unProverbio();
		
		model.addAttribute("header", "home");
		model.addAttribute("titulo", "Aplicación de ejemplo variada");
		model.addAttribute("lorem", "<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis tristique facilisis enim in vestibulum.</p><p>Aenean varius lorem id molestie dictum. Vivamus facilisis tellus fermentum ligula sollicitudin, at vulputate lectus tempor.</p>");
		model.addAttribute("proverbioCH", unProverbio[0]);
		model.addAttribute("proverbioSP", unProverbio[1]);
		return "home/home";
	}
	
	private String[][] todosLosProverbios() {
		String[][] todosLosProverbios = new String [10][2];
		
		todosLosProverbios[0][0] = "有志者，事竟成。";
        todosLosProverbios[0][1] = "Quien tiene un objetivo, lo logrará.";

        todosLosProverbios[1][0] = "机不可失，时不再来。";
        todosLosProverbios[1][1] = "La oportunidad no se puede perder, el tiempo no volverá.";

        todosLosProverbios[2][0] = "千里之行，始于足下。";
        todosLosProverbios[2][1] = "Un viaje de mil millas comienza con el primer paso.";

        todosLosProverbios[3][0] = "忍一时，风平浪静。";
        todosLosProverbios[3][1] = "Si tienes paciencia, los vientos y las olas se calmarán.";

        todosLosProverbios[4][0] = "不怕慢，就怕停。";
        todosLosProverbios[4][1] = "No temas ir despacio, solo teme detenerte.";

        todosLosProverbios[5][0] = "读万卷书，行万里路。";
        todosLosProverbios[5][1] = "Lee diez mil libros y camina diez mil millas.";

        todosLosProverbios[6][0] = "话多不如话少。";
        todosLosProverbios[6][1] = "Es mejor hablar menos que hablar mucho.";

        todosLosProverbios[7][0] = "吃一堑，长一智。";
        todosLosProverbios[7][1] = "Comete un error y ganarás sabiduría.";

        todosLosProverbios[8][0] = "己所不欲，勿施于人。";
        todosLosProverbios[8][1] = "No hagas a los demás lo que no quieres que te hagan a ti.";

        todosLosProverbios[9][0] = "知己知彼，百战不殆。";
        todosLosProverbios[9][1] = "Conoce a tu enemigo y conócete a ti mismo, y no serás derrotado en cien batallas.";
		
		return todosLosProverbios;
	}

	private String[] unProverbio() {
        int posicion = random.nextInt(0, todosLosProverbios.length);		
		return new String[] {todosLosProverbios[posicion][0], todosLosProverbios[posicion][1]};
	}

}
