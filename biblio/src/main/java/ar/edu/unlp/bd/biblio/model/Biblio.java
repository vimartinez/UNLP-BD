package ar.edu.unlp.bd.biblio.model;

import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.unlp.bd.biblio.service.LibroService;

public class Biblio {
	private String nombreBiblioteca;
	private LibroService libroService;
	
	@Autowired
	public Biblio() {			
		this.nombreBiblioteca = "Biblio UNLP - 2019";
	}
	
	public String getNombreBiblioteca() {
		return nombreBiblioteca;
	}
	
	public Iterable<Libro> getAllLibros() {
		return libroService.getAllLibros();
	}
	
	public Iterable<Libro> getLibrosDisponibles(){
		return libroService.getLibrosDisponibles();
	}
}
