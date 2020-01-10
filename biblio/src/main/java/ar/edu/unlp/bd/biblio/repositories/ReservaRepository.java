package ar.edu.unlp.bd.biblio.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ar.edu.unlp.bd.biblio.model.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Integer> {

	@Query(value = "SELECT * FROM RESERVA  WHERE ESTADO = 0 AND FECHA_CADUCIDAD < SYSDATE()", nativeQuery = true)
	List<Reserva> getAllReservasValidas();

}
