package ar.edu.unlp.bd.biblio.repositories;

import ar.edu.unlp.bd.biblio.model.Libro;

public interface LibroRepositoryCustom {
	
	Iterable<Libro> getLibrosDisponiblesPorTitulo(String titulo);
	
	Iterable<Libro> getLibrosDisponiblesGenero(String genero);

}
