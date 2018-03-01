package com.aakashtripathi.pokemon;

public interface PokemonInterface {

	Pokemon createPokemon(String name, int health, String type);

	void attackPokemon(Pokemon pokemon);

	Pokemon pokemonInfo(Pokemon pokemon);
}
