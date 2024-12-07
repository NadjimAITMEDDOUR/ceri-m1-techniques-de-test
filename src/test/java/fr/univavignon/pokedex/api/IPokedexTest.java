package fr.univavignon.pokedex.api;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class IPokedexTest {

    private IPokedex pokedex;
    private Pokemon bulbizarre;
    private Pokemon aquali;

    @BeforeEach
    void setUp() throws PokedexException {
        pokedex = mock(IPokedex.class);

        bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56.0);
        aquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100.0);

        when(pokedex.size()).thenReturn(2);
        when(pokedex.addPokemon(bulbizarre)).thenReturn(0);
        when(pokedex.addPokemon(aquali)).thenReturn(1);
        when(pokedex.getPokemon(0)).thenReturn(bulbizarre);
        when(pokedex.getPokemon(133)).thenReturn(aquali);
        when(pokedex.getPokemons()).thenReturn(Arrays.asList(bulbizarre, aquali));
        when(pokedex.getPokemons(any(Comparator.class)))
                .thenReturn(Arrays.asList(aquali, bulbizarre));
    }

    @Test
    void testSize() {
        assertEquals(2, pokedex.size());
    }

    @Test
    void testAddPokemon() {
        assertEquals(0, pokedex.addPokemon(bulbizarre));
        assertEquals(1, pokedex.addPokemon(aquali));
    }

    @Test
    void testGetPokemon_ValidId() throws PokedexException {
        assertEquals(bulbizarre, pokedex.getPokemon(0));
        assertEquals(aquali, pokedex.getPokemon(133));
    }

    @Test
    void testGetPokemon_InvalidId() throws PokedexException {
        when(pokedex.getPokemon(999)).thenThrow(PokedexException.class);

        assertThrows(PokedexException.class, () -> pokedex.getPokemon(999));
    }

    @Test
    void testGetPokemons() {
        List<Pokemon> pokemons = pokedex.getPokemons();
        assertNotNull(pokemons);
        assertEquals(2, pokemons.size());
    }

    @Test
    void testGetPokemonsSorted() {
        List<Pokemon> sortedPokemons = pokedex.getPokemons(Comparator.comparing(Pokemon::getCp).reversed());
        assertNotNull(sortedPokemons);
        assertEquals(aquali, sortedPokemons.get(0));
    }

    @Test
    void testGetPokemons_EmptyList() {
        when(pokedex.getPokemons()).thenReturn(Collections.emptyList());
        List<Pokemon> pokemons = pokedex.getPokemons();
        assertNotNull(pokemons);
        assertTrue(pokemons.isEmpty());
    }

}
