package com.socialNet.exception;
public class PictureException extends Exception {

	private static final long serialVersionUID = 1L;

	public PictureException() {
		super();
	}

	public PictureException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public PictureException(String arg0, Throwable arg1) {
		super(arg0, arg1);

	}

	public PictureException(String arg0) {
		super(arg0);
	}

	public PictureException(Throwable arg0) {
		super(arg0);
	}

}
