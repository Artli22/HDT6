import java.io.*;
import java.util.*;

public class Admin_Pokemon {
    private Almacenar_Pokemon allPokemons;
    private Almacenar_Pokemon userCollection;
    
    public Admin_Pokemon(String filePath) throws IOException {
        Factory_Almacenamiento factory = Factory_Almacenamiento.getInstance();
        this.allPokemons = factory.createStorage("pokedex");
        this.userCollection = factory.createStorage("user");
        cargarPokemonsCSV(filePath);
    }

    private void cargarPokemonsCSV(String filePath) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Ignorar la primera línea (encabezados)
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 4) {
                    allPokemons.addPokemon(new Pokemon(data[0], data[1], data[2], data[3]));
                }
            }
        }
    }

    public void Agregar_Pokemon_Usuario(String name) {
        Pokemon pokemon = allPokemons.getPokemon(name);
        if (pokemon != null) {
            userCollection.addPokemon(pokemon);
            System.out.println(name + " agregado a tu colección.");
        } else {
            System.out.println("Error: Pokémon no encontrado.");
        }
    }

    public void Mostrar_Detalles(String name) {
        Pokemon pokemon = allPokemons.getPokemon(name);
        if (pokemon != null) {
            System.out.println(pokemon);
        } else {
            System.out.println("Error: Pokémon no encontrado.");
        }
    }

    public void Buscar_por_Tipo(String type) {
        List<Pokemon> resultados = new ArrayList<>();
        for (Pokemon pokemon : allPokemons.getAllPokemons()) {
            if (pokemon.getType1().equalsIgnoreCase(type) || pokemon.getType2().equalsIgnoreCase(type)) {
                resultados.add(pokemon);
            }
        }
        if (resultados.isEmpty()) {
            System.out.println("No se encontraron Pokémon de tipo " + type);
        } else {
            resultados.forEach(System.out::println);
        }
    }
}



