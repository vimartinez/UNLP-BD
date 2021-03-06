package ar.edu.unlp.bd.biblio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

@Entity
@SequenceGenerator(name="EDITORIAL_SEQ", sequenceName="seq_editorial")
public class Editorial {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="EDITORIAL_SEQ")
	private Integer editorialId;
	@NotNull
	private String nombre;
	private String pais;
	private boolean eliminado;
	
	public Editorial() {
		
	}
	public Editorial(String nombre, String pais) {
		super();
		this.nombre = nombre;
		this.pais = pais;
	}
	public Integer getId() {
		return editorialId;
	}
	public void setId(Integer editorialId) {
		this.editorialId = editorialId;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public Integer getEditorialId() {
		return editorialId;
	}
	public void setEditorialId(Integer editorialId) {
		this.editorialId = editorialId;
	}
	public boolean isEliminado() {
		return eliminado;
	}
	public void setEliminado(boolean eliminado) {
		this.eliminado = eliminado;
	}
	
	

}
