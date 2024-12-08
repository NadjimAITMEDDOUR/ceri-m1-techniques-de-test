package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PokedexFactoryTest {

    private PokedexFactory pokedexFactory;
    private PokemonMetadataProvider metadataProvider;
    private PokemonFactory pokemonFactory;

    @BeforeEach
    void setUp() {
        pokedexFactory = new PokedexFactory();
        metadataProvider = new PokemonMetadataProvider();
        pokemonFactory = new PokemonFactory();
    }

    @Test
    void testCreatePokedex_ValidArguments() {
        IPokedex pokedex = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);
        assertNotNull(pokedex);
        assertEquals(0, pokedex.size());
    }

    @Test
    void testCreatePokedex_NullMetadataProvider() {
        assertThrows(NullPointerException.class, () -> pokedexFactory.createPokedex(null, pokemonFactory));
    }

    @Test
    void testCreatePokedex_NullPokemonFactory() {
        assertThrows(NullPointerException.class, () -> pokedexFactory.createPokedex(metadataProvider, null));
    }

    @Test
    void testCreatePokedex_AddPokemon() {
        IPokedex pokedex = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);
        Pokemon pokemon = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);
        int index = pokedex.addPokemon(pokemon);

        assertEquals(0, index);
        assertEquals(1, pokedex.size());
    }
}
