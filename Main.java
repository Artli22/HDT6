import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Lectura del archivo csv
        String filePath = "pokemon_Data.csv";
        
        try {
            Admin_Pokemon manager = new Admin_Pokemon(filePath);
            Scanner scanner = new Scanner(System.in);

            boolean continuar = true;
            while (continuar) {
                System.out.println("\n*****Pokedex Novena Generacion*****\n Bienvenido, escoga una opcion: \n1) Agregar Pokémon\n2) Mostrar Pokémon\n3) Buscar por tipo\n4) Salir");
                int option = scanner.nextInt();
                scanner.nextLine();

                switch (option) {
                    case 1:
                        System.out.print("Ingrese el nombre del Pokémon: ");
                        String name = scanner.nextLine();
                        manager.Agregar_Pokemon_Usuario(name);
                        break;
                    case 2:
                        System.out.print("Ingrese el nombre del Pokémon: ");
                        String searchName = scanner.nextLine();
                        manager.Mostrar_Detalles(searchName);
                        break;
                    case 3:
                        System.out.print("Ingrese el tipo del Pokémon: ");
                        String type = scanner.nextLine();
                        long timepoBusqueda = manager.Buscar_por_Tipo(type);
                        System.out.println("Tiempo de ejecucion para busqueda de tipo "+ type +":"+ (timepoBusqueda/1000000) + "ms, demostrando que tiene comlejidad O(1) de busqueda");
                        break;
                    case 4:
                        System.out.println("Saliendo del programa.....");
                        continuar = false;
                        break;
                    default:
                        System.out.println("Escoga una opcion valida");
                }
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("Error al cargar la Pokedex: " + e.getMessage());
        }
    }
}

