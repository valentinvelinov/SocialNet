package com.socialNet.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.socialNet.exception.UserException;

public class User {

	private int userId;
	@NotBlank
	@Length(min = 3, max = 25)
	private String firstName;
	@NotBlank
	@Length(min = 3, max = 25)
	private String lastName;
	@Email
	private String email;
	private Date birthDate;
	@NotBlank
	private String gender;
	@NotBlank
	@Length(min = 6, max = 30)
	private String password;
	@NotBlank
	private String profilePicUrl;
	private String job;
	private String place;
	private String education;
	
	private List<User> userFriends = Collections.synchronizedList(new ArrayList<User>());

	// Login constructor
	public User(String email, String password) {
		setEmail(email);
		setPassword(password);
	}

	// Register constructor
	public User(String firstName, String lastName, String email, Date birthDate, String gender, String password) {
		setFirstName(firstName);
		setLastName(lastName);
		setEmail(email);
		setBirthDate(birthDate);
		setGender(gender);
		setPassword(password);
		setProfilePicUrl(profilePicUrl);
	}

	// Create user
	public User(int userId, String firstName, String lastName, String email, Date birthDate, String gender,
			String password) {
		this(firstName, lastName, email, birthDate, gender, password);
		setUserId(userId);
	}

	// Empty
	public User() {
	}

	// Getters and setters

	public int getUserId() {
		return userId;
	}

	public Collection<User> getUserFriends() {
		return Collections.unmodifiableCollection(this.userFriends);
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public String getGender() {
		return gender;
	}

	public String getPassword() {
		return password;
	}

	public String getProfilePicUrl() {
		return profilePicUrl;
	}

	public String getJob() {
		return job;
	}

	public String getPlace() {
		return place;
	}

	public String getEducation() {
		return education;
	}

	public void setUserFriends(List<User> userFriends) {
		this.userFriends = userFriends;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setProfilePicUrl(String profilePicUrl) {
		this.profilePicUrl = "people.png";
	}

	public void setJob(String job) throws UserException {
		if (textValidation(job)) {
			this.job = job;
		} else {
			throw new UserException("Invalid text for job!");
		}
	}

	public void setPlace(String place) throws UserException {
		if (textValidation(place)) {
			this.place = place;
		} else {
			throw new UserException("Invalid text for place!");
		}
	}
	
	public void setEducation(String education) throws UserException {
		if (textValidation(education)) {
			this.education = education;
		} else {
			throw new UserException("Invalid text for education!");
		}
	}

	public boolean textValidation(String text) {
		return (!text.matches("[a-zA-Z_]+"));

	}
	
	//Methods for customizing
	
	public void addFriend(User user) {
		this.userFriends.add(user);
		System.out.println("Friend added");
	}
	public void removeFriend(User user) {
		Iterator<User> itr = this.userFriends.iterator();
		while(itr.hasNext()) {
			User friend=(User) itr.next();
			if(friend.getEmail().equals(user.getEmail())) {
				System.out.println("Friend removed!");
				this.userFriends.remove(friend);
				break;
			}
		}
		
	}
	
}
