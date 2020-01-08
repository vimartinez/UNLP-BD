package ar.edu.unlp.bd.biblio.repositories;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ar.edu.unlp.bd.biblio.model.Libro;

public class LibroRepositoryCustomImpl implements LibroRepositoryCustom {

	@PersistenceContext
    EntityManager entityManager;
	
	@Override
	public Iterable<Libro> getLibrosDisponiblesPorTitulo(String titulo) {
	    
	    CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Libro> query = cb.createQuery(Libro.class);
        Root<Libro> root = query.from(Libro.class);
 
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(cb.and(cb.like(root.get("titulo"), "%"+titulo+"%")));
        predicates.add(cb.and(cb.equal(root.get("estado"), 0)));
        query.select(root)
            .where(cb.and(predicates.toArray(new Predicate[predicates.size()])));
        
        return entityManager.createQuery(query).getResultList();
	}

	@Override
	public Iterable<Libro> getLibrosDisponiblesGenero(String genero) {
		 CriteriaBuilder cb = entityManager.getCriteriaBuilder();
	        CriteriaQuery<Libro> query = cb.createQuery(Libro.class);
	        Root<Libro> root = query.from(Libro.class);
	 
	        List<Predicate> predicates = new ArrayList<>();
	        predicates.add(cb.and(cb.like(root.get("genero"), "%"+genero+"%")));
	        predicates.add(cb.and(cb.equal(root.get("estado"), 0)));
	        query.select(root)
	            .where(cb.and(predicates.toArray(new Predicate[predicates.size()])));
	        
	        return entityManager.createQuery(query).getResultList();
	}
}
