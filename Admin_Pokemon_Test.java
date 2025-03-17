
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;


import java.io.IOException;
import org.junit.Test;


public class Admin_Pokemon_Test {
    //Comprobar que el pokemon quede almacenado en el listado del usuario
    @Test
    public void testAgregarPokemonUsuario() throws IOException {
        Admin_Pokemon adminPokemon = new Admin_Pokemon("Pokemon_Data.csv");
        adminPokemon.Agregar_Pokemon_Usuario("Ditto");
    
        assertNotNull(adminPokemon.getUserCollection().getPokemon("Ditto"));
    }

    // Comprobar que se lea de forma correcta las caracteristicas de todos los pokemon
    @Test
    public void testMostrarDetallesPokemonExistente() throws IOException {
    Admin_Pokemon adminPokemon = new Admin_Pokemon("Pokemon_Data.csv");
    Pokemon expected = new Pokemon("Mew", "Psychic", "Electric", "Synchronize");

    Pokemon actual = adminPokemon.getAllpokemons().getPokemon("Ditto");
    assertNotNull(actual);

    assertNotEquals(expected.getName(), actual.getName());
    assertNotEquals(expected.getType1(), actual.getType1());
    assertNotEquals(expected.getType2(), actual.getType2());
    assertNotEquals(expected.getAbility(), actual.getAbility());
}

}
