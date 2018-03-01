package com.aakashtripathi.zookeeper2;

public class DragonTest {

	public static void main(String[] args) {
		Dragon d1 = new Dragon();
		Dragon d2 = new Dragon();
		
		d1.attackTown();
		d1.attackTown();
		d1.attackTown();
		d1.displayEnergy();
		d1.eatHumans();
		d1.eatHumans();
		d1.displayEnergy();
		d1.fly();
		d1.fly();
		d1.displayEnergy();
		d2.displayEnergy();
	}

}
