import java.util.*;

public class Almacenamiento_TreeMap implements Almacenar_Pokemon {
    private Map<String, Pokemon> pokedex = new TreeMap<>();

    @Override
    public void addPokemon(Pokemon pokemon) {
        pokedex.put(pokemon.getName(), pokemon);
    }

    @Override
    public Pokemon getPokemon(String name) {
        return pokedex.get(name);
    }

    @Override
    public Collection<Pokemon> getAllPokemons() {
        return pokedex.values();
    }
}

