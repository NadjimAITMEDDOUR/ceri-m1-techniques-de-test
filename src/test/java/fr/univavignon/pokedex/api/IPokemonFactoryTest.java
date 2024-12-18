package fr.univavignon.pokedex.api;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IPokemonFactoryTest {

    private IPokemonFactory pokemonFactory;

    @BeforeEach
    void setUp() {
        // Utilisation de la classe réelle RocketPokemonFactory
        pokemonFactory = new RocketPokemonFactory();
    }


    @Test
    void testCreatePokemon_ValidData() {
        // Test avec un index mappé
        Pokemon mappedPokemon = pokemonFactory.createPokemon(1, 613, 64, 4000, 4);
        assertNotNull(mappedPokemon);
        assertEquals(1, mappedPokemon.getIndex());
        assertEquals("Bulbasaur", mappedPokemon.getName()); // Correspond à l'index 1 mappé dans RocketPokemonFactory
        assertTrue(mappedPokemon.getAttack() >= 0 && mappedPokemon.getAttack() <= 100); // Vérifie les plages des stats générées
        assertTrue(mappedPokemon.getDefense() >= 0 && mappedPokemon.getDefense() <= 100);
        assertTrue(mappedPokemon.getStamina() >= 0 && mappedPokemon.getStamina() <= 100);
        assertEquals(613, mappedPokemon.getCp());
        assertEquals(64, mappedPokemon.getHp());
        assertEquals(4000, mappedPokemon.getDust());
        assertEquals(4, mappedPokemon.getCandy());

        // Test avec un index non mappé
        Pokemon unmappedPokemon = pokemonFactory.createPokemon(133, 2729, 202, 5000, 4);
        assertNotNull(unmappedPokemon);
        assertEquals(133, unmappedPokemon.getIndex());
        assertEquals("MISSINGNO", unmappedPokemon.getName()); // Nom par défaut pour un index non mappé
        assertTrue(unmappedPokemon.getAttack() >= 0 && unmappedPokemon.getAttack() <= 100); // Vérifie les plages des stats générées
        assertTrue(unmappedPokemon.getDefense() >= 0 && unmappedPokemon.getDefense() <= 100);
        assertTrue(unmappedPokemon.getStamina() >= 0 && unmappedPokemon.getStamina() <= 100);
        assertEquals(2729, unmappedPokemon.getCp());
        assertEquals(202, unmappedPokemon.getHp());
        assertEquals(5000, unmappedPokemon.getDust());
        assertEquals(4, unmappedPokemon.getCandy());
    }

    @Test
    void testCreatePokemon_InvalidData() {
        // Test avec un index invalide (négatif)
        Pokemon invalidPokemon = pokemonFactory.createPokemon(-1, -100, -50, -4000, -1);
        assertNotNull(invalidPokemon);
        assertEquals(-1, invalidPokemon.getIndex());
        assertEquals("Ash's Pikachu", invalidPokemon.getName()); // Nom par défaut pour un index négatif
        assertEquals(1000, invalidPokemon.getAttack()); // Stats fixes pour un index négatif
        assertEquals(1000, invalidPokemon.getDefense());
        assertEquals(1000, invalidPokemon.getStamina());
        assertEquals(-100, invalidPokemon.getCp());
        assertEquals(-50, invalidPokemon.getHp());
        assertEquals(-4000, invalidPokemon.getDust());
        assertEquals(-1, invalidPokemon.getCandy());
    }
}
