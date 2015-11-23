package br.gov.sp.fatec.dto;

import java.io.Serializable;

public class LivroDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8485733656854015669L;

	private long id;
	private String titulo;
	private String isbn;
	private AutorDto autor;
	private EditoraDto editora;

	public LivroDto() {
		// TODO Auto-generated constructor stub
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public AutorDto getAutor() {
		return autor;
	}

	public void setAutor(AutorDto autor) {
		this.autor = autor;
	}

	public EditoraDto getEditora() {
		return editora;
	}

	public void setEditora(EditoraDto editora) {
		this.editora = editora;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
