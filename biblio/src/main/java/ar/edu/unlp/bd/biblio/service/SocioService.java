package ar.edu.unlp.bd.biblio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlp.bd.biblio.enums.EstadoSocio;
import ar.edu.unlp.bd.biblio.error.BiblioRecordNotFoundException;
import ar.edu.unlp.bd.biblio.model.Socio;
import ar.edu.unlp.bd.biblio.repositories.SocioRepository;

@Service
public class SocioService {
	@Autowired
	private SocioRepository socioRepository;
	
	public Socio addSocio(Socio socio) {
		return socioRepository.save(socio);
	}
	
	public Socio getSocio(Integer id) {
		Socio socio = socioRepository.findById(id)
				.orElseThrow(() -> new BiblioRecordNotFoundException("Socio con el id " + id));
		return socio;
	}
	
	public Iterable<Socio> getAllSocios() {
		List<Socio> socios = null;
		socios = socioRepository.findAll();
		if (socios.size() == 0) {
			throw new BiblioRecordNotFoundException("Socios en la Base de datos.");
		}
		return socios;
	}

	public String delSocio(Integer id) {
		Socio socio = socioRepository.findById(id).orElseThrow(
				() -> new BiblioRecordNotFoundException("Socio con el id " + id + ", no se eliminó ningún registro."));
		socioRepository.delete(socio);
		return "Socio eliminado";
	}
	
	public void delAllSocios() {
		socioRepository.deleteAll();
		
	}

	public Iterable<Socio> getAllSociosActivos() {
		List<Socio> socios = null;
		socios = socioRepository.getAllSociosActivos();
		if (socios.size() == 0) {
			throw new BiblioRecordNotFoundException("Socios activos en la Base de datos.");
		}
		return socios;
	}

	public Iterable<Socio> getAllSociosPenalizados() {
		List<Socio> socios = null;
		socios = socioRepository.getAllSociosPenalizados();
		if (socios.size() == 0) {
			throw new BiblioRecordNotFoundException("Socios penalizados en la Base de datos.");
		}
		return socios;
	}

	public Socio penalizarSocio(Socio socio) {
		Socio socioActual = socioRepository.findById(socio.getSocioId()).orElseThrow(
				() -> new BiblioRecordNotFoundException("Socio con el id " + socio.getSocioId() + ", no se pudo penalizar."));
		socioActual.setEstado(EstadoSocio.PENALIZADO);
		return socioRepository.save(socioActual);
	}
}
