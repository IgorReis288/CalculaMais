package br.com.calculaMais.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.calculaMais.entity.EquaSegGrauEntity;
import br.com.calculaMais.service.EquacaoSegundoGrauService;

@Service
public class EquacaoSegundoGrauServiceImpl implements EquacaoSegundoGrauService {

	@Override
	public String sinal(int a, int c) {
		if ((a * c * -1) > 0)
			return " + ";
		return " - ";
	}
	
	@Override
	public List<String> SegundoGrau(int a, int b, int c) {
		List<String> resposta = new ArrayList<String>();

		int quatroAC = 4*(a * c);
		int pot = (int) Math.pow(b, 2);
		int delta = pot - quatroAC;

		
		resposta.add("delta= B²-4AC \r\n");
		resposta.add("delta= " + b + "² - 4*(" + a + "*" + c + ")\r\n");
		resposta.add("delta= " + pot + "" + sinal(a, c) + "" + quatroAC + "\r\n");
		resposta.add("delta= " + delta + "\r\n");
		
		int negB = -1*b;
		int dobA = 2*a;
			
		
		if (delta < 0) {
			resposta.add("Não existe no conjunto dos números reais a raiz quadrada de um número negativo.");
			return resposta;
		}
		if (delta == 0) {
			int res = negB / dobA; 
			resposta.add("x: -B/2A \r\n");
			resposta.add("x: " + negB + "/2*" + a + "\r\n");
			resposta.add("x: " + negB + "/" + dobA + "\r\n");
			resposta.add("x: " + res + "\r\n");
			return resposta;
		}
		if (delta > 0) {
			int raiz = (int) Math.sqrt(delta);
			int subtrai = negB - raiz;
			int soma = negB + raiz;
			int divisao = soma/dobA;
			int divisao2 = subtrai/dobA;
			resposta.add("x': -B + √delta/2A \r\n");
			resposta.add("x': " + negB + "√" + delta + "/2*" + a + "\r\n");
			resposta.add("x': " + negB + " + " + raiz + "/" + dobA + "\r\n");
			resposta.add("x': " + soma + "/" + dobA + "\r\n");
			resposta.add("x': " + divisao + "\r\n");
			resposta.add("x\": -B - √delta/2A \r\n");
			resposta.add("x\": " + negB + "√" + delta + "/2*" + a + "\r\n");
			resposta.add("x\": " + negB + " - " + raiz + "/" + dobA + "\r\n");
			resposta.add("x\": " + subtrai + "/" + dobA + "\r\n");
			resposta.add("x\": " + divisao2 + "\r\n");
					
			return resposta;
		}
		
		return resposta;
	}
	
	@Override
	public String filtro(String a, String b, String c) {
		if (a.contains(",") ||
				b.contains(",") ||
				c.contains(","))  {
			return "Por favor, coloque apenas números inteiros.";
		}
		
		if(a.isEmpty()) 
			return "Por não conter o parâmentro 'ax²' esta equação não é de Segundo Grau.";
		
		//Filtro alterado até aqui. 23/07/2019. por igor oliveira.
		
		
		int A = Integer.valueOf(a);
		Integer B = Integer.valueOf(b);
		Integer C = Integer.valueOf(c);
		String filtrada = SegundoGrau(A, B, C)
				.toString()
				.replace("\r\n", "<br/>")
				.replace(",", "")
				.replace("[", "")
				.replace("]", "");
		return filtrada;
	}
	

}
