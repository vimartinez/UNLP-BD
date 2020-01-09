package ar.edu.unlp.bd.biblio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlp.bd.biblio.enums.EstadoLibro;
import ar.edu.unlp.bd.biblio.enums.EstadoSocio;
import ar.edu.unlp.bd.biblio.error.BiblioRecordException;
import ar.edu.unlp.bd.biblio.error.BiblioRecordNotFoundException;
import ar.edu.unlp.bd.biblio.model.Libro;
import ar.edu.unlp.bd.biblio.model.Reserva;
import ar.edu.unlp.bd.biblio.model.Socio;
import ar.edu.unlp.bd.biblio.repositories.ReservaRepository;

@Service
public class ReservaService {
	@Autowired
	private ReservaRepository reservaRepository;
	@Autowired
	private LibroService libroService;
	@Autowired
	private SocioService socioService;
	
	public Reserva addReserva(Reserva reserva) {
		Libro libro = libroService.getLibro(reserva.getLibro().getLibroId());
		if (libro.getEstado() != EstadoLibro.DISPONIBLE) 
			throw new BiblioRecordException("generar la reserva, el libro id: "+libro.getLibroId()+" no está disponible");
	    libro.setEstado(EstadoLibro.RESERVADO);
	    reserva.setLibro(libro);
		Socio socio = socioService.getSocio(reserva.getSocio().getSocioId());
		if (socio.getEstado() != EstadoSocio.ACTIVO) 
			throw new BiblioRecordException("generar la reserva, el socio id: "+socio.getSocioId()+" no está activo");
		reserva.setSocio(socio);	
		
		return reservaRepository.save(reserva);
	}
	
	public Iterable<Reserva> getAllReservas() {
		List<Reserva> reservas = null;
		reservas = reservaRepository.findAll();
		if (reservas.size() == 0) {
			throw new BiblioRecordNotFoundException("Reservas en la Base de datos.");
		}
		return reservas;
	}

	public String delReserva(Integer id) {
		Reserva reserva = reservaRepository.findById(id).orElseThrow(
				() -> new BiblioRecordNotFoundException("Reserva con el id " + id + ", no se eliminó ningún registro."));
		reservaRepository.delete(reserva);
		return "Reserva eliminado";
	}
	
	public void delAllReservas() {
		reservaRepository.deleteAll();
		
	}
	
	public Reserva getReserva(Integer id) {
		Reserva reserva = reservaRepository.findById(id)
				.orElseThrow(() -> new BiblioRecordNotFoundException("Reserva con el id " + id));
		return reserva;
	}
}
