package com.revature.beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="bear")
public class Bear {
	@Id
	@Column(name="bear_id")
	@SequenceGenerator(name="stevebob", sequenceName="bearid_seq", allocationSize=1)
	@GeneratedValue(generator="stevebob", strategy=GenerationType.SEQUENCE)
	private int bearId;
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="cave_id")
	private Cave cave;
	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="honeypot_id")
	private HoneyPot honeyPot;
	@ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinTable(name="parent_cub",
		joinColumns=@JoinColumn(name="parent_id"),
		inverseJoinColumns=@JoinColumn(name="cub_id"))
	private Set<Bear> bearCubs=new HashSet<Bear>();
	@Column(name="bear_color")
	private String bearColor;
	private String breed;
	private double weight;
	private double height;
	public Bear() {
		super();
	}
	public int getBearId() {
		return bearId;
	}
	public void setBearId(int bearId) {
		this.bearId = bearId;
	}
	public Cave getCave() {
		return cave;
	}
	public void setCave(Cave cave) {
		this.cave = cave;
	}
	public HoneyPot getHoneyPot() {
		return honeyPot;
	}
	public void setHoneyPot(HoneyPot honeyPot) {
		this.honeyPot = honeyPot;
	}
	public Set<Bear> getBearCubs() {
		return bearCubs;
	}
	public void setBearCubs(Set<Bear> bearCubs) {
		this.bearCubs = bearCubs;
	}
	public String getBearColor() {
		return bearColor;
	}
	public void setBearColor(String bearColor) {
		this.bearColor = bearColor;
	}
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bearColor == null) ? 0 : bearColor.hashCode());
		result = prime * result + ((bearCubs == null) ? 0 : bearCubs.hashCode());
		result = prime * result + bearId;
		result = prime * result + ((breed == null) ? 0 : breed.hashCode());
		result = prime * result + ((cave == null) ? 0 : cave.hashCode());
		long temp;
		temp = Double.doubleToLongBits(height);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((honeyPot == null) ? 0 : honeyPot.hashCode());
		temp = Double.doubleToLongBits(weight);
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
		Bear other = (Bear) obj;
		if (bearColor == null) {
			if (other.bearColor != null)
				return false;
		} else if (!bearColor.equals(other.bearColor))
			return false;
		if (bearCubs == null) {
			if (other.bearCubs != null)
				return false;
		} else if (!bearCubs.equals(other.bearCubs))
			return false;
		if (bearId != other.bearId)
			return false;
		if (breed == null) {
			if (other.breed != null)
				return false;
		} else if (!breed.equals(other.breed))
			return false;
		if (cave == null) {
			if (other.cave != null)
				return false;
		} else if (!cave.equals(other.cave))
			return false;
		if (Double.doubleToLongBits(height) != Double.doubleToLongBits(other.height))
			return false;
		if (honeyPot == null) {
			if (other.honeyPot != null)
				return false;
		} else if (!honeyPot.equals(other.honeyPot))
			return false;
		if (Double.doubleToLongBits(weight) != Double.doubleToLongBits(other.weight))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Bear [bearId=" + bearId + ", cave=" + cave + ", honeyPot=" + honeyPot + ", bearCubs=" + bearCubs
				+ ", bearColor=" + bearColor + ", breed=" + breed + ", weight=" + weight + ", height=" + height + "]";
	}
}
