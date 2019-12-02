package ar.edu.unlp.bd.biblio.repositories;

import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ar.edu.unlp.bd.biblio.model.Autor;

@Repository
public interface AutorRepository extends CrudRepository <Autor, Integer>, AutorRepositoryCustom {

}


/*
 * public interface AutorRepository extends CrudRepository <Autor, UUID> {
 * }
 */