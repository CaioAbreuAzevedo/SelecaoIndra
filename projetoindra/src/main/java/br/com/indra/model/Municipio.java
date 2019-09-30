package br.com.indra.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Municipio {

	@Id
	private String codigoIbge;
	private String nome;
	
	@ManyToOne
	private Estado estado;
	
	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigo() {
		return codigoIbge;
	}

	public void setCodigo(String codigoIbge) {
		this.codigoIbge = codigoIbge;
	}

}
