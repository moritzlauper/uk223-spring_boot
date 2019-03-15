package ch.noseryoung.uk223.exceptionHandling;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author Moritz Lauper
 */
@ControllerAdvice
public class RestExceptionHandler {
	
	@ExceptionHandler(value = NoSuchElementException.class)
	public ResponseEntity<Object> exception(NoSuchElementException exception) {
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
