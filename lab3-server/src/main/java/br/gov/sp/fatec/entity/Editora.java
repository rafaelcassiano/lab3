package br.gov.sp.fatec.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "editora")
public class Editora implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7578934771690059338L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "editora_id")
	private long id;
	@Column(name = "nome")
	private String nome;

	public Editora() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
