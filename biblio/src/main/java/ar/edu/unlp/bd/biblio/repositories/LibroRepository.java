package ar.edu.unlp.bd.biblio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ar.edu.unlp.bd.biblio.model.Libro;

public interface LibroRepository extends JpaRepository<Libro, Integer> {

	@Query(value = "SELECT * FROM LIBRO WHERE ESTADO = 0", nativeQuery = true)
	Iterable<Libro> getLibrosDisponibles();

}
