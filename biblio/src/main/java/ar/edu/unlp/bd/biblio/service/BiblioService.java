package ar.edu.unlp.bd.biblio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlp.bd.biblio.model.Libro;
import ar.edu.unlp.bd.biblio.model.Prestamo;
import ar.edu.unlp.bd.biblio.model.Reserva;
import ar.edu.unlp.bd.biblio.model.Sancion;

@Service
public class BiblioService {
	@Autowired
	private LibroService libroService;
	@Autowired
	private ReservaService reservaService;
	@Autowired
	private PrestamoService prestamoService;
	@Autowired
	private SancionService sancionService;
	
	public Iterable<Libro> getAllLibros() {
		return libroService.getAllLibros();
	}
	
	public Iterable<Libro> getLibrosDisponibles() {
		return libroService.getLibrosDisponibles();
	}
	
	public Iterable<Reserva> getAllReservas() {
		return reservaService.getAllReservas();
	}
	
	public Iterable<Sancion> getAllSanciones() {
		return sancionService.getAllSanciones();
	}

	public Iterable<Libro> getLibrosDisponiblesPorTitulo(String titulo) {
		return libroService.getLibrosDisponiblesPorTitulo(titulo);
	}
	
	public Iterable<Libro> getLibrosDisponiblesPorAutor(Integer id) {
		return libroService.getLibrosDisponiblesPorAutor(id);
	}

	public Iterable<Libro> getLibrosDisponiblesPorEditorial(Integer id) {
		return libroService.getLibrosDisponiblesPorEditorial(id);
	}

	public Iterable<Libro> getLibrosDisponiblesPorGenero(String genero) {
		return libroService.getLibrosDisponiblesPorGenero(genero);
	}
	
	public Iterable<Prestamo> getAllPrestamos() {
		return prestamoService.getAllPrestamos();
	}
	
	public Prestamo addPrestamo(Prestamo prestamo) {
		return prestamoService.addPrestamo(prestamo);
	}

	public Prestamo addPrestamo(Reserva reserva) {
		return prestamoService.addPrestamo(reserva);
	}

		
}
