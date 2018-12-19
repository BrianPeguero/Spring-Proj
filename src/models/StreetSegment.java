package models;

public class StreetSegment {
	
	private int ID;
	private int streetID;
	private double length;
	private String geoCords;
	
	public StreetSegment(int iD, int streetID, double length, String geoCords) {
		this.ID = iD;
		this.streetID = streetID;
		this.length = length;
		this.geoCords = geoCords;
	}

	public int getID() {
		return ID;
	}

	public int getStreetID() {
		return streetID;
	}

	public double getLength() {
		return length;
	}

	public String getGeoCords() {
		return geoCords;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public void setStreetID(int streetID) {
		this.streetID = streetID;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public void setGeoCords(String geoCords) {
		this.geoCords = geoCords;
	}

	@Override
	public String toString() {
		return "StreetSegments [ID=" + ID + ", streetID=" + streetID + ", length=" + length + ", geoCords=" + geoCords
				+ "]";
	}
	
}
