package ar.edu.unlp.bd.biblio.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unlp.bd.biblio.model.Autor;
import ar.edu.unlp.bd.biblio.service.AutorService;

@RestController
public class AutorRestController {
	@Autowired
	private AutorService autorService;

	@GetMapping(value = "/autor/{id}")
	public @ResponseBody Autor getAutor(@PathVariable("id") Integer id) {
		return autorService.getAutor(id);
	}

	@GetMapping(value = "/autor")
	public @ResponseBody Iterable<Autor> getAllAutores() {
		return autorService.getAllAutores();
	}

	@PostMapping(path = "/autor", produces = "application/json")
	public @ResponseBody Autor addAutor(@RequestBody Autor autor) {
		return autorService.addAutor(autor);
	}

	@DeleteMapping(path = "/autor/{id}", produces = "application/json")
	public @ResponseBody String delAutor(@PathVariable("id") Integer id) {
		return autorService.delAutor(id);
	}
}
