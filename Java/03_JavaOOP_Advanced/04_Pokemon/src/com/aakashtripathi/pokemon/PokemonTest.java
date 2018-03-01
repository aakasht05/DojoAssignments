package com.aakashtripathi.pokemon;

public class PokemonTest {

	public static void main(String[] args) {
		Pokedex pokedex = new Pokedex();
		Pokemon charmander = pokedex.createPokemon("charmander", 125, "fire");
		Pokemon bulbasaur = pokedex.createPokemon("bulbasaur", 110, "grass");
		Pokemon squirtle = pokedex.createPokemon("squirtle", 120, "water");
		
		
		System.out.println(squirtle.getHealth());
		pokedex.attackPokemon(squirtle);
		System.out.println(squirtle.getHealth());
		System.out.println("There are " + Pokemon.count + " pokemon in the pokedex");
	}

}
