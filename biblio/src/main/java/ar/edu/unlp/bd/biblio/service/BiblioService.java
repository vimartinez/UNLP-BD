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
	
	public Iterable<Prestamo> getAllPrestamos() {
		return prestamoService.getAllPrestamos();
	}
	public Iterable<Sancion> getAllSanciones() {
		return sancionService.getAllSanciones();
	}

		
}
