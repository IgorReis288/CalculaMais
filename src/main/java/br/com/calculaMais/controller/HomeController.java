package br.com.calculaMais.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.calculaMais.service.EquacaoSegundoGrauService;
import br.com.calculaMais.service.TabuadaService;

@Controller
public class HomeController {

	@Autowired
	private EquacaoSegundoGrauService equa;
	
	@Autowired
	private TabuadaService tab;

	@RequestMapping("/home")
	public String home() {
		return "/home";
	}
	
	@RequestMapping("/resposta")
	public String resposta() {
		return "/resposta";
	}

	@ResponseBody
	@GetMapping("/resposta/{idA}/{idB}/{idC}")
	public String resposta(@PathVariable("idA") String a, @PathVariable("idB") String b, @PathVariable("idC") String c, Model model) {
		String resultado = equa.filtro(a, b, c);
		return resultado;
		}
	
	//tabuada feita, só organizar a frente e colocar os 4 tipos de operações.
	@ResponseBody
	@GetMapping("/soma/{id}")
	public String resposta(@PathVariable("id") String num, Model model) {
		String resultado = tab.soma(num).toString();
		return resultado;
	}
}
