package models;

public class NoParkingZone {
	
	private int Id;
	private int streetID;
	private int type;
	private String loc;
	private String time;
	
	public NoParkingZone(int id, int streetID, int type, String loc, String time) {
		this.Id = id;
		this.streetID = streetID;
		this.type = type;
		this.loc = loc;
		this.time = time;
	}

	public int getId() {
		return Id;
	}

	public int getStreetID() {
		return streetID;
	}

	public int getType() {
		return type;
	}

	public String getLoc() {
		return loc;
	}

	public String getTime() {
		return time;
	}

	public void setId(int id) {
		Id = id;
	}

	public void setStreetID(int streetID) {
		this.streetID = streetID;
	}

	public void setType(int type) {
		this.type = type;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "NoParkingZone [Id=" + Id + ", streetID=" + streetID + ", type=" + type + ", loc=" + loc + ", time="
				+ time + "]";
	}

}
