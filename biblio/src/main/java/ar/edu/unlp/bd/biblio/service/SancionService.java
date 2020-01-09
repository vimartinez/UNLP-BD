package ar.edu.unlp.bd.biblio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlp.bd.biblio.enums.EstadoSocio;
import ar.edu.unlp.bd.biblio.error.BiblioRecordNotFoundException;
import ar.edu.unlp.bd.biblio.model.Sancion;
import ar.edu.unlp.bd.biblio.model.Socio;
import ar.edu.unlp.bd.biblio.repositories.SancionRepository;

@Service
public class SancionService {
	@Autowired
	private SancionRepository sancionRepository;
	@Autowired
	private SocioService socioService;
	
	public Sancion addSancion(Sancion sancion) {
		
		Socio socio = socioService.getSocio(sancion.getSocio().getSocioId());
		socio.setEstado(EstadoSocio.PENALIZADO);
		sancion.setSocio(socio);
		return sancionRepository.save(sancion);
	}
	
	public Iterable<Sancion> getAllSanciones() {
		List<Sancion> sanciones = null;
		sanciones = sancionRepository.findAll();
		if (sanciones.size() == 0) {
			throw new BiblioRecordNotFoundException("Sanciones en la Base de datos.");
		}
		return sanciones;
	}

	public String delSancion(Integer id) {
		Sancion sancion = sancionRepository.findById(id).orElseThrow(
				() -> new BiblioRecordNotFoundException("Sancion con el id " + id + ", no se eliminó ningún registro."));
		sancionRepository.delete(sancion);
		return "Sancion eliminado";
	}
	
	public void delAllSanciones() {
		sancionRepository.deleteAll();
		
	}
}
