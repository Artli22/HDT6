import java.util.*;

// Almacenamiento LinkedHashMap
public class Almacenamiento_LinkedHashMap implements Almacenar_Pokemon {
    private Map<String, Pokemon> pokedex = new LinkedHashMap<>();

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

