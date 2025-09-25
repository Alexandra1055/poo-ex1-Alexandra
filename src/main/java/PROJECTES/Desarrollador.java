package PROJECTES;

public class Desarrollador {
    private final String nombre;

    public Desarrollador (String nombre){
        this.nombre=nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override public String toString() { return nombre; }
}
