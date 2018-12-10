package com.revature.beans;

public class Address {
	private Integer id;
	private String lineone;
	private String linetwo;
	private String city;
	private String state;
	private String zip;
	public Address() {
		super();
	}
	public Address(Integer id) {
		super();
		this.id=id;
	}
	public Address(Integer id, String lineone, String linetwo, String city, String state, String zip) {
		super();
		this.id = id;
		this.lineone = lineone;
		this.linetwo = linetwo;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLineone() {
		return lineone;
	}
	public void setLineone(String lineone) {
		this.lineone = lineone;
	}
	public String getLinetwo() {
		return linetwo;
	}
	public void setLinetwo(String linetwo) {
		this.linetwo = linetwo;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lineone == null) ? 0 : lineone.hashCode());
		result = prime * result + ((linetwo == null) ? 0 : linetwo.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((zip == null) ? 0 : zip.hashCode());
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
		Address other = (Address) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lineone == null) {
			if (other.lineone != null)
				return false;
		} else if (!lineone.equals(other.lineone))
			return false;
		if (linetwo == null) {
			if (other.linetwo != null)
				return false;
		} else if (!linetwo.equals(other.linetwo))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (zip == null) {
			if (other.zip != null)
				return false;
		} else if (!zip.equals(other.zip))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", lineone=" + lineone + ", linetwo=" + linetwo + ", city=" + city + ", state="
				+ state + ", zip=" + zip + "]";
	}
}
