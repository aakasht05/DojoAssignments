package com.tony.pets.models;

public class Cat extends Animal{
	public Cat(){}
	
	public Cat(String name,String breed,double weight){
		this.setName(name);
		this.setBreed(breed);
		this.setWeight(weight);
	}
	
	@Override
	public String showAffection(){
		return "Your "+this.getBreed()+" cat, "+this.getName()+" looked at you with affection.";
	}
}
