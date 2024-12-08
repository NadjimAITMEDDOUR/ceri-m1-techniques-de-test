package fr.univavignon.pokedex.api;

public class PokedexFactory implements IPokedexFactory {

    @Override
    public IPokedex createPokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
        if (metadataProvider == null || pokemonFactory == null) {
            throw new NullPointerException("MetadataProvider and PokemonFactory cannot be null.");
        }
        return new Pokedex(metadataProvider, pokemonFactory);
    }
}
