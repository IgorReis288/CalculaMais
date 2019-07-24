package br.com.calculaMais.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.calculaMais.entity.EquaSegGrauEntity;
import br.com.calculaMais.service.EquacaoSegundoGrauService;

@Controller
public class HomeController {

	@Autowired
	private EquacaoSegundoGrauService equa;
	
	@Autowired
	private EquaSegGrauEntity rep;

	@RequestMapping("/home")
	public String home() {
		return "/home";
	}

	@ResponseBody
	@GetMapping("/resposta/{idA}/{idB}/{idC}")
	public String resposta(@PathVariable("idA") String a, @PathVariable("idB") String b, @PathVariable("idC") String c, Model model) {
		String resultado = equa.filtro(a, b, c);
		return resultado;
		}
}
