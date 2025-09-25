package MAIN;

import ENUM.Rol;
import PROJECTES.*;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Proyecto proyecto = new Proyecto("Proyecto Final", LocalDate.now());

        Tarea analisis = new Tarea("Análisis", 12);
        Tarea maquetador = new Tarea("Maquetador Grid/Flex", 8);
        Tarea backend = new Tarea("Implementacion de API", 30);
        Tarea frontend = new Tarea("Sistema de diseño", 24);
        Tarea despliegue = new Tarea("Despliegue", 6);
        Tarea permisos = new Tarea("Politica de permisos", 5);

        Tarea modeladoDatos = new Tarea("Modelado de datos", 8);
        analisis.addSubTarea(modeladoDatos);
        Tarea tokens = new Tarea("Añadir tokens", 10);
        backend.addSubTarea(tokens);
        Tarea SQL = new Tarea("Optimizar SQL", 15);
        despliegue.addSubTarea(SQL);
        Tarea notificacion = new Tarea("Optimizar SQL", 15);
        backend.addSubTarea(notificacion);



        backend.addPrerrequisito(analisis);
        backend.addPrerrequisito(tokens);
        frontend.addPrerrequisito(maquetador);
        frontend.addPrerrequisito(analisis);
        despliegue.addPrerrequisito(backend);
        despliegue.addPrerrequisito(permisos);
        despliegue.addPrerrequisito(SQL);
        despliegue.addPrerrequisito(notificacion);

        proyecto.addTarea(analisis);
        proyecto.addTarea(backend);
        proyecto.addTarea(frontend);
        proyecto.addTarea(despliegue);
        proyecto.addTarea(maquetador);
        proyecto.addTarea(tokens);
        proyecto.addTarea(SQL);
        proyecto.addTarea(notificacion);
        proyecto.addTarea(permisos);

        Desarrollador X = new Desarrollador("Rosa");
        Desarrollador Y = new Desarrollador("Cristian");
        Desarrollador Z = new Desarrollador("Josep");

        proyecto.addParticipacion(new Participacion(X, Rol.FULLSTACK, 20));
        proyecto.addParticipacion(new Participacion(Y, Rol.BACKEND,   30));
        proyecto.addParticipacion(new Participacion(Z, Rol.FRONTEND,  22));

        List<Tarea> tareasEnOrden = proyecto.ordenTareas();
        Output.mostrarConSalto("Orden de trabajo (respetando dependencias):");
        for (int i = 0; i < tareasEnOrden.size(); i++) {
            Tarea tarea = tareasEnOrden.get(i);
            Output.mostrarConSalto((i + 1) + "- Tarea: " + tarea.getNombre()
                    + " | Horas: " + tarea.getHorasTotales() + "h");

            List<Tarea> subTareas = tarea.getSubTarea();
            for (int j = 0; j < subTareas.size(); j++) {
                Tarea sub = subTareas.get(j);
                Output.mostrarConSalto("   - " + sub.getNombre());
            }
        }

        Output.mostrarConSalto(""); // línea en blanco

        Output.mostrarConSalto("Proyecto: " + proyecto.getNombre() + " (inicio: " + proyecto.getFechaInicio() + ")");
        Output.mostrarConSalto("Horas estimadas de las tareas: " + proyecto.getTotalHorasTareas());
        Output.mostrarConSalto("Horas asignadas a los desarrolladores: " + proyecto.getTotalHorasAsignadas());

        Output.mostrarConSalto("Participaciones:");
        List<Participacion> listaParticipaciones = proyecto.getParticipaciones();
        for (int i = 0; i < listaParticipaciones.size(); i++) {
            Participacion participacion = listaParticipaciones.get(i);
            Output.mostrarConSalto( participacion.toString());
        }
    }
}
