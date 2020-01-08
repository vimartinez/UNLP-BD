package ar.edu.unlp.bd.biblio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ar.edu.unlp.bd.biblio.model.Prestamo;

public interface PrestamoRepository extends JpaRepository<Prestamo, Integer> {
	
	@Query(value = "SELECT * FROM PRESTAMO WHERE libro_id = ?1 AND ESTADO = 0", nativeQuery = true)
	Prestamo getPrestamoActivoPorIdLibro(Integer id);

}
