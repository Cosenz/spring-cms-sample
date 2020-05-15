package it.cosenzproject.cmssample.common.exception;

public class ResourceNotFoundRuntimeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7184757677506477039L;

	private final String message;

	public ResourceNotFoundRuntimeException(String message) {
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
