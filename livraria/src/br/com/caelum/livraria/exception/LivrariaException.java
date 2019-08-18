package br.com.caelum.livraria.exception;

import javax.ejb.ApplicationException;

// Application exceptions by default don't perform rollbacks (except if configured) and the session beans aren't invalidated.
// On other hand, system exceptions always do both the rollback and the session bean invalidation.

// Checked exceptions behave like a default application exception.
// Unchecked exceptions (i. e., RuntimeExceptions) behave the same as system exceptions (except if they were annotated as an ApplicationException).

@ApplicationException(rollback = true)
public class LivrariaException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public LivrariaException(String message) {
		super(message);
	}

}
