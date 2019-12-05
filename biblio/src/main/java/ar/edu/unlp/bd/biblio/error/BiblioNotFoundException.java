package ar.edu.unlp.bd.biblio.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BiblioNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 8901992376504964364L;

	public BiblioNotFoundException(String message) {
		super("No se encontró " + message);
	}
}
