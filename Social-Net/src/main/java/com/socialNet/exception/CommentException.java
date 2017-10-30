package com.socialnet.exception;


public class CommentException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CommentException() {
		super();
	}

	public CommentException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public CommentException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	
	}

	public CommentException(String arg0) {
		super(arg0);
	}

	public CommentException(Throwable arg0) {
		super(arg0);
	}

	
}
