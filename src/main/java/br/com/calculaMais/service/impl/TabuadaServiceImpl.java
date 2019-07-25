package br.com.calculaMais.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.calculaMais.service.TabuadaService;

@Service
public class TabuadaServiceImpl implements TabuadaService {

	@Override
	public List<String> soma(String num) {
		List<String> resposta = new ArrayList<>();
		int numero = Integer.valueOf(num);
		for (int i=1; i<=10 ; i++ ) {
			int resultado = numero + i;
			resposta.add(num + " + " + i + " = " + resultado);
		}
		resposta.add("<br>");
		return resposta;
	}
	
	
	public List<String> subtracao(String num){
		List<String> resposta = new ArrayList<>();
		int numero = Integer.valueOf(num);
		for (int i=1; i<=10 ; i++ ) {
			int resultado = numero - i;
			resposta.add(num + " - " + i + " = " + resultado);
		}
		resposta.add("<br>");
		return resposta;
	}
	
	public List<String> multiplicacao(String num){
		List<String> resposta = new ArrayList<>();
		int numero = Integer.valueOf(num);
		for (int i=1; i<=10 ; i++ ) {
			int resultado = numero * i;
			resposta.add(num + " * " + i + " = " + resultado);
		}
		resposta.add("<br>");
		return resposta;
	}
	
	public List<String> divisão(String num){
		List<String> resposta = new ArrayList<>();
		int numero = Integer.valueOf(num);
		for (int i=1; i<=10 ; i++ ) {
			int resultado = numero - i;
			resposta.add(num + " - " + i + " = " + resultado);
		}
		resposta.add("<br>");
		return resposta;
	}
	
	
}
