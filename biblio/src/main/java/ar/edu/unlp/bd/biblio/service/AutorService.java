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

	public Autor addAutor(Autor autor) {
		autorRepository.save(autor);
		return autor;
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
			Autor autor = autorRepository.findById(id).get();
			return autor;
		} catch (Exception e) {
			throw new BiblioNotFoundException("Autor con el id " + id.toString());
		}
	}

	public Autor updEditorial(Autor autor) {
		autorRepository.save(autor);
		return autor;
	}
}
