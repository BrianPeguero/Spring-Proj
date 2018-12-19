package enums;

public enum NoParkingZoneEnum {
	GET_NO_PARKINNG_ZONE("SELECT * FROM no_parking_zones");
	
	public String getQuery() {
		return this.query;
	}
	
	private String query;
	
	private NoParkingZoneEnum(String q) {
		this.query = q;
	}
	
}
