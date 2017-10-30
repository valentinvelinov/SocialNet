package com.socialNet.exception;



public class ConversationException extends Exception {

	private static final long serialVersionUID = 8033064693293740057L;

	public ConversationException() {
		super();
	}

	public ConversationException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public ConversationException(String arg0, Throwable cause) {
		super(arg0, cause);

	}

	public ConversationException(String arg0) {
		super(arg0);
	}

	public ConversationException(Throwable arg0) {
		super(arg0);

	}
}
