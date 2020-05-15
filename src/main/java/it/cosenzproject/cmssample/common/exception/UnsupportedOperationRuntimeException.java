package it.cosenzproject.cmssample.common.exception;

public class UnsupportedOperationRuntimeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7839426178648350674L;

	private final String message;

	public UnsupportedOperationRuntimeException(String message) {
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
