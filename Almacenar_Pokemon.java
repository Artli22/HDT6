import java.util.Collection;

// Interfaz general de todos los metodos de almacenamiento de datos
public interface Almacenar_Pokemon {
    void addPokemon(Pokemon pokemon);
    Pokemon getPokemon(String name);
    Collection<Pokemon> getAllPokemons();
}

