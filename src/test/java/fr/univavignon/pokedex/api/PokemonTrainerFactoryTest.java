package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PokemonTrainerFactoryTest {

    private PokemonTrainerFactory pokemonTrainerFactory;
    private PokedexFactory pokedexFactory;

    @BeforeEach
    void setUp() {
        pokemonTrainerFactory = new PokemonTrainerFactory();
        pokedexFactory = new PokedexFactory();
    }

    @Test
    void testCreateTrainer_ValidArguments() {
        PokemonTrainer trainer = pokemonTrainerFactory.createTrainer("Ash", Team.VALOR, pokedexFactory);

        assertNotNull(trainer);
        assertEquals("Ash", trainer.getName());
        assertEquals(Team.VALOR, trainer.getTeam());
        assertNotNull(trainer.getPokedex());
        assertEquals(0, trainer.getPokedex().size());
    }

    @Test
    void testCreateTrainer_NullName() {
        assertThrows(IllegalArgumentException.class, () ->
                pokemonTrainerFactory.createTrainer(null, Team.MYSTIC, pokedexFactory));
    }

    @Test
    void testCreateTrainer_EmptyName() {
        assertThrows(IllegalArgumentException.class, () ->
                pokemonTrainerFactory.createTrainer("", Team.MYSTIC, pokedexFactory));
    }

    @Test
    void testCreateTrainer_NullTeam() {
        assertThrows(NullPointerException.class, () ->
                pokemonTrainerFactory.createTrainer("Brock", null, pokedexFactory));
    }

    @Test
    void testCreateTrainer_NullPokedexFactory() {
        assertThrows(NullPointerException.class, () ->
                pokemonTrainerFactory.createTrainer("Misty", Team.INSTINCT, null));
    }
}
