package com.exercise2.bren.baga;

import coursepackage.Entry;
import coursepackage.SortedTableMap;

public class ContainsKeyImplementation {

	// 300726788 - Bren Baga
	public static void main(String[] args) {

		System.out.println("Exercise2: Implementing containsKey() method.\n");

		SortedTableMap<Integer, Integer> myMap = new SortedTableMap<>();
		myMap.put(9, null);
		myMap.put(8, 8);
		myMap.put(7, 7);
		myMap.put(6, 6);
		myMap.put(0, null);
		myMap.put(5, 5);

		System.out.println("myMap values:");
		for (Entry<Integer, Integer> e : myMap.entrySet()) {
			System.out.println(e.getKey() + " ==> " + e.getValue());			
		}
		
		System.out.println("");
		
		System.out.println("myMap.findIndex(KEY) ==> INDEX");
		System.out.println("myMap.findIndex(-9) ==> " + myMap.findIndex(-9));
		System.out.println("myMap.findIndex(-1) ==> " + myMap.findIndex(-1));
		System.out.println("myMap.findIndex(0) ==> " + myMap.findIndex(0));
		System.out.println("myMap.findIndex(5) ==> " + myMap.findIndex(5));
		System.out.println("myMap.findIndex(6) ==> " + myMap.findIndex(6));
		System.out.println("myMap.findIndex(7) ==> " + myMap.findIndex(7));
		System.out.println("myMap.findIndex(8) ==> " + myMap.findIndex(8));
		System.out.println("myMap.findIndex(9) ==> " + myMap.findIndex(9));
		System.out.println("myMap.findIndex(10) ==> " + myMap.findIndex(10));
		System.out.println("myMap.findIndex(33) ==> " + myMap.findIndex(33));
		System.out.println("myMap.findIndex(999) ==> " + myMap.findIndex(999));		
		System.out.println("");
		
		System.out.println("myMap.containKey(-9) ==> " + myMap.containKey(-9));
		System.out.println("myMap.containKey(0) ==> " + myMap.containKey(0));
		System.out.println("myMap.containKey(7) ==> " + myMap.containKey(7));
		System.out.println("myMap.containKey(9) ==> " + myMap.containKey(9));
		System.out.println("myMap.containKey(777) ==> " + myMap.containKey(777));
		

	}

}
