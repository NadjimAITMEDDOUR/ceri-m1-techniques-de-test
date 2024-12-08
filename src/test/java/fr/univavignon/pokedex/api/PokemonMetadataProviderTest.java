package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PokemonMetadataProviderTest {

    private PokemonMetadataProvider metadataProvider;

    @BeforeEach
    void setUp() {
        metadataProvider = new PokemonMetadataProvider();
    }

    @Test
    void testGetPokemonMetadata_ValidIndex() throws PokedexException {
        PokemonMetadata metadata = metadataProvider.getPokemonMetadata(0);
        assertNotNull(metadata);
        assertEquals(0, metadata.getIndex());
        assertEquals("Bulbizarre", metadata.getName());
        assertEquals(126, metadata.getAttack());
    }

    @Test
    void testGetPokemonMetadata_InvalidIndex() {
        assertThrows(PokedexException.class, () -> metadataProvider.getPokemonMetadata(999));
    }
}
