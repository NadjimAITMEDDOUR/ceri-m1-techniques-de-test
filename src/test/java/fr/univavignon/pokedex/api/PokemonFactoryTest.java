package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PokemonFactoryTest {

    private PokemonFactory pokemonFactory;

    @BeforeEach
    void setUp() {
        pokemonFactory = new PokemonFactory();
    }

    @Test
    void testCreatePokemon_ValidData() {
        Pokemon pokemon = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);
        assertNotNull(pokemon);
        assertEquals(0, pokemon.getIndex());
        assertEquals("Bulbizarre", pokemon.getName());
        assertEquals(613, pokemon.getCp());
        assertEquals(64, pokemon.getHp());
    }

    @Test
    void testCreatePokemon_InvalidIndex() {
        // Test avec un index inexistant
        assertThrows(IllegalArgumentException.class, () -> pokemonFactory.createPokemon(-1, 500, 50, 3000, 2));
    }
}
