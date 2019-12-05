package ar.edu.unlp.bd.biblio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import ar.edu.unlp.bd.biblio.error.BiblioNotFoundException;
import ar.edu.unlp.bd.biblio.model.Autor;
import ar.edu.unlp.bd.biblio.repositories.AutorRepository;

@Controller
public class AutorService {
	@Autowired
	private AutorRepository autorRepository;

	public Autor addAutor(Autor a) {
		autorRepository.save(a);
		return a;
	}

	public Iterable<Autor> getAllAutores() {
		return autorRepository.findAll();
	}

	public String delAutor(Integer id) {
		autorRepository.deleteById(id);
		return "Autor eliminado";
	}

	public Autor getAutor(Integer id) {
		try {
			Autor a = autorRepository.findById(id).get();
			return a;
		} catch (Exception e) {
			throw new BiblioNotFoundException("Autor con el id " + id.toString());
		}
	}
}
