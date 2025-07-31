package think41.test.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import think41.test.dto.ResponseStructure;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(NoRecordsFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleNoRecordsFoundException(NoRecordsFoundException exception) {
		ResponseStructure<String> response = new ResponseStructure<String>();
		response.setStatusCode(HttpStatus.NOT_FOUND.value());
		response.setMessage("Failure");
		response.setData(exception.getMessage());
		
		return new ResponseEntity<ResponseStructure<String>>(response, HttpStatus.valueOf(response.getStatusCode()));
	}
	
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleIdNotFoundException(IdNotFoundException exception) {
		ResponseStructure<String> response = new ResponseStructure<String>();
		response.setStatusCode(HttpStatus.NOT_FOUND.value());
		response.setMessage("Failure");
		response.setData(exception.getMessage());
		
		return new ResponseEntity<ResponseStructure<String>>(response, HttpStatus.valueOf(response.getStatusCode()));
	}
}
