package it.cosenzproject.cmssample.core.command;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;

import it.cosenzproject.cmssample.common.exception.ServerInternalRuntimeException;
import it.cosenzproject.cmssample.core.userdata.AbstractUserDataContainer;

public abstract class AbstractCommand {

	/**
	 * The user data container.
	 */
	@Autowired
	private AbstractUserDataContainer<?> userDataContainer;

	/**
	 * Gets the user data.
	 *
	 * @param <T> the generic type
	 * @return the user data
	 */
	@SuppressWarnings("unchecked")
	protected <T extends UserDetails> T getUserDetails() {
		return (T) this.userDataContainer.getUserDetails();
	}

	/**
	 * Executing functions in parallel via {@link ForkJoinPool}
	 * 
	 * @param <C> an array of type {@link Callable}
	 * @return a {@link List} of items of class <b>C</b>
	 * 
	 */
	@SuppressWarnings("unchecked")
	protected <C> List<C> parallel(Callable<C>... callables) {
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		List<C> result = forkJoinPool.invokeAll(Arrays.asList(callables)).stream().map(f -> {
			try {
				return f.get();
			} catch (InterruptedException | ExecutionException e) {
				forkJoinPool.shutdown();
				Throwable ex = getException(e.getCause());
				if (ex instanceof RuntimeException) {
					throw (RuntimeException) getException(e.getCause());
				}
				throw new ServerInternalRuntimeException(ex.getMessage());
			}
		}).collect(Collectors.toList());
		forkJoinPool.shutdown();

		return result;
	}

	private Throwable getException(Throwable throwable) {
		if (Objects.nonNull(throwable.getCause())) {
			return getException(throwable.getCause());
		}
		return throwable;
	}
}
