package fr.univavignon.pokedex.api;

public class PokemonTrainerFactory implements IPokemonTrainerFactory {

    @Override
    public PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Trainer name cannot be null or empty.");
        }
        if (team == null) {
            throw new NullPointerException("Trainer team cannot be null.");
        }
        if (pokedexFactory == null) {
            throw new NullPointerException("PokedexFactory cannot be null.");
        }
        IPokedex pokedex = pokedexFactory.createPokedex(new PokemonMetadataProvider(), new PokemonFactory());
        return new PokemonTrainer(name, team, pokedex);
    }
}
