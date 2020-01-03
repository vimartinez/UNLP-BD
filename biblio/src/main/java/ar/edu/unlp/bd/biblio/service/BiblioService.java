package ar.edu.unlp.bd.biblio.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import ar.edu.unlp.bd.biblio.model.Libro;
import ar.edu.unlp.bd.biblio.service.LibroService;

@Service
public class BiblioService {
	@Autowired
	private LibroService libroService;

	public ArrayList<Libro> getAllLibros(){
		return (ArrayList<Libro>) libroService.getAllLibros();		
	}
}
