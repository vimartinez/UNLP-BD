package ar.edu.unlp.bd.biblio.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unlp.bd.biblio.model.Libro;
import ar.edu.unlp.bd.biblio.service.LibroService;

@RestController
@RequestMapping("/libro")
public class LibroRestController {
	@Autowired
	private LibroService libroService;
	
	//@GetMapping(value = "/{id}")
	//public @ResponseBody Libro getLibro(@PathVariable("id") Integer id) {
	//	return libroService.getLibro(id);
	//}

	@GetMapping(value = "/")
	public @ResponseBody Iterable<Libro> getAllLibros() {
		return libroService.getAllLibros();
	}

	@PostMapping(path = "/", produces = "application/json")
	public @ResponseBody Libro addLibro(@RequestBody Libro libro) {
		return libroService.addLibro(libro);
	}

}
