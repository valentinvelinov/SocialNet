package Social.user;

import java.time.LocalDateTime;

public class User {
	private int user_id;
	private String user_name;
	private String last_name;
	private String email;
	private LocalDateTime birth_date;
	private int likes_post_id;
	private int likes_user_id;
	private Gender gender;

	public User(String user_name, String last_name, String email, LocalDateTime birth_date, Gender gender) {
		super();
		this.user_name = user_name;
		this.last_name = last_name;
		this.email = email;
		this.birth_date = birth_date;
		this.gender = gender;
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

	// Getters and Setters
	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		if (user_id > 0) {
			this.user_id = user_id;
		}
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		if (validateString(user_name)) {
			this.user_name = user_name;
		}
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		if (validateString(last_name)) {
			this.last_name = last_name;
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if (validateString(email)) {
			this.email = email;
		}
	}

	public LocalDateTime getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(LocalDateTime birth_date) {
		this.birth_date = birth_date;
	}

	public int getLikes_post_id() {
		return likes_post_id;
	}

	public void setLikes_post_id(int likes_post_id) {
		if (likes_post_id > 0) {
			this.likes_post_id = likes_post_id;
		}
	}

	public int getLikes_user_id() {
		return likes_user_id;
	}

	public void setLikes_user_id(int likes_user_id) {
		if (likes_user_id > 0) {
			this.likes_user_id = likes_user_id;
		}
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	private static boolean validateString(String text) {
		return text != null && text.isEmpty();
	}

}
