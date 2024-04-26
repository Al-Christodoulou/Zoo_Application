package com;

import java.io.Serializable;

public class Animal implements Serializable {
	// maxCode is used to increment the code int for
	// every object of type 'Animal' created
	static private int maxCode = 0;

	private final int code;
	private String name;
	private String animal_class;
	private float avgWeight;
	private float maxAge;

	public int getCode() { return code; }
	static public void updateMaxCode(int newMaxCode) { maxCode = newMaxCode; }

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public String getAnimalClass() { return animal_class; }
	public void setClass(String iclass) { this.animal_class = iclass; }

	public float getAvgWeight() { return avgWeight; }
	public void setAvgWeight(float avgWeight) { this.avgWeight = avgWeight;	}

	public float getMaxAge() { return maxAge; }
	public void setMaxAge(float maxAge) { this.maxAge = maxAge;	}

	public String toString() {
		return "Όνομα: " + name + " | " + "Κωδικός: " + code + " | " +
				"Ομοταξία: " + animal_class + " | " + "Μέσο βάρος: " + avgWeight + " κιλά | " +
				"Μέγιστος μέσος όρος ηλικίας: " + maxAge + " χρόνια";
	}

	public Animal(String name, String iclass, float avgWeight, float maxAge) {
		this.code = maxCode++;
		this.name = name;
		this.animal_class = iclass;
		this.avgWeight = avgWeight;
		this.maxAge = maxAge;
	}
}
