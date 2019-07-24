package br.com.calculaMais.entity;

import org.springframework.stereotype.Component;

@Component
public class EquaSegGrauEntity {

	private String resposta;
	
	public EquaSegGrauEntity(){
	}
	
	public EquaSegGrauEntity(String resposta) {
		this.resposta = resposta;
	}

	
	public String getResposta() {
		return resposta;
	}
	
	
}
