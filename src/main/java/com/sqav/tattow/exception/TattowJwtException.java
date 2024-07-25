package com.sqav.tattow.exception;

import org.aspectj.weaver.patterns.IToken;

public class TattowJwtException extends Exception {

	private static final long serialVersionUID = -783097180279218520L;

	public TattowJwtException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public TattowJwtException(String message) {
		super(message);
	}
	
	public TattowJwtException(Throwable cause) {
		super(cause);
	}
	
	public TattowJwtException(IToken token, Throwable e) {
		super(String.format("Houve um problema ao tentar processar o token: %s", token), e);
	}
}
