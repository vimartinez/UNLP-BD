package ar.edu.unlp.bd.biblio.util;

import java.util.ArrayList;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

import ar.edu.unlp.bd.biblio.model.Autor;
import ar.edu.unlp.bd.biblio.model.Biblio;
import ar.edu.unlp.bd.biblio.model.Libro;
import ar.edu.unlp.bd.biblio.repositories.AutorRepository;
import ar.edu.unlp.bd.biblio.service.AutorService;
import ar.edu.unlp.bd.biblio.service.BiblioService;

@Controller
//@Configuration
public class DBLoader {
	@Autowired
	private AutorService autorService;
	
	@Autowired
	private AutorRepository autorRepository;
	
	
	//private static SessionFactory sessions;
	
	public DBLoader() {
	}

 //   @PostConstruct
	public void main() throws Exception {
		
		/*Biblio biblio = new Biblio();
		ArrayList<Libro> libros = biblio.getLibros();
		System.out.println("Listado de libros");
		for (int i=0; i < libros.size(); i++ ) {
			System.out.println(libros.get(i).getTitulo());
			
		}*/
		
		Autor autor = new Autor("Santiago Posteguillo", "España");
		DBLoader dbloader = new DBLoader();
		
		dbloader.generarDatos();
		
	}
	
	public  void generarDatos() throws Exception {
		Autor autor = new Autor("Santiago Posteguillo", "España");
		autorService.addAutor(autor);
		autorRepository.save(autor);
	}
}
