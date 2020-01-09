package ar.edu.unlp.bd.biblio.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping(value = "/getLibrosDisponiblesPorTitulo/{titulo}")
	public @ResponseBody Iterable<Libro> getLibrosDisponiblesPorTitulo(@PathVariable("titulo") String titulo) {
		return biblioService.getLibrosDisponiblesPorTitulo(titulo);
	}
	
	@GetMapping(value = "/getLibrosDisponiblesPorAutor/{id}")
	public @ResponseBody Iterable<Libro> getLibrosDisponiblesPorAutor(@PathVariable("id") Integer id) {
		return biblioService.getLibrosDisponiblesPorAutor(id);
	}
	
	@GetMapping(value = "/getLibrosDisponiblesPorEditorial/{id}")
	public @ResponseBody Iterable<Libro> getLibrosDisponiblesPorEditorial(@PathVariable("id") Integer id) {
		return biblioService.getLibrosDisponiblesPorEditorial(id);
	}
	
	@GetMapping(value = "/getLibrosDisponiblesPorGenero/{genero}")
	public @ResponseBody Iterable<Libro> getLibrosDisponiblesPorGenero(@PathVariable("genero") String genero) {
		return biblioService.getLibrosDisponiblesPorGenero(genero);
	}
	
	@GetMapping(value = "/getAllPrestamos")
	public @ResponseBody Iterable<Prestamo> getAllPrestamos() {
		return biblioService.getAllPrestamos();
	}
	
	@PostMapping(path = "/addPrestamo", produces = "application/json")
	public @ResponseBody Prestamo addPrestamo(@RequestBody Prestamo prestamo) {
		return biblioService.addPrestamo(prestamo);
	}
	
	@PostMapping(path = "/addPrestamoReserva", produces = "application/json")
	public @ResponseBody Prestamo addPrestamo(@RequestBody Reserva reserva) {
		return biblioService.addPrestamo(reserva);
	}
	
	@GetMapping(value = "/getAllReservas")
	public @ResponseBody Iterable<Reserva> getAllReservas() {
		return biblioService.getAllReservas();
	}
	
	@PostMapping(path = "/addReserva", produces = "application/json")
	public @ResponseBody Reserva addReserrva(@RequestBody Reserva reserva) {
		return biblioService.addReserva(reserva);
	}
	
	@GetMapping(value = "/getAllSanciones")
	public @ResponseBody Iterable<Sancion> getAllSanciones() {
		return biblioService.getAllSanciones();
	}
	
}
