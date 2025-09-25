package PROJECTES;

import ENUM.Rol;

public class Participacion {
    private final Desarrollador desarrollador;
    private final Rol rol;
    private int horasAsignadas;

    public Participacion(Desarrollador desarrollador, Rol rol, int horasAsignadas) {
        this.desarrollador = desarrollador;
        this.rol = rol;
        this.horasAsignadas = horasAsignadas;
    }

    public Desarrollador getDesarrollador() {
        return desarrollador;
    }

    public Rol getRol() {
        return rol;
    }

    public int getHorasAsignadas() {
        return horasAsignadas;
    }

    public void setHorasAsignadas(int horas){
        this.horasAsignadas = horas;
    }

    @Override public String toString() {
        return desarrollador + " (" + rol + ", " + horasAsignadas + "h)";
    }
}
