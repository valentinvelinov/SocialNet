package com.socialNet.model;

import java.util.Date;

import com.socialNet.exception.UserException;

public class User {
	private int userId;
	private String firstName;
	private String lastName;
	private String email;
	private Date birthDate;
	private String gender;
	private String password;
	private String profilePicUrl;
	private String coverPicUrl;
	private String job;
	private String place;
	private String education;

	public User(String email, String password) throws UserException {
		setEmail(email);
		setPassword(password);
	}

	public User(String firstName, String lastName, String email, Date birthDate, String gender, String password)
			throws UserException {
		setFirstName(firstName);
		setLastName(lastName);
		setEmail(email);
		setBirthDate(birthDate);
		setGender(gender);
		setPassword(password);
	}

	public User(int userId, String firstName, String lastName, String email, Date birthDate, String gender,
			String password) throws UserException {
		setUserId(userId);
		setFirstName(firstName);
		setLastName(lastName);
		setEmail(email);
		setBirthDate(birthDate);
		setGender(gender);
		setPassword(password);
	}

	public User() {
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
	public String getProfilePicUrl() {
		return profilePicUrl;
	}

	public void setProfilePicUrl(String profilePicUrl) throws UserException {
		if (validateString(profilePicUrl)) {
			this.profilePicUrl = profilePicUrl;
		} else {
			profilePicUrl = "person.gif";

		}
	}

	public String getCoverPicUrl() {
		return coverPicUrl;
	}

	public void setCoverPicUrl(String coverPicUrl) throws UserException {
		this.coverPicUrl = coverPicUrl;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		if (userId > 0) {
			this.userId = userId;
		}
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) throws UserException {
		if (validateString(firstName)) {
			this.firstName = firstName;
		} else {
			throw new UserException("Your first name is invalid, please try again!");
		}
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) throws UserException {
		if (validateString(lastName)) {
			this.lastName = lastName;
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

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String text) throws UserException {
		if (validateString(text)) {
			this.gender = text;
		} else {
			throw new UserException("Invalid gender!");
		}
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) throws UserException {
		this.job = job;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) throws UserException {
		this.place = place;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) throws UserException {
		this.place = education;
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
