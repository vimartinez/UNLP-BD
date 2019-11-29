package ar.edu.unlp.bd.biblio.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unlp.bd.biblio.model.Autor;

@RestController
public class BiblioRestController {

	//http://localhost:8080/Autor?nombre=Vic&nacionalidad=Argentino
	@RequestMapping("/Autor")
	public Autor autor(@RequestParam(value = "nombre", defaultValue = "World") String nombre,
			@RequestParam(value = "nacionalidad", defaultValue = "Arg") String nacionalidad) {
		return new Autor(nombre, nacionalidad);
	}
}
