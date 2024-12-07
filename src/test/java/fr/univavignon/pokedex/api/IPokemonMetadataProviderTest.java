package fr.univavignon.pokedex.api;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IPokemonMetadataProviderTest {

    private IPokemonMetadataProvider metadataProvider;

    @BeforeEach
    void setUp() throws PokedexException {
        metadataProvider = mock(IPokemonMetadataProvider.class);

        // Configuration des mocks pour deux Pokémons
        when(metadataProvider.getPokemonMetadata(0))
                .thenReturn(new PokemonMetadata(0, "Bulbizarre", 126, 126, 90));
        when(metadataProvider.getPokemonMetadata(133))
                .thenReturn(new PokemonMetadata(133, "Aquali", 186, 168, 260));
    }

    @Test
    void testGetPokemonMetadata_ValidIndex() throws PokedexException {
        PokemonMetadata bulbizarre = metadataProvider.getPokemonMetadata(0);
        assertNotNull(bulbizarre);
        assertEquals(0, bulbizarre.getIndex());
        assertEquals("Bulbizarre", bulbizarre.getName());
        assertEquals(126, bulbizarre.getAttack());
        assertEquals(126, bulbizarre.getDefense());
        assertEquals(90, bulbizarre.getStamina());

        PokemonMetadata aquali = metadataProvider.getPokemonMetadata(133);
        assertNotNull(aquali);
        assertEquals(133, aquali.getIndex());
        assertEquals("Aquali", aquali.getName());
        assertEquals(186, aquali.getAttack());
        assertEquals(168, aquali.getDefense());
        assertEquals(260, aquali.getStamina());
    }

    @Test
    void testGetPokemonMetadata_InvalidIndex() throws PokedexException {
        when(metadataProvider.getPokemonMetadata(999)).thenThrow(PokedexException.class);

        assertThrows(PokedexException.class, () -> metadataProvider.getPokemonMetadata(999));
    }
}
