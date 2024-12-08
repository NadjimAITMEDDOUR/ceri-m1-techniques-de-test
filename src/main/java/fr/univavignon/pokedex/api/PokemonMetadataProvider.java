package fr.univavignon.pokedex.api;

import java.util.HashMap;
import java.util.Map;

public class PokemonMetadataProvider implements IPokemonMetadataProvider {

    // Base de données fictive pour les métadonnées des Pokémon
    private final Map<Integer, PokemonMetadata> metadataDatabase;

    public PokemonMetadataProvider() {
        metadataDatabase = new HashMap<>();
        initializeMetadata();
    }

    // Initialisation des métadonnées fictives
    private void initializeMetadata() {
        metadataDatabase.put(0, new PokemonMetadata(0, "Bulbizarre", 126, 126, 90));
        metadataDatabase.put(133, new PokemonMetadata(133, "Aquali", 186, 168, 260));

    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        if (!metadataDatabase.containsKey(index)) {
            throw new PokedexException("No metadata found for Pokemon with index: " + index);
        }
        return metadataDatabase.get(index);
    }
}
