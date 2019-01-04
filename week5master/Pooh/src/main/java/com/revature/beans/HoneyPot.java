package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@NamedQueries({
	@NamedQuery(name="getAllHoneypots", query="FROM HoneyPot"),
	@NamedQuery(name="getAllHoneypotsWithHoney", query="from HoneyPot where HoneyAmount =:amount")
})

@Entity // Tells Hibernate that this class should be mapped to the database
@Table(name="honey_pot") // Tells hibernate what table this class should be mapped to
public class HoneyPot {
	@Id
	@Column(name="honeypot_id")
	@SequenceGenerator(name="gen", sequenceName="honeypotid_seq", allocationSize=1)
	@GeneratedValue(generator="gen", strategy=GenerationType.SEQUENCE)
	private int honeypotId;
	@Column
	private double volume;
	//@Column is implied for all fields.
	private double honeyAmount;
	public HoneyPot() {
		super();
	}
	public int getHoneypotId() {
		return honeypotId;
	}
	public void setHoneypotId(int honeypotId) {
		this.honeypotId = honeypotId;
	}
	public double getVolume() {
		return volume;
	}
	public void setVolume(double volume) {
		this.volume = volume;
	}
	public double getHoneyAmount() {
		return honeyAmount;
	}
	public void setHoneyAmount(double honeyAmount) {
		this.honeyAmount = honeyAmount;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(honeyAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + honeypotId;
		temp = Double.doubleToLongBits(volume);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		HoneyPot other = (HoneyPot) obj;
		if (Double.doubleToLongBits(honeyAmount) != Double.doubleToLongBits(other.honeyAmount))
			return false;
		if (honeypotId != other.honeypotId)
			return false;
		if (Double.doubleToLongBits(volume) != Double.doubleToLongBits(other.volume))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "HoneyPot [honeypotId=" + honeypotId + ", volume=" + volume + ", honeyAmount=" + honeyAmount + "]";
	}
	
}
