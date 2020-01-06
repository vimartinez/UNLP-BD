package ar.edu.unlp.bd.biblio.model;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import ar.edu.unlp.bd.biblio.repositories.AutorRepository;

public class Biblio {
	private String nombreBiblioteca;
	private ArrayList<Autor> autores;
	private ArrayList<Libro> libros;
	private ArrayList<Socio> socios;
	private ArrayList<Reserva> reservas;
	private ArrayList<Prestamo> prestamos;
	private ArrayList<Sancion> sanciones;
	
	@Autowired
	private AutorRepository autorRepository;
	
	@Autowired
	public Biblio() {
		
				
		this.nombreBiblioteca = "Biblio UNLP - 2019";
		this.autores = (ArrayList<Autor>) autorRepository.findAll();
	}
	
	public String getNombreBiblioteca() {
		return nombreBiblioteca;
	}

	public ArrayList<Libro> getLibros() {
		return libros;
	}

	public void setLibros(ArrayList<Libro> libros) {
		this.libros = libros;
	}

	public ArrayList<Socio> getSocios() {
		return socios;
	}

	public void setSocios(ArrayList<Socio> socios) {
		this.socios = socios;
	}

	public ArrayList<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(ArrayList<Reserva> reservas) {
		this.reservas = reservas;
	}

	public ArrayList<Prestamo> getPrestamos() {
		return prestamos;
	}

	public void setPrestamos(ArrayList<Prestamo> prestamos) {
		this.prestamos = prestamos;
	}

	public ArrayList<Sancion> getSanciones() {
		return sanciones;
	}

	public void setSanciones(ArrayList<Sancion> sanciones) {
		this.sanciones = sanciones;
	}

	public ArrayList<Autor> getAutores() {
		return autores;
	}

	public void setAutores(ArrayList<Autor> autores) {
		this.autores = autores;
	}
	
	

}
