package br.gov.sp.fatec.dto;

import java.io.Serializable;

public class AutorDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1638376941098077376L;
	private long id;
	private String nome;
	private String sobrenome;

	public AutorDto() {
		// TODO Auto-generated constructor stub
	}

	public String getNome() {
		return nome;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String toString() {
		return nome.concat(" ").concat(sobrenome);
	}

}
