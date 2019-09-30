package br.com.indra.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Estado {

	@Id
	private int codigoIbge;
	private String nome;

	public int getCodigoIbge() {
		return codigoIbge;
	}

	public void setCodigoIbge(int codigoIbge) {
		this.codigoIbge = codigoIbge;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
