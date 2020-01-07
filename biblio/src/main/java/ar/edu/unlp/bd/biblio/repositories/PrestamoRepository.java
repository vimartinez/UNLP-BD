package ar.edu.unlp.bd.biblio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.unlp.bd.biblio.model.Prestamo;

public interface PrestamoRepository extends JpaRepository<Prestamo, Integer> {

}
