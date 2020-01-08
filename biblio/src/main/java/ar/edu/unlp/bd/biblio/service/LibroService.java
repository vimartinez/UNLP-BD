package ar.edu.unlp.bd.biblio.service;

import java.util.ArrayList;

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
		ArrayList<Libro> libros = (ArrayList<Libro>) libroRepository.findAll();
		if (libros.size() == 0) throw new BiblioRecordNotFoundException("libros en la biblioteca ");
		return libros;
		
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

	public Iterable<Libro> getLibrosDisponibles() { 
		ArrayList<Libro> libros = (ArrayList<Libro>) libroRepository.getLibrosDisponibles();
		if (libros.size() == 0) throw new BiblioRecordNotFoundException("libros disponibles en la biblioteca ");
		return libros;
	}

	public Iterable<Libro> getLibrosDisponiblesPorTitulo(String titulo) {
		ArrayList<Libro> libros = (ArrayList<Libro>) libroRepository.getLibrosDisponiblesPorTitulo(titulo);
		if (libros.size() == 0) throw new BiblioRecordNotFoundException("Libros con el título: " + titulo);
		return libros;
	}
	
	public Iterable<Libro> getLibrosDisponiblesPorAutor(Integer id) {
		ArrayList<Libro> libros = (ArrayList<Libro>) libroRepository.getLibrosDisponiblesPorAutor(id);
		if (libros.size() == 0) throw new BiblioRecordNotFoundException("Libros con el Autor: " + id);
		return libros;
	}

	public Iterable<Libro> getLibrosDisponiblesPorEditorial(Integer id) {
		ArrayList<Libro> libros = (ArrayList<Libro>) libroRepository.getLibrosDisponiblesPorEditorial(id);
		if (libros.size() == 0) throw new BiblioRecordNotFoundException("Libros de la editorial: " + id);
		return libros;
	}

	public Iterable<Libro> getLibrosDisponiblesPorGenero(String genero) {
		ArrayList<Libro> libros = (ArrayList<Libro>) libroRepository.getLibrosDisponiblesGenero(genero);
		if (libros.size() == 0) throw new BiblioRecordNotFoundException("Libros del género: " + genero);
		return libros;
	}
}
