package com.aakashtripathi.objectmaster2;

public class Samurai extends Human{
	static int count = 0;
	public Samurai() {
		health = 200;
		count ++;
	}
	
	public void deathBlow(Human human) {
		human.health = 0;
		health /= 2;
	}
	
	public void meditate() {
		health += (health/2);
	}
	
	public void howMany() {
		System.out.println("There are " + count + " samurai.");
	}
}
