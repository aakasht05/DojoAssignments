package com.aakashtripathi.pokemon;

public abstract class PokemonAbstract implements PokemonInterface {
	public Pokemon createPokemon(String name, int health, String type) {
		return new Pokemon(name, health, type);
	}

	public void attackPokemon(Pokemon pokemon) {
		pokemon.setHealth(pokemon.getHealth() - 10);
	}
}
