package Social.user;

import java.sql.Date;
import java.time.LocalDateTime;

public class User {
	private int user_id;
	private String first_name;
	private String last_name;
	private String email;
	private Date birth_date;
	private Gender gender;
	private String password;

	public User(String first_name, String last_name, String email, Date birth_date, Gender gender) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.birth_date = birth_date;
		this.gender = gender;
		this.password = password;
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

	public void setFirst_name(String first_name) {
		if (validateString(first_name)) {
			this.first_name = first_name;
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

	public Date getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(Date birth_date) {
		this.birth_date = birth_date;
	}

	public String getGender() {
		return gender.toString();
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	private static boolean validateString(String text) {
		return text != null && text.isEmpty();
	}

}
