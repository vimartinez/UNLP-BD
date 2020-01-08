package ar.edu.unlp.bd.biblio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlp.bd.biblio.enums.EstadoLibro;
import ar.edu.unlp.bd.biblio.enums.EstadoSocio;
import ar.edu.unlp.bd.biblio.error.BiblioRecordNotFoundException;
import ar.edu.unlp.bd.biblio.error.BiblioRecordException;
import ar.edu.unlp.bd.biblio.model.Libro;
import ar.edu.unlp.bd.biblio.model.Prestamo;
import ar.edu.unlp.bd.biblio.model.Socio;
import ar.edu.unlp.bd.biblio.repositories.PrestamoRepository;
import ar.edu.unlp.bd.biblio.service.LibroService;
import ar.edu.unlp.bd.biblio.service.SocioService;

@Service
public class PrestamoService {
	@Autowired
	private PrestamoRepository prestamoRepository;
	@Autowired
	private LibroService libroService;
	@Autowired
	private SocioService socioService;
	
	public Prestamo addPrestamo(Prestamo prestamo) {
		Libro libro = libroService.getLibro(prestamo.getLibro().getId());
		if (libro.getEstado() != EstadoLibro.DISPONIBLE && libro.getEstado() != EstadoLibro.RESERVADO) throw new BiblioRecordException("generar el prestamo, el libro no está disponible");
	    libro.setEstado(EstadoLibro.PRESTADO);
	    prestamo.setLibro(libro);
		Socio socio = socioService.getSocio(prestamo.getSocio().getSocioId());
		if (socio.getEstado() != EstadoSocio.ACTIVO) throw new BiblioRecordException("generar el prestamo, el socio no está activo");
		prestamo.setSocio(socio);
		return prestamoRepository.save(prestamo);
	}
	
	public Iterable<Prestamo> getAllPrestamos() {
		List<Prestamo> prestamos = null;
		prestamos = prestamoRepository.findAll();
		if (prestamos.size() == 0) {
			throw new BiblioRecordNotFoundException("Prestamos en la Base de datos.");
		}
		return prestamos;
	}

	public String delPrestamo(Integer id) {
		Prestamo prestamo = prestamoRepository.findById(id).orElseThrow(
				() -> new BiblioRecordNotFoundException("Prestamo con el id " + id + ", no se eliminó ningún registro."));
		prestamoRepository.delete(prestamo);
		return "Prestamo eliminado";
	}
	
	public void delAllPrestamos() {
		prestamoRepository.deleteAll();
		
	}
	
	public Prestamo getPrestamoActivoPorIdLibro(Integer id) {
		return prestamoRepository.getPrestamoActivoPorIdLibro(id);
	}
}
