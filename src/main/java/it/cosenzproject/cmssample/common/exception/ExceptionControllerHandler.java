package it.cosenzproject.cmssample.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import it.cosenzproject.cmssample.common.model.viewmodel.ErrorResponse;

@ControllerAdvice
public class ExceptionControllerHandler {

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public ErrorResponse handlerException(Exception ex) {
		return new ErrorResponse(500, ex.getMessage());
	}

	@ExceptionHandler({ InvalidInputRuntimeException.class })
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ErrorResponse handlerException(InvalidInputRuntimeException ex) {
		return new ErrorResponse(400, ex.getMessage());
	}

	@ExceptionHandler({ MethodArgumentTypeMismatchException.class })
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ErrorResponse handlerException(MethodArgumentTypeMismatchException ex) {
		return new ErrorResponse(400, ex.getMessage());
	}

	@ExceptionHandler(ResourceNotFoundRuntimeException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ResponseBody
	public ErrorResponse handlerException(ResourceNotFoundRuntimeException ex) {
		return new ErrorResponse(404, ex.getMessage());
	}
}
