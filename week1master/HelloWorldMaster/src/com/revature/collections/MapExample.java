package com.revature.collections;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

public class MapExample {
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "Derrek");
		System.out.println(map);
		map.put(2, "Keith");
		System.out.println(map);
		map.put(-5, "David");
		System.out.println(map);
		map.put(8, "David");
		System.out.println(map);
		map.put(8, "Colin");
		System.out.println(map);
		map.put(3, "David");
		System.out.println(map);
		System.out.println("TreeMap");
		Map<Integer, String> treeMap = new TreeMap<Integer, String>();
		treeMap.putAll(map);
		System.out.println(treeMap);
		
		// 3 ways to iterate over a map
		System.out.println();
		// Iterate over the keys
		for(Integer i : map.keySet()) {
			System.out.println(i+": "+map.get(i));
		}
		System.out.println();
		// Iterate over the entries
		for(Entry<Integer,String> e: map.entrySet()) {
			System.out.println(e);
		}
		System.out.println();
		// Iterate over just the values
		for(String n: map.values()) {
			System.out.println(n);
		}
		
		System.out.println(map.getClass().getName());
		System.out.println(map.values().getClass().getName());
		System.out.println("Is Values a collection? "+(map.values() instanceof Collection));
		System.out.println("Is Values a set? "+(map.values() instanceof Set));
		System.out.println("Is Values a queue? "+(map.values() instanceof Queue));
		System.out.println("Is Values a list? "+(map.values() instanceof List));
	}
}
