package ar.edu.unlp.bd.biblio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import ar.edu.unlp.bd.biblio.error.BiblioRecordNotFoundException;
import ar.edu.unlp.bd.biblio.model.Editorial;
import ar.edu.unlp.bd.biblio.repositories.EditorialRepository;

@Controller
public class EditorialService {
	@Autowired
	private EditorialRepository editorialRepository;

	public Editorial addEditorial(Editorial editorial) {
		editorialRepository.save(editorial);
		return editorial;
	}

	public Editorial getEditorial(Integer id) {
		Editorial editorial = editorialRepository.findById(id)
				.orElseThrow(() -> new BiblioRecordNotFoundException("Editorial con el id " + id));
		return editorial;
	}

	public Iterable<Editorial> getAllEditoriales() {
		return editorialRepository.findAll();
	}

	public String delEditorial(Integer id) {
		editorialRepository.deleteById(id);
		return "Editorial eliminada";
	}

	public Editorial updEditorial(Editorial editorialNueva) {
		Editorial editorialActual = editorialRepository.findById(editorialNueva.getId())
				.orElseThrow(() -> new BiblioRecordNotFoundException(
						"Editorial con el id " + editorialNueva.getId() + ", no se realizó la actualización."));
		editorialActual.setNombre(editorialNueva.getNombre());
		editorialActual.setPais(editorialNueva.getPais());
		editorialActual.setEliminado(editorialNueva.isEliminado());
		return editorialRepository.save(editorialActual);
	}

}
