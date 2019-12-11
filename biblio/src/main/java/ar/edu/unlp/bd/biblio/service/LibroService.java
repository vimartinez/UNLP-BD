package ar.edu.unlp.bd.biblio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import ar.edu.unlp.bd.biblio.model.Libro;
import ar.edu.unlp.bd.biblio.repositories.LibroRepository;

@Controller
public class LibroService {
	
	@Autowired
	private LibroRepository libroRepository;
	
	public Libro addLibro(Libro libro) {
		libroRepository.save(libro);
		return libro;
	}
	
	public Iterable<Libro> getAllLibros() {
		return libroRepository.findAll();
	}

}
