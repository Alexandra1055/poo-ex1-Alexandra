package PROJECTES;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Proyecto {
    private String nombre;
    private LocalDate fechaInicio;
    private List<Tarea> tareas;
    private List<Participacion> participaciones;

    public Proyecto (String nombre, LocalDate fechaInicio){
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.tareas = new ArrayList<>();
        this.participaciones = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public List<Tarea> getTareas() {
        return tareas;
    }

    public List<Participacion> getParticipaciones() {
        return participaciones;
    }

    public void addTarea(Tarea tarea){
        tareas.add(tarea);
    }

    public void addParticipacion(Participacion participacion){
        participaciones.add(participacion);
    }

    public int getTotalHorasAsignadas() {
        int total = 0;
        for (int i = 0; i < participaciones.size(); i++) {
            Participacion participacion = participaciones.get(i);
            total += participacion.getHorasAsignadas();
        }
        return total;
    }

    public int getTotalHorasTareas() {
        int total = 0;
        for (int i = 0; i < tareas.size(); i++) {
            Tarea tarea = tareas.get(i);
            total += tarea.getHorasTotales();
        }
        return total;
    }

    public List<Tarea> ordenTareas() {
        List<Tarea> resultadoEnOrden = new ArrayList<>();
        List<Tarea> tareasVisitadas = new ArrayList<>();
        List<Tarea> tareasEnProceso = new ArrayList<>();

        for (int i = 0; i < tareas.size(); i++) {
            Tarea tarea = tareas.get(i);
            if (!tareasVisitadas.contains(tarea)) {
                recorridoParaOrden(tarea, tareasVisitadas, tareasEnProceso, resultadoEnOrden);
            }
        }
        return resultadoEnOrden;
    }

    private void recorridoParaOrden(
            Tarea tareaActual,
            List<Tarea> tareasVisitadas,
            List<Tarea> tareasEnProceso,
            List<Tarea> salidaEnOrden) {

        if (tareasVisitadas.contains(tareaActual)) {
            return;
        }
        if (tareasEnProceso.contains(tareaActual)) {
            return;
        }

        tareasEnProceso.add(tareaActual);

        List<Tarea> prerequisitos = tareaActual.getPrerrequisito();
        for (int i = 0; i < prerequisitos.size(); i++) {
            Tarea requisito = prerequisitos.get(i);
            recorridoParaOrden(requisito, tareasVisitadas, tareasEnProceso, salidaEnOrden);
        }

        for (int i = 0; i < tareasEnProceso.size(); i++) {
            if (tareasEnProceso.get(i) == tareaActual) {
                tareasEnProceso.remove(i);
                break;
            }
        }
        tareasVisitadas.add(tareaActual);
        salidaEnOrden.add(tareaActual);
    }

}
