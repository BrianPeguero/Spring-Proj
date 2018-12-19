package enums;

public enum UserEnum {
	GET_USER_BY_EMAIL("SELECT * FROM users WHERE email=?"),
	GET_LOCATION_OF_CAR("SELECT location FROM users WHERE email=?"),
	RELEASE_LOC_OF_CAR("UPDATE users SET location = null WHERE email=?"),
	UPDATE_LOC("UPDATE users SET location=? WHERE email=?"),
	NEW_USER("INSERT INTO users VALUES(?,?,?,null)"),
	GET_LOCATION_OF_ALL_CARS("SELECT location FROM users");
	
	public String getQuery() {
		return this.query;
	}
	
	String query;
	
	private UserEnum(String query) {
		this.query = query;
	}
}
