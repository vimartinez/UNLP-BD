package ar.edu.unlp.bd.biblio.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import ar.edu.unlp.bd.biblio.enums.EstadoLibro;

@Entity
@SequenceGenerator(name="LIBRO_SEQ", sequenceName="seq_libro")
public class Libro {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="LIBRO_SEQ")
	private Integer libroId;
	@NotNull
	private String titulo;
	@NotNull
	private String isbn;
	private String genero;
	private String resenia;
	private Integer copia;
	@ManyToOne(fetch = FetchType.EAGER,cascade={CascadeType.ALL})
	private Autor autor;
	@ManyToOne(fetch = FetchType.EAGER,cascade={CascadeType.ALL})
	private Editorial editorial;
	private EstadoLibro estado;
	private boolean eliminado;
	
	public Libro() {
		
	}
	public Libro(String titulo, String isbn, String genero, String resenia, Integer copia, Autor autor, Editorial editorial) {
		super();
		this.titulo = titulo;
		this.isbn = isbn;
		this.genero = genero;
		this.resenia = resenia;
		this.autor = autor;
		this.editorial = editorial;
		this.copia = copia;
		this.estado = EstadoLibro.DISPONIBLE;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public Integer getId() {
		return libroId;
	}
	public void setId(Integer libroId) {
		this.libroId = libroId;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getResenia() {
		return resenia;
	}
	public void setResenia(String resenia) {
		this.resenia = resenia;
	}
	public Integer getCopia() {
		return copia;
	}
	public void setCopia(Integer copia) {
		this.copia = copia;
	}
	public Autor getAutor() {
		return autor;
	}
	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	public Editorial getEditorial() {
		return editorial;
	}
	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}
	public boolean isEliminado() {
		return eliminado;
	}
	public void setEliminado(boolean eliminado) {
		this.eliminado = eliminado;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Integer getLibroId() {
		return libroId;
	}
	public void setLibroId(Integer libroId) {
		this.libroId = libroId;
	}
	public EstadoLibro getEstado() {
		return estado;
	}
	public void setEstado(EstadoLibro estado) {
		this.estado = estado;
	}
	
}
