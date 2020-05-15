package it.cosenzproject.cmssample.common.util;

import java.util.Optional;

import org.springframework.data.domain.Page;

import it.cosenzproject.cmssample.common.exception.ResourceNotFoundRuntimeException;

public class Assert extends org.springframework.util.Assert {

	private Assert() {
		throw new IllegalStateException("Utility Class");
	}

	public static <T> T checkResource(T t, String message) {
		if (t == null)
			throw new ResourceNotFoundRuntimeException(message);
		return t;
	}

	public static <T> T checkOptional(Optional<T> t, String message) {
		if (!t.isPresent())
			throw new ResourceNotFoundRuntimeException(message);
		return t.get();
	}

	public static <T> Page<T> checkPage(Page<T> t, String message) {
		if (!t.hasContent())
			throw new ResourceNotFoundRuntimeException(message);
		return t;
	}
}
