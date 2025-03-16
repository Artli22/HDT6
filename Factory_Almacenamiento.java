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
    public Almacenar_Pokemon createStorage(String type) {
        switch (type.toLowerCase()) {
            case "user": return new Almacenamiento_HashMap();
            case "pokedex": return new Almacenamiento_TreeMap();
            case "search": return new Almacenamiento_LinkedHashMap();
            default: throw new IllegalArgumentException("Tipo de almacenamiento no válido");
        }
    }

}
