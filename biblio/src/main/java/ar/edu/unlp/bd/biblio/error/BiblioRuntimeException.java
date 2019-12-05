package ar.edu.unlp.bd.biblio.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class BiblioRuntimeException extends RuntimeException {

	private static final long serialVersionUID = 7266640914868251776L;

	public BiblioRuntimeException(String message) {
		super("Atención Error en la aplicación: " + message);
	}
}
