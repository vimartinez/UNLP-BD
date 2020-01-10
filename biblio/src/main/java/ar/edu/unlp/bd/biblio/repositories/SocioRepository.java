package ar.edu.unlp.bd.biblio.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ar.edu.unlp.bd.biblio.model.Socio;

public interface SocioRepository extends JpaRepository<Socio, Integer> {

	@Query(value = "SELECT * FROM SOCIO  WHERE ESTADO = 1", nativeQuery = true)
	List<Socio> getAllSociosActivos();

	@Query(value = "SELECT * FROM SOCIO  WHERE ESTADO = 2", nativeQuery = true)
	List<Socio> getAllSociosPenalizados();

}
