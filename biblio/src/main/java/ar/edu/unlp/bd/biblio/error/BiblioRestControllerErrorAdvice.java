package ar.edu.unlp.bd.biblio.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@ControllerAdvice
public class BiblioRestControllerErrorAdvice extends ResponseEntityExceptionHandler {
	
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
    @ExceptionHandler({BiblioRecordNotFoundException.class})
    public BiblioResponse handleNotFoundException(BiblioRecordNotFoundException e) {
		BiblioResponse response = new BiblioResponse("Objeto no encontrado", e.getMessage(), OK.name(), OK.value());
		return response;
    }
	
	@ResponseBody
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler({Exception.class})
    public BiblioResponse handleRunTimeException(Exception e) {
		BiblioResponse response = new BiblioResponse("Error en la aplicación", e.getMessage(), INTERNAL_SERVER_ERROR.name(), INTERNAL_SERVER_ERROR.value());
		return response;
    }
}
