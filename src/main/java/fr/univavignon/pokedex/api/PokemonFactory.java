package fr.univavignon.pokedex.api;

public class PokemonFactory implements IPokemonFactory {

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        // Exemples d'IVs fictifs pour l'implémentation. Calcul réel possible plus tard.
        double iv = Math.random() * 100.0;
        try {
            PokemonMetadata metadata = new PokemonMetadataProvider().getPokemonMetadata(index);
            return new Pokemon(index, metadata.getName(), metadata.getAttack(), metadata.getDefense(),
                    metadata.getStamina(), cp, hp, dust, candy, iv);
        } catch (PokedexException e) {
            throw new IllegalArgumentException("Invalid index for Pokemon creation: " + index, e);
        }
    }
}
