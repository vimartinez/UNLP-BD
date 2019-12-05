package ar.edu.unlp.bd.biblio.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class BiblioRestControllerErrorAdvice extends ResponseEntityExceptionHandler {
	@ExceptionHandler({BiblioRuntimeException.class})
    public ResponseEntity<String> handleRunTimeException(BiblioRuntimeException e) {
        return error(INTERNAL_SERVER_ERROR, e);
    }
    @ExceptionHandler({BiblioNotFoundException.class})
    public ResponseEntity<String> handleNotFoundException(BiblioNotFoundException e) {
        return error(NOT_FOUND, e);
    }

    private ResponseEntity<String> error(HttpStatus status, Exception e) {
    	ObjectMapper mapper = new ObjectMapper();
    	BiblioResponse response = new BiblioResponse(e.getMessage(), status.name(), status.value());
    	String jsonString = null;
		try {
			jsonString = mapper.writeValueAsString(response);
		} catch (JsonProcessingException e1) {
			e1.printStackTrace();
		}
        return ResponseEntity.status(status).body(jsonString);
    }

}
