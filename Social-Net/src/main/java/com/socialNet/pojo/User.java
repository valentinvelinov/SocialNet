package com.socialNet.pojo;

import java.util.Date;

import com.socialNet.exceptions.UserException;

public class User {
	private int user_id;
	private String first_name;
	private String last_name;
	private String email;
	private Date birth_date;
	private Gender gender;
	private String password;
	private String profile_pic_url;
	private String cover_pic_url;

	public User(String first_name, String last_name, String email, Date birth_date, Gender gender, String password)
			throws UserException {
		setFirst_name(first_name);
		setLast_name(last_name);
		setEmail(email);
		setBirth_date(birth_date);
		setGender(gender);
		setPassword(password);
	}

	public User(String email, String password) throws UserException {
		super();
		setEmail(email);
		setPassword(password);
	}

	public User(int user_id, String first_name, String last_name, String email, Date birth_date, Gender gender,
			String password) throws UserException {
		super();
		setUser_id(user_id);
		setFirst_name(first_name);
		setLast_name(last_name);
		setEmail(email);
		setBirth_date(birth_date);
		setGender(gender);
		setPassword(password);
	}

	public enum Gender {
		MALE, FEMALE;
	}

	// Hashcode and equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		if (validateString(password)) {
			this.password = password;
		}
	}

	// Getters and Setters
	public String getProfile_pic_url() {
		return profile_pic_url;
	}

	public void setProfile_pic_url(String profile_pic_url) throws UserException {
		if (validateString(profile_pic_url)) {
			this.profile_pic_url = profile_pic_url;
		} else {
			throw new UserException("Invalid photo, please try again!");
		}
	}

	public String getCover_pic_url() {
		return cover_pic_url;
	}

	public void setCover_pic_url(String cover_pic_url) throws UserException {
		if (validateString(cover_pic_url)) {
			this.cover_pic_url = cover_pic_url;
		} else {
			throw new UserException("Invalid photo, please try again!");
		}
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		if (user_id > 0) {
			this.user_id = user_id;
		}
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) throws UserException {
		if (validateString(first_name)) {
			this.first_name = first_name;
		} else {
			throw new UserException("Your first name is invalid, please try again!");
		}
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) throws UserException {
		if (validateString(last_name)) {
			this.last_name = last_name;
		} else {
			throw new UserException("Your last name is invalid, please try again!");
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) throws UserException {
		if (isValidEmailAddress(email)) {
			this.email = email;
		} else {
			throw new UserException("Your email address is invalid, please try again!");
		}
	}

	public Date getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(Date birth_date) {
		this.birth_date = birth_date;
	}

	public String getGender() {
		return gender.toString();
	}

	public void setGender(Gender gender) throws UserException {
		if (gender != null) {
			this.gender = gender;
		} else {
			throw new UserException("Your gender is invalid, please try again!");
		}
	}

	public boolean validateString(String text) {
		return text != null && !text.isEmpty();
	}

	public boolean isValidEmailAddress(String email) {
		String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
		java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
		java.util.regex.Matcher m = p.matcher(email);
		return m.matches();
	}

}
