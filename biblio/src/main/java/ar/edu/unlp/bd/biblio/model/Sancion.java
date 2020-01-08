package ar.edu.unlp.bd.biblio.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import ar.edu.unlp.bd.biblio.enums.EstadoSancion;

@Entity
@SequenceGenerator(name="SANCION_SEQ", sequenceName="seq_sancion")
public class Sancion {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SANCION_SEQ")
	private Integer sancionId;
	@NotNull
	@ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.MERGE)
	private Socio socio;
	@NotNull
	@ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.MERGE)
	private Prestamo prestamo;
	@NotNull
	private Date fechaInicio;
	@NotNull
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
