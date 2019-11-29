package ar.edu.unlp.bd.biblio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Autor {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String nombreApe;
	private String nacionalidad;
	private boolean eliminado;
	
	public Autor() {
		
	}
	public Autor(String nombreApe, String nacionalidad) {
		this.nombreApe = nombreApe;
		this.nacionalidad = nacionalidad;
		this.eliminado =false;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombreApe() {
		return nombreApe;
	}
	public void setNombreApe(String nombreApe) {
		this.nombreApe = nombreApe;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public boolean isEliminado() {
		return eliminado;
	}
	public void setEliminado(boolean eliminado) {
		this.eliminado = eliminado;
	}
}
