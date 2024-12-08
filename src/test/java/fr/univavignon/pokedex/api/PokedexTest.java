package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PokedexTest {

    private Pokedex pokedex;
    private PokemonMetadataProvider metadataProvider;
    private PokemonFactory pokemonFactory;

    @BeforeEach
    void setUp() {
        metadataProvider = new PokemonMetadataProvider();
        pokemonFactory = new PokemonFactory();
        pokedex = new Pokedex(metadataProvider, pokemonFactory);
    }

    @Test
    void testAddPokemon() {
        Pokemon pokemon = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);
        int index = pokedex.addPokemon(pokemon);
        assertEquals(0, index);
        assertEquals(1, pokedex.size());
    }

    @Test
    void testGetPokemon_ValidId() throws PokedexException {
        Pokemon pokemon = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);
        pokedex.addPokemon(pokemon);
        Pokemon retrievedPokemon = pokedex.getPokemon(0);
        assertEquals(pokemon, retrievedPokemon);
    }

    @Test
    void testGetPokemon_InvalidId() {
        assertThrows(PokedexException.class, () -> pokedex.getPokemon(999));
    }

    @Test
    void testGetPokemons_Unsorted() {
        pokedex.addPokemon(pokemonFactory.createPokemon(0, 613, 64, 4000, 4));
        pokedex.addPokemon(pokemonFactory.createPokemon(133, 2729, 202, 5000, 4));
        List<Pokemon> pokemons = pokedex.getPokemons();
        assertEquals(2, pokemons.size());
    }

    @Test
    void testGetPokemons_Sorted() {
        pokedex.addPokemon(pokemonFactory.createPokemon(0, 613, 64, 4000, 4));
        pokedex.addPokemon(pokemonFactory.createPokemon(133, 2729, 202, 5000, 4));
        List<Pokemon> pokemons = pokedex.getPokemons(Comparator.comparing(Pokemon::getCp));
        assertEquals(613, pokemons.get(0).getCp());
        assertEquals(2729, pokemons.get(1).getCp());
    }
}
