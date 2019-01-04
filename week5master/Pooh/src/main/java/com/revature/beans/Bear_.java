package com.revature.beans;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Bear.class)
public class Bear_ {
	public static volatile SingularAttribute<Bear, Integer> bearId;
	public static volatile SetAttribute<Bear, Cave> cave;
	public static volatile SingularAttribute<Bear, HoneyPot> honeyPot;
	public static volatile SetAttribute<Bear, Bear> bearCubs;
	public static volatile SingularAttribute<Bear, String> breed;
	public static volatile SingularAttribute<Bear, String> bearColor;
	public static volatile SingularAttribute<Bear, Double> weight;
	public static volatile SingularAttribute<Bear, Double> height;
}
