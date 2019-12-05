package ar.edu.unlp.bd.biblio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ar.edu.unlp.bd.biblio.model.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Integer>, AutorRepositoryCustom {

}
