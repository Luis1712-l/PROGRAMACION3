package SistemaGestiónTareasAsíncronasPriorizadas;

public class Tarea {
    private String id;
    private String descripcion;
    private int prioridad; // 1 (Baja), 2 (Media), 3 (Alta)
    private long tiempoLlegada;
    
    public Tarea(String id, String descripcion, int prioridad) {
        this.id = id;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.tiempoLlegada = System.currentTimeMillis();
    }
    
    // Getters simples
    public String getId() { return id; }
    public String getDescripcion() { return descripcion; }
    public int getPrioridad() { return prioridad; }
    public long getTiempoLlegada() { return tiempoLlegada; }
}