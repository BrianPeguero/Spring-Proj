package models;

public class Vehical {
	
	private int type;
	private String model;
	private String company;
	private int year;
	private int length;
	
	public Vehical(int type, String model, String company, int year, int length) {
		this.type = type;
		this.model = model;
		this.company = company;
		this.year = year;
		this.length = length;
	}

	public int getType() {
		return type;
	}

	public String getModel() {
		return model;
	}

	public String getCompany() {
		return company;
	}

	public int getYear() {
		return year;
	}

	public int getLength() {
		return length;
	}

	public void setType(int type) {
		this.type = type;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void setLength(int length) {
		this.length = length;
	}

	@Override
	public String toString() {
		return "Vehical [type=" + type + ", model=" + model + ", company=" + company + ", year=" + year + ", length="
				+ length + "]";
	}

}
