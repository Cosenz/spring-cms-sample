package it.cosenzproject.cmssample.common.model.viewmodel;

public class ErrorResponse {

	private Integer errorCode;
	private String message;

	public ErrorResponse() {
	}

	public ErrorResponse(String message) {
		super();
		this.message = message;
	}

	public ErrorResponse(Integer errorCode, String message) {
		super();
		this.errorCode = errorCode;
		this.message = message;
	}

	/**
	 * @return the errorCode
	 */
	public Integer getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

}
