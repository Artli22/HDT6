import java.util.Collection;

public interface Almacenar_Pokemon {
    void addPokemon(Pokemon pokemon);
    Pokemon getPokemon(String name);
    Collection<Pokemon> getAllPokemons();
}

