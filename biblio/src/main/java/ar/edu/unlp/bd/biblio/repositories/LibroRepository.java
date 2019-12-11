package ar.edu.unlp.bd.biblio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.unlp.bd.biblio.model.Libro;

public interface LibroRepository extends JpaRepository<Libro, Integer> {

}
