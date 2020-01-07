package ar.edu.unlp.bd.biblio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import ar.edu.unlp.bd.biblio.enums.EstadoSocio;

@Entity
public class Socio {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer socioId;
	@NotNull
	private String nombreApe;
	private EstadoSocio estado;
	
	public Socio() {
		
		estado = EstadoSocio.GENERADO;
	}

	public Socio(String nombreApe) {
		super();
		this.nombreApe = nombreApe;
		estado = EstadoSocio.GENERADO;
	}

	public Integer getSocioId() {
		return socioId;
	}

	public void setSocioId(Integer socioId) {
		this.socioId = socioId;
	}

	public String getNombreApe() {
		return nombreApe;
	}

	public void setNombreApe(String nombreApe) {
		this.nombreApe = nombreApe;
	}

	public EstadoSocio getEstado() {
		return estado;
	}

	public void setEstado(EstadoSocio estado) {
		this.estado = estado;
	}
	
	

}
