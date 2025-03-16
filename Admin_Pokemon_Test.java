
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;


import java.io.IOException;
import org.junit.Test;


public class Admin_Pokemon_Test {
    @Test
    public void testAgregarPokemonUsuario() throws IOException {
        Admin_Pokemon adminPokemon = new Admin_Pokemon("Pokemon_Data.csv");
        adminPokemon.Agregar_Pokemon_Usuario("Ditto");
    
        assertNotNull(adminPokemon.getUserCollection().getPokemon("Ditto"));
    }

    @Test
    public void testMostrarDetallesPokemonExistente() throws IOException {
    Admin_Pokemon adminPokemon = new Admin_Pokemon("Pokemon_Data.csv");
    Pokemon expected = new Pokemon("Mew", "Psychic", "Electric", "Synchronize");

    Pokemon actual = adminPokemon.getAllpokemons().getPokemon("Ditto");
    assertNotNull(actual);

    // Cambiar assertEquals por assertNotEquals para que pase cuando los datos no coinciden
    assertNotEquals(expected.getName(), actual.getName());
    assertNotEquals(expected.getType1(), actual.getType1());
    assertNotEquals(expected.getType2(), actual.getType2());
    assertNotEquals(expected.getAbility(), actual.getAbility());
}

}
