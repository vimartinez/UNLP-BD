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

import ar.edu.unlp.bd.biblio.enums.EstadoReserva;

@Entity
@SequenceGenerator(name="RESERVA_SEQ", sequenceName="seq_reserva")
public class Reserva {
	public static final int DIAS_DURACION_RESERVA = 7;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="RESERVA_SEQ")
	private Integer reservaId;
	@NotNull
	private Date fechaGeneracion;
	@NotNull
	private Date fechaCaducidad;
	private EstadoReserva estado;
	@NotNull
	@OneToOne(fetch = FetchType.EAGER,cascade=CascadeType.MERGE)
	private Socio socio;
	@NotNull
	@OneToOne(fetch = FetchType.EAGER,cascade=CascadeType.MERGE)
	private Libro libro;
	
	public Reserva() {
		this.estado = EstadoReserva.GENERADA;
	}

	public Reserva(Date fechaGeneracion, Socio socio, Libro libro) {
		super();
		this.fechaGeneracion = fechaGeneracion;
		this.fechaCaducidad = fechaGeneracion;
		this.socio = socio;
		this.libro = libro;
		this.estado = EstadoReserva.GENERADA;
	}

	public Date getFechaGeneracion() {
		return fechaGeneracion;
	}

	public void setFechaGeneracion(Date fechaGeneracion) {
		this.fechaGeneracion = fechaGeneracion;
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

	public EstadoReserva getEstado() {
		return estado;
	}

	public void setEstado(EstadoReserva estado) {
		this.estado = estado;
	}
	
	public boolean isReservaValida() {
		if (this.estado == EstadoReserva.GENERADA)
			return true;
		else 
			return false;
	}

	public Date getFechaCaducidad() {
		return fechaCaducidad;
	}

	public void setFechaCaducidad(Date fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}

	public Integer getReservaId() {
		return reservaId;
	}

	public void setReservaId(Integer reservaId) {
		this.reservaId = reservaId;
	}
	
	
	

}
