package ar.edu.unlp.bd.biblio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlp.bd.biblio.error.BiblioRecordNotFoundException;
import ar.edu.unlp.bd.biblio.model.Prestamo;
import ar.edu.unlp.bd.biblio.repositories.PrestamoRepository;

@Service
public class PrestamoService {
	@Autowired
	private PrestamoRepository prestamoRepository;
	
	public Prestamo addPrestamo(Prestamo prestamo) {
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
}
