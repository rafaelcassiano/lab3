package br.gov.sp.fatec.dto;

import java.io.Serializable;

public class EditoraDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7565527455205959587L;

	private long id;
	private String nome;
	
	public EditoraDto() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
