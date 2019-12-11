package ar.edu.unlp.bd.biblio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Editorial {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer editorialId;
	private String nombre;
	private String pais;
	
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
	
	

}
