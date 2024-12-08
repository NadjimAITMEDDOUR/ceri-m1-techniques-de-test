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
    void testSize_EmptyPokedex() {
        assertEquals(0, pokedex.size());
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
        assertThrows(PokedexException.class, () -> pokedex.getPokemon(1));
    }

    @Test
    void testGetPokemons_UnmodifiableList() {
        Pokemon pokemon = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);
        pokedex.addPokemon(pokemon);

        List<Pokemon> pokemons = pokedex.getPokemons();
        assertEquals(1, pokemons.size());
        assertThrows(UnsupportedOperationException.class, () -> pokemons.add(pokemon));
    }

    @Test
    void testGetPokemons_Sorted() {
        Pokemon pokemon1 = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);
        Pokemon pokemon2 = pokemonFactory.createPokemon(133, 2729, 202, 5000, 4);

        pokedex.addPokemon(pokemon1);
        pokedex.addPokemon(pokemon2);

        List<Pokemon> sortedPokemons = pokedex.getPokemons(Comparator.comparingInt(Pokemon::getCp));
        assertEquals(pokemon1, sortedPokemons.get(0));
        assertEquals(pokemon2, sortedPokemons.get(1));
    }

}
