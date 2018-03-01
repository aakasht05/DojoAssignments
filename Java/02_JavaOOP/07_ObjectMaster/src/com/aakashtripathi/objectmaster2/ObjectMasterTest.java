package com.aakashtripathi.objectmaster2;

public class ObjectMasterTest {

	public static void main(String[] args) {
		Human h1 = new Human();
		Wizard w1 = new Wizard();
		Ninja n1 = new Ninja();
		Samurai s1 = new Samurai();
		Samurai s2 = new Samurai();
		
		System.out.println(h1.getHealth());
		System.out.println(w1.getHealth());
		System.out.println(n1.getHealth());
		System.out.println(s1.getHealth());
		
		s1.deathBlow(h1);
		System.out.println(h1.getHealth());
		System.out.println(s1.getHealth());
		s1.meditate();
		System.out.println(s1.getHealth());
		s2.howMany();
		

	}

}
