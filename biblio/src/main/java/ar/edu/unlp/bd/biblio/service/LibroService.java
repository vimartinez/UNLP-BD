package ar.edu.unlp.bd.biblio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlp.bd.biblio.error.BiblioRecordNotFoundException;
import ar.edu.unlp.bd.biblio.model.Libro;
import ar.edu.unlp.bd.biblio.repositories.LibroRepository;

@Service
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
		Libro libro = libroRepository.findById(id)
				.orElseThrow(() -> new BiblioRecordNotFoundException("Libro con el id " + id));
		return libro;
	}

	public String delLibro(Integer id) {
		Libro libro = libroRepository.findById(id)
				.orElseThrow(() -> new BiblioRecordNotFoundException(
						"Libro con el id " + id + ", eliminó ningún registro."));
		libroRepository.delete(libro);
		return "Libro eliminado.";
	}

	public Libro updLibro(Libro libroNuevo) {
		Libro libroActual = libroRepository.findById(libroNuevo.getId())
				.orElseThrow(() -> new BiblioRecordNotFoundException(
						"Libro con el id " + libroNuevo.getId() + ", no se realizó la actualización."));
		libroActual.setCopia(libroNuevo.getCopia());
		libroActual.setEliminado(libroNuevo.isEliminado());
		libroActual.setGenero(libroNuevo.getGenero());
		libroActual.setIsbn(libroNuevo.getIsbn());
		libroActual.setResenia(libroNuevo.getResenia());
		libroActual.setTitulo(libroNuevo.getTitulo());
		libroActual.setAutor(libroNuevo.getAutor());
		libroActual.setEditorial(libroNuevo.getEditorial());
		return libroRepository.save(libroActual);
	}

	public void delAllLibros() {
		libroRepository.deleteAll();
		
	}
}
