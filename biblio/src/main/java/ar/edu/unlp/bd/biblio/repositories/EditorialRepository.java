package ar.edu.unlp.bd.biblio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unlp.bd.biblio.model.Editorial;

@Repository
public interface EditorialRepository extends JpaRepository<Editorial, Integer> {

}
