package com.aakashtripathi.zookeeper1;

public class GorillaTest {

	public static void main(String[] args) {
		Gorilla g1 = new Gorilla();
		Gorilla g2 = new Gorilla();
		g1.throwSomething();
		g1.throwSomething();
		g1.throwSomething();
		g1.displayEnergy();
		g1.eatBananas();
		g1.eatBananas();
		g1.displayEnergy();
		g1.climb();
		g1.displayEnergy();
		g2.displayEnergy();

	}

}
