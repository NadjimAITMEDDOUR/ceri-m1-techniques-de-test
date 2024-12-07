package fr.univavignon.pokedex.api;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IPokedexFactoryTest {

    private IPokedexFactory pokedexFactory;
    private IPokedex pokedex;

    @BeforeEach
    void setUp() {
        pokedexFactory = mock(IPokedexFactory.class);
        pokedex = mock(IPokedex.class);

        when(pokedexFactory.createPokedex(any(), any())).thenReturn(pokedex);
    }

    @Test
    void testCreatePokedex() {
        IPokedex createdPokedex = pokedexFactory.createPokedex(mock(IPokemonMetadataProvider.class), mock(IPokemonFactory.class));
        assertNotNull(createdPokedex);
        assertEquals(pokedex, createdPokedex);
    }
}
