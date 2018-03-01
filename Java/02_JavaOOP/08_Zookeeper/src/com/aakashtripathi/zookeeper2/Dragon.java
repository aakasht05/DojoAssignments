package com.aakashtripathi.zookeeper2;

public class Dragon extends Mammal {

	
	public Dragon() {
		energyLevel = 300;
	}
	
	public void fly() {
		this.energyLevel -= 50;
		System.out.println("The dragon is flying");
	}
	
	public void eatHumans() {
		this.energyLevel += 25;
		System.out.println("The dragon is eating");
	}
	
	public void attackTown() {
		this.energyLevel -= 100;
		System.out.println("The dragon is destroying the town");
	}
	
}
