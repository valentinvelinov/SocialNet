package com.socialnet.exception;

public class FriendException extends Exception {

	private static final long serialVersionUID = 7981410887840202519L;

	public FriendException() {
		super();
	}

	public FriendException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public FriendException(String arg0, Throwable cause) {
		super(arg0, cause);

	}

	public FriendException(String arg0) {
		super(arg0);
	}

	public FriendException(Throwable arg0) {
		super(arg0);

	}
}
