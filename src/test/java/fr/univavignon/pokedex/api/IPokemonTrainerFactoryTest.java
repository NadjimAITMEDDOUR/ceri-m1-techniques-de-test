package fr.univavignon.pokedex.api;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IPokemonTrainerFactoryTest {

    private IPokemonTrainerFactory pokemonTrainerFactory;
    private IPokedexFactory pokedexFactory;
    private IPokedex pokedex;

    @BeforeEach
    void setUp() {
        // Mock des interfaces nécessaires
        pokemonTrainerFactory = mock(IPokemonTrainerFactory.class);
        pokedexFactory = mock(IPokedexFactory.class);
        pokedex = mock(IPokedex.class);

        // Configuration des mocks
        when(pokedexFactory.createPokedex(any(), any())).thenReturn(pokedex);
        when(pokemonTrainerFactory.createTrainer("Ash", Team.VALOR, pokedexFactory))
                .thenReturn(new PokemonTrainer("Ash", Team.VALOR, pokedex));
        when(pokemonTrainerFactory.createTrainer("Misty", Team.MYSTIC, pokedexFactory))
                .thenReturn(new PokemonTrainer("Misty", Team.MYSTIC, pokedex));

        // Configuration pour lever une exception si l'équipe est null
        doThrow(new NullPointerException("Team cannot be null"))
                .when(pokemonTrainerFactory)
                .createTrainer(anyString(), isNull(), any(IPokedexFactory.class));
        doThrow(new IllegalArgumentException("Name cannot be null or empty"))
                .when(pokemonTrainerFactory)
                .createTrainer(isNull(), any(Team.class), any(IPokedexFactory.class));

        doThrow(new IllegalArgumentException("Name cannot be null or empty"))
                .when(pokemonTrainerFactory)
                .createTrainer(eq(""), any(Team.class), any(IPokedexFactory.class));
    }

    @Test
    void testCreateTrainer_ValidTrainer() {
        PokemonTrainer ash = pokemonTrainerFactory.createTrainer("Ash", Team.VALOR, pokedexFactory);

        assertNotNull(ash);
        assertEquals("Ash", ash.getName());
        assertEquals(Team.VALOR, ash.getTeam());
        assertNotNull(ash.getPokedex());
        assertEquals(pokedex, ash.getPokedex());
    }

    @Test
    void testCreateTrainer_AnotherTrainer() {
        PokemonTrainer misty = pokemonTrainerFactory.createTrainer("Misty", Team.MYSTIC, pokedexFactory);

        assertNotNull(misty);
        assertEquals("Misty", misty.getName());
        assertEquals(Team.MYSTIC, misty.getTeam());
        assertNotNull(misty.getPokedex());
        assertEquals(pokedex, misty.getPokedex());
    }

    @Test
    void testCreateTrainer_NullTeam() {
        // Test avec une équipe null
        assertThrows(NullPointerException.class, () -> {
            pokemonTrainerFactory.createTrainer("Brock", null, pokedexFactory);
        });
    }

    @Test
    void testCreateTrainer_NullName() {
        assertThrows(IllegalArgumentException.class, () -> {
            pokemonTrainerFactory.createTrainer(null, Team.INSTINCT, pokedexFactory);
        });
    }

    @Test
    void testCreateTrainer_EmptyName() {
        assertThrows(IllegalArgumentException.class, () -> {
            pokemonTrainerFactory.createTrainer("", Team.INSTINCT, pokedexFactory);
        });
    }

}
