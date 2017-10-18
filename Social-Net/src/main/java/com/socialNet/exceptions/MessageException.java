package com.socialNet.exceptions;

public class MessageException extends Exception {

	private static final long serialVersionUID = -1734657767430427594L;

	public MessageException() {
		super();
	}

	public MessageException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public MessageException(String arg0, Throwable cause) {
		super(arg0, cause);

	}

	public MessageException(String arg0) {
		super(arg0);
	}

	public MessageException(Throwable arg0) {
		super(arg0);

	}
}
