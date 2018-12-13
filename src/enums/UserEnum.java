package enums;

public enum UserEnum {
	GET_USER_BY_EMAIL("SELECT * FROM user WHERE email=?"),
	GET_LOCATION_OF_CAR("SELECT location FROM user"),
	RELEASE_LOC_OF_CAR("UPDATE user SET location = null WHERE email=?"),
	UPDATE_LOC("UPDATE user SET location=? WHERE email=?"),
	NEW_USER("INSERT INTO user VALUES(?,?,?)");
	
	public String getQuery() {
		return this.query;
	}
	
	String query;
	
	private UserEnum(String query) {
		this.query = query;
	}
}
