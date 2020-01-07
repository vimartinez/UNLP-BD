package ar.edu.unlp.bd.biblio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlp.bd.biblio.error.BiblioRecordNotFoundException;
import ar.edu.unlp.bd.biblio.model.Reserva;
import ar.edu.unlp.bd.biblio.repositories.ReservaRepository;

@Service
public class ReservaService {
	@Autowired
	private ReservaRepository reservaRepository;
	
	public Reserva addReserva(Reserva reserva) {
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
}
