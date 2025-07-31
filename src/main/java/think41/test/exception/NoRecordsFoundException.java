package think41.test.exception;

public class NoRecordsFoundException extends RuntimeException {
	public NoRecordsFoundException(String message) {
		super(message);
	}
}
