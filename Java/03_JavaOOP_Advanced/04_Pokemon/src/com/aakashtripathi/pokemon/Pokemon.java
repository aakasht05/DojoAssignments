package com.aakashtripathi.pokemon;

public class Pokemon {
	String name;
	String type;
	int health;
	static int count = 0;

	public Pokemon(String name, int health, String type) {
		this.name = name;
		this.type = type;
		this.health = health;
		count++;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}
}
