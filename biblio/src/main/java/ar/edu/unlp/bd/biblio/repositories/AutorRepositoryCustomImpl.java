package ar.edu.unlp.bd.biblio.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import ar.edu.unlp.bd.biblio.model.Autor;

public class AutorRepositoryCustomImpl implements AutorRepositoryCustom {
	
	@PersistenceContext
    EntityManager entityManager;

	@Override
	public Autor getAutorById(Integer id) {
		Query query = entityManager.createNativeQuery("SELECT * FROM Autor " +
                "WHERE id = ?", Autor.class);
        query.setParameter(1, id + "");
        return (Autor) query.getResultList();

	}
}
