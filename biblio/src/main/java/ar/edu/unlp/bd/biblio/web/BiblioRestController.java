package ar.edu.unlp.bd.biblio.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unlp.bd.biblio.service.BiblioService;

@RestController
@RequestMapping("/biblio")
public class BiblioRestController {
	@Autowired
	private BiblioService biblioService;

	@PostMapping(path = "/generarDatos", produces = "application/json")
	public @ResponseBody String cargarDatos() {
		 return biblioService.cargarDatos();
	}
	
	@DeleteMapping(path = "/borrarDatos", produces = "application/json")
	public @ResponseBody String delLibror() {
		return biblioService.eliminarDatos();
	}
}
