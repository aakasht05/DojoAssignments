package com.aakashtripathi.objectmaster2;

public class Wizard extends Human {
	public Wizard() {
		health = 50;
		intelligence = 8;
	}

	public void heal(Human human) {
		human.health += intelligence;
	}

	public void fireball(Human human) {
		human.health -= (intelligence * 3);
	}
}
