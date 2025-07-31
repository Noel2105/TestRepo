package think41.test.exception;

public class IdNotFoundException extends RuntimeException{
	public IdNotFoundException(String message) {
		super(message);
	}
}
