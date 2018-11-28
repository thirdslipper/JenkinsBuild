package com.revature.array;

import java.util.Arrays;

public class ArrayExample {
	
	public static void main(String[] args) {
		int[] arr = new int[7];
		int[] arr1 = {1,1,1,1};
		
		Integer[] arr2 = new Integer[5];
		
		for(int i = 0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
		String[] s = new String[7];
		System.out.println(s[1]);
		System.out.println(s);
		System.out.println(Arrays.toString(s));
		Arrays.fill(arr, 7);
		System.out.println(Arrays.toString(arr));
		
		int[] arr3 = {5,6,3,7,2,5,6,9};
		System.out.println(Arrays.toString(arr3));
		Arrays.sort(arr3);
		System.out.println(Arrays.toString(arr3));
	}
}
