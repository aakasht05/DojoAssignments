package com.aakashtripathi.objectmaster2;

public class Human {
	int strength = 3;
	int stealth = 3;
	int intelligence = 3;
	int health;

	public Human() {
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
		human.health -= this.strength;
	}
}
