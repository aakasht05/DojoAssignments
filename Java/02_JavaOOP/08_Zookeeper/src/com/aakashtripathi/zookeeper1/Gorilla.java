package com.aakashtripathi.zookeeper1;

public class Gorilla extends Mammal {

	public void throwSomething() {
		this.energyLevel -= 5;
		System.out.println("The gorilla has thrown something");
	}

	public void eatBananas() {
		this.energyLevel += 10;
		System.out.println("The gorilla ate a banana");
	}

	public void climb() {
		this.energyLevel -= 10;
		System.out.println("The gorilla climbed a tree");
	}
}
