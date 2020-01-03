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

import ar.edu.unlp.bd.biblio.enums.EstadoPrestamo;

@Entity
public class Prestamo {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer prestamoId;
	@NotBlank
	private Date fechaInicio;
	@NotBlank
	private Date fechaFin;
	private EstadoPrestamo estado;
	@ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    @JoinColumn(name="socioId", nullable=false)
	private Socio socio;
	@ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    @JoinColumn(name="libroId", nullable=false)
	private Libro libro;
	
	public Prestamo() {
		
	}

	public Prestamo(Date fechaInicio, Date fechaFin, Socio socio, Libro libro) {
		super();
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.socio = socio;
		this.libro = libro;
		this.estado = EstadoPrestamo.GENERADO;
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
	

}
