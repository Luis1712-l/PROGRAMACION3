package SistemaGestiónTareasAsíncronasPriorizadas;

import java.util.*;

public class GestorTareas {
    private Queue<Tarea> colaEspera;
    private Stack<Tarea> pilaPrioritaria;
    private Map<String, String> registroTrazabilidad;
    
    public GestorTareas() {
        this.colaEspera = new LinkedList<>();
        this.pilaPrioritaria = new Stack<>();
        this.registroTrazabilidad = new HashMap<>();
    }
    
    // Agregar tarea según prioridad
    public void agregarTarea(Tarea tarea) {
        if (tarea.getPrioridad() == 3) {
            pilaPrioritaria.push(tarea);
            System.out.println("Tarea URGENTE agregada: " + tarea.getId());
        } else if (tarea.getPrioridad() == 1 || tarea.getPrioridad() == 2) {
            colaEspera.add(tarea);
            System.out.println("Tarea NORMAL agregada: " + tarea.getId());
        }
    }
    
    // Procesar siguiente tarea
    public Tarea procesarSiguienteTarea() {
        if (!pilaPrioritaria.isEmpty()) {
            Tarea tarea = pilaPrioritaria.pop();
            registrarTareaCompletada(tarea);
            return tarea;
        } else if (!colaEspera.isEmpty()) {
            Tarea tarea = colaEspera.poll();
            registrarTareaCompletada(tarea);
            return tarea;
        } else {
            System.out.println("No hay tareas pendientes");
            return null;
        }
    }
    
    // Registrar tarea completada en el Map
    private void registrarTareaCompletada(Tarea tarea) {
        String info = "Completada - Tiempo: " + 
                     (System.currentTimeMillis() - tarea.getTiempoLlegada()) + "ms";
        registroTrazabilidad.put(tarea.getId(), info);
        System.out.println("Procesada: " + tarea.getId());
    }
    
    // Consultar estado de tarea
    public String consultarEstadoTarea(String idTarea) {
        // Buscar en tareas completadas (Map)
        if (registroTrazabilidad.containsKey(idTarea)) {
            return registroTrazabilidad.get(idTarea);
        }
        
        // Buscar en pila prioritaria
        for (Tarea tarea : pilaPrioritaria) {
            if (tarea.getId().equals(idTarea)) {
                return "Pendiente - En pila URGENTE";
            }
        }
        
        // Buscar en cola de espera
        for (Tarea tarea : colaEspera) {
            if (tarea.getId().equals(idTarea)) {
                return "Pendiente - En cola normal";
            }
        }
        
        return "ID no encontrado";
    }
    
    // Mostrar estado simple
    public void mostrarEstado() {
        System.out.println("Pila: " + pilaPrioritaria.size() + 
                          " | Cola: " + colaEspera.size() + 
                          " | Completadas: " + registroTrazabilidad.size());
    }
}