public class Factory_Almacenamiento {
    private static Factory_Almacenamiento instance;

    private Factory_Almacenamiento() {}
    // Instanciacion de Fctory
    public static Factory_Almacenamiento getInstance() {
        if (instance == null) {
            instance = new Factory_Almacenamiento();
        }
        return instance;
    }

    // Escoge el metodo de almacenamiento mejor adpatado para cada caso

    // Se utilizo el metodo HashMap para guardar los pokemon del usuario ya que es 
    // un metodo aleatorio pero rapido, con una complejidad de tiempo de busqueda y guardado de O(1), 
    //y como la busqueda de la informacion del pokemon se hace con otro JCF mas sofisticado, 
    //pienso que es la mejor opcion.

    public Almacenar_Pokemon createStorage(String type) {
        switch (type.toLowerCase()) {
            case "user": return new Almacenamiento_HashMap();
            case "pokedex": return new Almacenamiento_TreeMap();
            case "search": return new Almacenamiento_LinkedHashMap();
            default: throw new IllegalArgumentException("Tipo de almacenamiento no válido");
        }
    }

}
