package com.aakashtripathi.objectmaster1;

public class HumanTest {

	public static void main(String[] args) {
		Human h1 = new Human();
		Human h2 = new Human();
		
		h1.attack(h2);
		h1.attack(h2);
		h1.attack(h2);
		h1.attack(h2);
		System.out.println(h1.getHealth());
		System.out.println(h2.getHealth());
		h2.attack(h1);
		System.out.println(h1.getHealth());
		System.out.println(h2.getHealth());
	}
}
