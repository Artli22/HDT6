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
            br.readLine(); 
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 9) { 
                    String name = data[0];
                    String type1 = data[2];
                    String type2 = data[3].isEmpty() ? "" : data[3];
                    String ability = data[8].split(",")[0]; 
    
                    allPokemons.addPokemon(new Pokemon(name, type1, type2, ability));
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

    public Almacenar_Pokemon getUserCollection() {
        return userCollection;
    }
    public Almacenar_Pokemon getAllpokemons() {
        return allPokemons;
    }
}



