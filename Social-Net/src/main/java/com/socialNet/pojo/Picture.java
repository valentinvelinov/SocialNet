package com.socialNet.pojo;

import com.socialNet.exceptions.MessageException;
import com.socialNet.exceptions.PictureException;

public class Picture {

	private int picture_id;
	private String name;
	private int user_id;

	public Picture(String name, int user_id) {
		this.name = name;
		this.user_id = user_id;
	}

	public Picture(int picture_id, String name, int user_id) {
		this(name, user_id);
		this.picture_id = picture_id;
	}

	public int getPicture_id() {
		return picture_id;
	}

	public void setPicture_id(int picture_id) throws PictureException {
		if (picture_id > 0) {
			this.picture_id = picture_id;
		} else {
			throw new PictureException("Invalid picture_id!");
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) throws PictureException {
		if (isValidText(name)) {
			this.name = name;
		} else {
			throw new PictureException("Invalid name!");
		}
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) throws PictureException {
		if (user_id > 0) {
			this.user_id = user_id;
		} else {
			throw new PictureException("Invalid picture_id!");
		}
	}

	private boolean isValidText(String text) {
		return text != null && !text.isEmpty();
	}
}
