package fr.univavignon.pokedex.api;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IPokemonFactoryTest {

    private IPokemonFactory pokemonFactory;

    @BeforeEach
    void setUp() {
        pokemonFactory = mock(IPokemonFactory.class);

        // Configuration des mocks pour deux Pokémons
        when(pokemonFactory.createPokemon(0, 613, 64, 4000, 4))
                .thenReturn(new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56.0));
        when(pokemonFactory.createPokemon(133, 2729, 202, 5000, 4))
                .thenReturn(new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100.0));
    }

    @Test
    void testCreatePokemon_ValidData() {
        Pokemon bulbizarre = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);
        assertNotNull(bulbizarre);
        assertEquals(0, bulbizarre.getIndex());
        assertEquals("Bulbizarre", bulbizarre.getName());
        assertEquals(126, bulbizarre.getAttack());
        assertEquals(613, bulbizarre.getCp());

        Pokemon aquali = pokemonFactory.createPokemon(133, 2729, 202, 5000, 4);
        assertNotNull(aquali);
        assertEquals(133, aquali.getIndex());
        assertEquals("Aquali", aquali.getName());
        assertEquals(2729, aquali.getCp());
    }
}
