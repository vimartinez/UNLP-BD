package ar.edu.unlp.bd.biblio.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import ar.edu.unlp.bd.biblio.enums.EstadoSancion;

@Entity
public class Sancion {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer sancionId;
	@NotBlank
	@ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    @JoinColumn(name="socioId", nullable=false)
	private Socio socio;
	@NotBlank
	@ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    @JoinColumn(name="prestamoId", nullable=false)
	private Prestamo prestamo;
	@NotBlank
	private Date fechaInicio;
	@NotBlank
	private Date fechaFin;
	private EstadoSancion estado;
	
	public Sancion () {
		
	}

	public Sancion(Socio socio, Prestamo prestamo, Date fechaInicio, Date fechaFin) {
		super();
		this.socio = socio;
		this.prestamo = prestamo;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.estado = EstadoSancion.ACTIVA;
	}

	public Integer getSancionId() {
		return sancionId;
	}

	public void setSancionId(Integer sancionId) {
		this.sancionId = sancionId;
	}

	public Socio getSocio() {
		return socio;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}

	public Prestamo getPrestamo() {
		return prestamo;
	}

	public void setPrestamo(Prestamo prestamo) {
		this.prestamo = prestamo;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public EstadoSancion getEstado() {
		return estado;
	}

	public void setEstado(EstadoSancion estado) {
		this.estado = estado;
	}
	
	
	
	

}
