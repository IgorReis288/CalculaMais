package br.com.calculaMais.service;

import java.util.List;

public interface EquacaoSegundoGrauService {

	public String sinal(int a, int c);
	public List<String> SegundoGrau(int a, int b, int c);
	String filtro(String a, String b, String c);
}
