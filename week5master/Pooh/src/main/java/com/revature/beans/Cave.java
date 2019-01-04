package com.revature.beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Cave_id")
public class Cave {
	@Id
	@Column(name="cave_id_id")
	@SequenceGenerator(name="bob", sequenceName="caveid_seq",allocationSize=1)
	@GeneratedValue(generator="bob", strategy=GenerationType.SEQUENCE)
	private int caveId;
	@OneToMany(fetch=FetchType.LAZY, mappedBy="cave")
	private Set<Bear> residents = new HashSet<Bear>();
	@Column(name="SQ_Footage")
	private double squareFootage;
	private String caveType;
	public Cave() {
		super();
	}
	public int getCaveId() {
		return caveId;
	}
	public void setCaveId(int caveId) {
		this.caveId = caveId;
	}
	public Set<Bear> getResidents() {
		return residents;
	}
	public void setResidents(Set<Bear> residents) {
		this.residents = residents;
	}
	public double getSquareFootage() {
		return squareFootage;
	}
	public void setSquareFootage(double squareFootage) {
		this.squareFootage = squareFootage;
	}
	public String getCaveType() {
		return caveType;
	}
	public void setCaveType(String caveType) {
		this.caveType = caveType;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + caveId;
		result = prime * result + ((caveType == null) ? 0 : caveType.hashCode());
		long temp;
		temp = Double.doubleToLongBits(squareFootage);
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
		Cave other = (Cave) obj;
		if (caveId != other.caveId)
			return false;
		if (caveType == null) {
			if (other.caveType != null)
				return false;
		} else if (!caveType.equals(other.caveType))
			return false;
		if (Double.doubleToLongBits(squareFootage) != Double.doubleToLongBits(other.squareFootage))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Cave [caveId=" +caveId+ ", squareFootage=" + squareFootage
				+ ", caveType=" + caveType + "]";
	}
}
