package SistemaGestiónTareasAsíncronasPriorizadas;

public class Main {
    public static void main(String[] args) {
        GestorTareas gestor = new GestorTareas();
        
        // Crear tareas de prueba
        Tarea t1 = new Tarea("T001", "Actualizar datos", 1);
        Tarea t2 = new Tarea("T002", "Reporte mensual", 2);
        Tarea t3 = new Tarea("T003", "Error crítico", 3);
        Tarea t4 = new Tarea("T004", "Backup", 1);
        Tarea t5 = new Tarea("T005", "Alerta seguridad", 3);
        
        // Agregar tareas
        gestor.agregarTarea(t1);
        gestor.agregarTarea(t2);
        gestor.agregarTarea(t3);
        gestor.agregarTarea(t4);
        gestor.agregarTarea(t5);
        
        // Mostrar estado inicial
        gestor.mostrarEstado();
        
        // Procesar algunas tareas
        gestor.procesarSiguienteTarea(); // Procesa T005 (urgente)
        gestor.procesarSiguienteTarea(); // Procesa T003 (urgente)  
        gestor.procesarSiguienteTarea(); // Procesa T001 (normal)
        
        // Mostrar estado después de procesar
        gestor.mostrarEstado();
        
        // Consultar estados
        System.out.println("T001: " + gestor.consultarEstadoTarea("T001"));
        System.out.println("T002: " + gestor.consultarEstadoTarea("T002"));
        System.out.println("T003: " + gestor.consultarEstadoTarea("T003"));
        System.out.println("T999: " + gestor.consultarEstadoTarea("T999")); // No existe
    }
}