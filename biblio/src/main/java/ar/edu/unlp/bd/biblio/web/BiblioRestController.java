package ar.edu.unlp.bd.biblio.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unlp.bd.biblio.model.Libro;
import ar.edu.unlp.bd.biblio.model.Prestamo;
import ar.edu.unlp.bd.biblio.model.Reserva;
import ar.edu.unlp.bd.biblio.model.Sancion;
import ar.edu.unlp.bd.biblio.service.BiblioService;

@RestController
@RequestMapping("/biblio")
public class BiblioRestController {
	@Autowired
	private BiblioService biblioService;

	@GetMapping(value = "/getAllLibros")
	public @ResponseBody Iterable<Libro> getAllLibros() {
		return biblioService.getAllLibros();
	}
	
	@GetMapping(value = "/getLibrosDisponibles")
	public @ResponseBody Iterable<Libro> getLibrosDisponibles() {
		return biblioService.getLibrosDisponibles();
	}
	
	@GetMapping(value = "/getAllPrestamos")
	public @ResponseBody Iterable<Prestamo> getAllPrestamos() {
		return biblioService.getAllPrestamos();
	}
	
	@GetMapping(value = "/getAllReservas")
	public @ResponseBody Iterable<Reserva> getAllReservas() {
		return biblioService.getAllReservas();
	}
	
	@GetMapping(value = "/getAllSanciones")
	public @ResponseBody Iterable<Sancion> getAllSanciones() {
		return biblioService.getAllSanciones();
	}
	
}
