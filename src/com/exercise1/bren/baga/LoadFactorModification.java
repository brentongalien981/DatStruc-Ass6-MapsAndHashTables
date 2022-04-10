package com.exercise1.bren.baga;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import coursepackage.Entry;

public class LoadFactorModification {

	// 300726788 - Bren Baga
	public static void main(String[] args) {

		System.out.println("Exercise1: Modifying Max Load Factor.");

		// Create a map with loadFactor of 0.1.
		demoLoadFactor(5000000, 0.05);
		
		System.out.println("-----------------------------------------------------------------");

		// Create a map with loadFactor of 0.9.
		demoLoadFactor(5000000, 0.99);

		
		// TODO: When and how is ChainHashMap better than ProbeHashMap?
		// ChainHashMap is better in these regard.
		// 1) Less code-complexity: no need for sentinel, lines of codes add up (say n = billions)
		// 2) No clustering of data: more efficient because generally width has more data than depth (but still depends on load-factor)
	}
	
	
	
	public static void demoLoadFactor(int capacity, double loadFactor) {
		
		System.out.println();
				

		// Set map and its load-factor for writing data.
		ChainHashMap<Integer, Integer> myMap1 = new ChainHashMap<>(capacity);
		myMap1.setMaxLoadFactor(loadFactor);
		
		
		// Vars for analytics.
		long startTime = System.currentTimeMillis();
		Random rand = new Random();	
		ArrayList<Integer> usedKeys = new ArrayList<>();

		for (int i = 0; i < capacity; i++) {

			int randomInt = rand.nextInt();
			usedKeys.add(randomInt);

			myMap1.put(randomInt, randomInt);
		}

		long endTime = System.currentTimeMillis();
		long timeTook = endTime - startTime;

		
		// Output for writing data.
		System.out.println("######### Writing data with loadFactor: " + myMap1.maxLoadFactor + " #########");
		System.out.println("loadFactor: " + myMap1.maxLoadFactor);
		System.out.println("initial capacity: " + getValueWithComma(capacity));
		System.out.println("final capacity: " + getValueWithComma(myMap1.capacity));
		System.out.println("size: " + getValueWithComma(myMap1.size()));		
		System.out.println("Time took: " + timeTook + " ms");
		
		
		
		// Demo for reading data from map with same loadFactor.
		startTime = System.currentTimeMillis();
		
		for (Integer theKey : usedKeys) {
			myMap1.get(theKey);
		}
		
		endTime = System.currentTimeMillis();
		timeTook = endTime - startTime;
		
		
		// Output for reading data.
		System.out.println("\n######### Reading data with loadFactor: " + myMap1.maxLoadFactor + " #########");
		System.out.println("loadFactor: " + myMap1.maxLoadFactor);
		System.out.println("Time took: " + timeTook + " ms");
		System.out.println("\n\n\n");
		
		
	}



	private static String getValueWithComma(int capacity) {
		
		return NumberFormat.getIntegerInstance().format(capacity);

	}

}
