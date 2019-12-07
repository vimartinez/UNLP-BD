package ar.edu.unlp.bd.biblio.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unlp.bd.biblio.model.Editorial;
import ar.edu.unlp.bd.biblio.service.EditorialService;

@RestController
@RequestMapping("/editorial")
public class EditorialRestController {
	@Autowired
	private EditorialService editorialService;
	
	@PostMapping(path = "/", produces = "application/json")
	public @ResponseBody Editorial addEditorial(@RequestBody Editorial editorial) {
		return editorialService.addEditorial(editorial);
	}
	
	@GetMapping(value = "/{id}")
	public @ResponseBody Editorial getEditorial(@PathVariable("id") Integer id) {
		return editorialService.getEditorial(id);
	}

	@GetMapping(value = "/")
	public @ResponseBody Iterable<Editorial> getAllEditoriales() {
		return editorialService.getAllEditoriales();
	}
	
	@DeleteMapping(path = "/{id}", produces = "application/json")
	public @ResponseBody String delEditorial(@PathVariable("id") Integer id) {
		return editorialService.delEditorial(id);
	}
	
	@PutMapping(path = "/", produces = "application/json")
	public @ResponseBody Editorial setEditorial(@RequestBody Editorial editorial) {
		return editorialService.updEditorial(editorial);
	}

}
