package com.tony.pets.models;

public abstract class Animal implements Pet{
	private String name;
	private String breed;
	private double weight;
	
	public Animal(){}

	public String getName(){return name;}
	public void setName(String name){this.name = name;}
	
	public String getBreed(){return breed;}
	public void setBreed(String breed){this.breed= breed;}
	
	public double getWeight(){return weight;}
	public void setWeight(double weight){this.weight= weight;}
}