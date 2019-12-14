package ar.edu.unlp.bd.biblio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import ar.edu.unlp.bd.biblio.error.BiblioRecordNotFoundException;
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
		Autor autor = autorRepository.findById(id)
				.orElseThrow(() -> new BiblioRecordNotFoundException(
						"Autor con el id " + id + ", no se eliminó ningún registro."));
		autorRepository.delete(autor);
		return "Autor eliminado";
	}

	public Autor getAutor(Integer id) {
		Autor autor = autorRepository.findById(id)
				.orElseThrow(() -> new BiblioRecordNotFoundException("Autor con el id " + id));
		return autor;
	}

	public Autor updAutor(Autor autorNuevo) {
		Autor autorActual = autorRepository.findById(autorNuevo.getId())
				.orElseThrow(() -> new BiblioRecordNotFoundException(
						"Autor con el id " + autorNuevo.getId() + ", no se realizó la actualización."));
		autorActual.setNombreApe(autorNuevo.getNombreApe());
		autorActual.setNacionalidad(autorNuevo.getNacionalidad());
		autorActual.setEliminado(autorNuevo.isEliminado());
		return autorRepository.save(autorActual);
	}

}
