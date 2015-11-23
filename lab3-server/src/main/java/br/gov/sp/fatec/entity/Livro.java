package br.gov.sp.fatec.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "livro")
public class Livro implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3161927352361755490L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "livro_id")
	private long id;
	@Column(name = "titulo")
	private String titulo;
	@Column(name = "isbn")
	private String isbn;
	@ManyToOne
	@JoinColumn(name = "autor_id")
	private Autor autor;
	@ManyToOne
	@JoinColumn(name = "editora_id")
	private Editora editora;

	public Livro() {
	}

	public long getId() {
		return id;
	}

	public Autor getAutor() {
		return autor;
	}

	public Editora getEditora() {
		return editora;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
}
