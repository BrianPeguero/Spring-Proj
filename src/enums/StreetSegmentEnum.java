package enums;

public enum StreetSegmentEnum {
	
	GET_ALL_STREETS("SELECT * FROM street_segments");
	
	public String getQuery() {
		return this.query;
	}
	
	private String query;
	
	private StreetSegmentEnum(String q){
		this.query = q;
	}
	
}
