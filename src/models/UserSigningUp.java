package models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class UserSigningUp {
	
	@NotEmpty
	@Email
	private String email;
	
	@NotEmpty
	@Size(min=5, max=15, message="Your password should be between {2} and {1} characters long.")
	private String password;
	
	@NotNull(message="Please pick a vehical.")
	private Integer vehicalType;
	
	private String Location;
	
	public UserSigningUp(String email, String password, Integer vehicalType) {
		this.email = email;
		this.password = password;
		this.vehicalType = vehicalType;
		this.Location = null;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public Integer getVehicalType() {
		return vehicalType;
	}

	public String getLocation() {
		return Location;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setVehicalType(Integer vehicalType) {
		this.vehicalType = vehicalType;
	}

	public void setLocation(String location) {
		Location = location;
	}

	@Override
	public String toString() {
		return "UserSigningUp [email=" + email + ", password=" + password + ", vehicalType=" + vehicalType
				+ ", Location=" + Location + "]";
	}
	
	
	
}
