package models;

public class User {
	
	
	private String email;
	
	private String password;
	
	private int vehicalType;
	
	private String Location;
	
	public User(String email, String password, int vehicalType) {
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

	public int getVehicalType() {
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

	public void setVehicalType(int vehicalType) {
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
