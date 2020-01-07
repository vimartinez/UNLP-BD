package ar.edu.unlp.bd.biblio.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/biblioDataLoader")
public class BiblioDataLoader {
	@Autowired
	private BiblioDataLoaderService biblioDataLoaderService;

	@PostMapping(path = "/generarDatos", produces = "application/json")
	public @ResponseBody String cargarDatos() {
		 return biblioDataLoaderService.cargarDatos();
	}
	
	@DeleteMapping(path = "/borrarDatos", produces = "application/json")
	public @ResponseBody String delLibror() {
		return biblioDataLoaderService.eliminarDatos();
	}
}

