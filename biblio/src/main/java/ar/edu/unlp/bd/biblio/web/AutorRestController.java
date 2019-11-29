package ar.edu.unlp.bd.biblio.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ar.edu.unlp.bd.biblio.model.Autor;
import ar.edu.unlp.bd.biblio.repositories.AutorRepository;
import ar.edu.unlp.bd.biblio.repositories.AutorRepositoryCustom;

@Controller
@RequestMapping(path="/Autor")
public class AutorRestController {
@Autowired
  private AutorRepository autorRepository;
private AutorRepositoryCustom autorRepositoryCustom;

  @PostMapping(path="/add")
  public @ResponseBody String addAutor (@RequestParam(value = "nombre", defaultValue = "sinNombre") String nombre,
	@RequestParam(value = "nacionalidad", defaultValue = "sinNacionalidad") String nacionalidad){

	Autor a = new Autor(nombre, nacionalidad);
    autorRepository.save(a);
    return "Autor guardado";
  }
  
  @PostMapping(path="/del")
  public @ResponseBody String delAutor (@RequestParam(value = "id") Integer id){
	  
	Autor a = autorRepositoryCustom.getAutorById(id);
	a.setEliminado(true);
    autorRepository.save(a);
    return "Autor eliminado";
  }

  @GetMapping(path="/all")
  public @ResponseBody Iterable<Autor> getAllAutores() {
    return autorRepository.findAll();
  }
}
