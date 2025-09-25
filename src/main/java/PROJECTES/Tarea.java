package PROJECTES;

import MAIN.Output;

import java.util.ArrayList;
import java.util.List;

public class Tarea {
    private String nombre;
    private int numHoras;
    private List<Tarea> subTarea;
    private List<Tarea> prerrequisito;

    public Tarea(String nombre, int numHoras){
        this.nombre = nombre;
        this.numHoras = numHoras;
        this.subTarea = new ArrayList<>();
        this.prerrequisito = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumHoras() {
        return numHoras;
    }

    public List<Tarea> getSubTarea() {
        return subTarea;
    }

    public void addSubTarea(Tarea hija){
        subTarea.add(hija);
    }

    public List<Tarea> getPrerrequisito(){
        return prerrequisito;
    }

    public boolean addPrerrequisito(Tarea requisito){
        if(requisito == null || requisito == this){
            return false;
        }
        if (prerrequisito.contains(requisito)){
            return false;
        }
        prerrequisito.add(requisito);
        return true;
    }

    public int getHorasTotales(){
        int total = numHoras;
        for (int i = 0; i < subTarea.size(); i++) {
            Tarea tarea = subTarea.get(i);
            total += tarea.getHorasTotales();
        }
        return total;
    }

    @Override
    public String toString() {
        return nombre + " (" + numHoras + "horas)";
    }
}
