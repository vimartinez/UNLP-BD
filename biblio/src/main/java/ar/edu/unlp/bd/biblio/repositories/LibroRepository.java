package ar.edu.unlp.bd.biblio.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ar.edu.unlp.bd.biblio.model.Libro;

public interface LibroRepository extends JpaRepository<Libro, Integer>, LibroRepositoryCustom  {

	@Query(value = "SELECT l FROM LIBRO l WHERE l.ESTADO = 0", nativeQuery = true)
	Iterable<Libro> getLibrosDisponibles();

	@Query(value = "SELECT * FROM LIBRO WHERE autor_autor_id = ?1 AND ESTADO = 0", nativeQuery = true)
	ArrayList<Libro> getLibrosDisponiblesPorAutor(Integer id);

	@Query(value = "SELECT * FROM LIBRO WHERE editorial_editorial_id = ?1 AND ESTADO = 0", nativeQuery = true)
	ArrayList<Libro> getLibrosDisponiblesPorEditorial(Integer id);

}
