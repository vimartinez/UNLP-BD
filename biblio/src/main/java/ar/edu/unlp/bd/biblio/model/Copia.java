package ar.edu.unlp.bd.biblio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import ar.edu.unlp.bd.biblio.enums.EstadoLibro;

@Entity
public class Copia {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer copiaId;
	@NotBlank
	private Integer libroId;
	@NotBlank
	private Integer copiaNumero;
	private Integer estadoCopia;
	
	public Copia() {
		
	}
	
	public Copia(Integer libroId, Integer copiaNumero) {
		super();
		this.libroId = libroId;
		this.copiaNumero = copiaNumero;
		this.estadoCopia = EstadoLibro.GENERADO.ordinal();
	}

	public Integer getLibroId() {
		return libroId;
	}

	public void setLibroId(Integer libroId) {
		this.libroId = libroId;
	}

	public Integer getCopiaNumero() {
		return copiaNumero;
	}

	public void setCopiaNumero(Integer copiaNumero) {
		this.copiaNumero = copiaNumero;
	}

	public Integer getEstadoCopia() {
		return estadoCopia;
	}

	public void setEstadoCopia(Integer estadoCopia) {
		this.estadoCopia = estadoCopia;
	}
	
	

}
