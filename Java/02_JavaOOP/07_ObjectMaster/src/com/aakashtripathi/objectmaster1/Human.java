package com.aakashtripathi.objectmaster1;

public class Human {
	int strength;
	int stealth;
	int intelligence;
	int health;

	public Human() {
		strength = 3;
		stealth = 3;
		intelligence = 3;
		health = 100;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrenth(int strength) {
		this.strength = strength;
	}

	public int getStealth() {
		return stealth;
	}

	public void setStealth(int stealth) {
		this.stealth = stealth;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}
	
	public void attack(Human human) {
		human.health = human.health - this.strength;
	}
}
