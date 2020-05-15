package it.cosenzproject.cmssample.common.exception;

public class ServerInternalRuntimeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 800224364521260113L;

	private final String message;

	public ServerInternalRuntimeException() {
		super();
		message = "Internal server error";
	}

	public ServerInternalRuntimeException(String message) {
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
