package it.cosenzproject.cmssample.common.exception;

public class InvalidInputRuntimeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8441479670097813790L;

	private final String message;

	public InvalidInputRuntimeException(String message) {
		super();
		this.message = message;
	}

	/**
	 * @return the message
	 */
	@Override
	public String getMessage() {
		return message;
	}
}
