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
		try {
			Editorial editorial = editorialRepository.findById(id).get();
			return editorial;
		} catch (Exception e) {
			throw new BiblioRecordNotFoundException("Editorial con el id " + id.toString());
		}
	}
	
	public Iterable<Editorial> getAllEditoriales() {
		return editorialRepository.findAll();
	}

	public String delEditorial(Integer id) {
		editorialRepository.deleteById(id);
		return "Editorial eliminada";
	}

	public Editorial updEditorial(Editorial editorial) {
		editorialRepository.save(editorial);
		return editorial;
	}

}
