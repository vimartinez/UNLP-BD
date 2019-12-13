package ar.edu.unlp.bd.biblio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Autor {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer autorId;
	@NotBlank
	private String nombreApe;
	private String paisDeNacimiento;
	private boolean eliminado;
	
	public Autor() {
		
	}
	public Autor(String nombreApe, String paisDeNacimiento) {
		this.nombreApe = nombreApe;
		this.paisDeNacimiento = paisDeNacimiento;
		this.eliminado =false;
	}
	public Integer getId() {
		return autorId;
	}
	public void setId(Integer autorId) {
		this.autorId = autorId;
	}
	public String getNombreApe() {
		return nombreApe;
	}
	public void setNombreApe(String nombreApe) {
		this.nombreApe = nombreApe;
	}
	public String getNacionalidad() {
		return paisDeNacimiento;
	}
	public void setNacionalidad(String paisDeNacimiento) {
		this.paisDeNacimiento = paisDeNacimiento;
	}
	public boolean isEliminado() {
		return eliminado;
	}
	public void setEliminado(boolean eliminado) {
		this.eliminado = eliminado;
	}
}
