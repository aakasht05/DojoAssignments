package com.aakashtripathi.objectmaster2;

public class Ninja extends Human {
	public Ninja() {
		stealth = 10;
	}

	public void steal(Human human) {
		human.health -= stealth;
		health += stealth;
	}

	public void runAway() {
		health -= 10;
	}
}
