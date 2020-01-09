package ar.edu.unlp.bd.biblio.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import ar.edu.unlp.bd.biblio.enums.EstadoPrestamo;

@Entity
@SequenceGenerator(name="PRESTAMO_SEQ", sequenceName="seq_prestamo")
public class Prestamo {
	public static final int DIAS_DURACION_PRESTAMO = 14;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="PRESTAMO_SEQ")
	private Integer prestamoId;
	@NotNull
	private Date fechaInicio;
	@NotNull
	private Date fechaFin;
	private EstadoPrestamo estado;
	@OneToOne(fetch = FetchType.EAGER,cascade={CascadeType.MERGE,CascadeType.PERSIST})
	private Reserva reserva;
	@NotNull
	@OneToOne(fetch = FetchType.EAGER,cascade= {CascadeType.MERGE,CascadeType.PERSIST})
	private Socio socio;
	@NotNull
	@OneToOne(fetch = FetchType.EAGER,cascade={CascadeType.MERGE,CascadeType.PERSIST})
	private Libro libro;
	
	public Prestamo() {
		this.estado = EstadoPrestamo.GENERADO;
	}

	public Prestamo(Date fechaInicio, Date fechaFin, Socio socio, Libro libro) {
		super();
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.socio = socio;
		this.libro = libro;
		this.estado = EstadoPrestamo.GENERADO;
	}
	
	public Prestamo(Date fechaInicio, Date fechaFin, Reserva reserva) {
		this (fechaInicio, fechaFin, reserva.getSocio(), reserva.getLibro());
		this.reserva = reserva;
	}

	public Integer getPrestamoId() {
		return prestamoId;
	}

	public void setPrestamoId(Integer prestamoId) {
		this.prestamoId = prestamoId;
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

	public EstadoPrestamo getEstado() {
		return estado;
	}

	public void setEstado(EstadoPrestamo estado) {
		this.estado = estado;
	}

	public Socio getSocio() {
		return socio;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}
	
	
	

}
