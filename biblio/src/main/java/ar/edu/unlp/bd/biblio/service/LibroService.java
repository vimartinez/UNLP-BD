package ar.edu.unlp.bd.biblio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import ar.edu.unlp.bd.biblio.error.BiblioRecordNotFoundException;
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

	public Libro getLibro(Integer id) {
		try {
			Libro libro = libroRepository.findById(id).get();
			return libro;
		} catch (Exception e) {
			throw new BiblioRecordNotFoundException("Libro con el id " + id.toString());
		}
	}

	public String delLibro(Integer id) {
		libroRepository.deleteById(id);
		return "Libro eliminado";
	}

	public Libro updAutor(Libro libro) {
		libroRepository.save(libro);
		return libro;
	}

}
