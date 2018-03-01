package com.aakashtripathi.pokemon;

public class Pokedex extends PokemonAbstract {

	public void attackPokemon(Pokemon pokemon) {
		pokemon.health -= 10;

	}

	public Pokemon pokemonInfo(Pokemon pokemon) {
		return pokemon;

	}

}
