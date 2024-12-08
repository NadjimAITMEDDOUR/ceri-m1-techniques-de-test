package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PokemonTrainerFactoryTest {

    private PokemonTrainerFactory trainerFactory;
    private PokedexFactory pokedexFactory;

    @BeforeEach
    void setUp() {
        trainerFactory = new PokemonTrainerFactory();
        pokedexFactory = new PokedexFactory();
    }

    @Test
    void testCreateTrainer_ValidData() {
        PokemonTrainer trainer = trainerFactory.createTrainer("Ash", Team.VALOR, pokedexFactory);
        assertNotNull(trainer);
        assertEquals("Ash", trainer.getName());
        assertEquals(Team.VALOR, trainer.getTeam());
        assertNotNull(trainer.getPokedex());
    }

    @Test
    void testCreateTrainer_NullName() {
        assertThrows(IllegalArgumentException.class, () -> trainerFactory.createTrainer(null, Team.VALOR, pokedexFactory));
    }

    @Test
    void testCreateTrainer_NullTeam() {
        assertThrows(NullPointerException.class, () -> trainerFactory.createTrainer("Ash", null, pokedexFactory));
    }
}
