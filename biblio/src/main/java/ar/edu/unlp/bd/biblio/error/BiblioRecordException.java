package ar.edu.unlp.bd.biblio.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class BiblioRecordException extends RuntimeException {

	private static final long serialVersionUID = 8901992376504964363L;

	public BiblioRecordException(String message) {
		super("No se pudo " + message);
	}
}
