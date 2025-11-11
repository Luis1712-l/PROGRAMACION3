// Clase que representa el resultado del algoritmo de Dijkstra
// Guarda la distancia mínima (cantidad) y el recorrido hecho
public class Dijkstra {
    // Atributos principales
    private int cantidad;     // Almacena la distancia mínima encontrada
    private String recorrido; // Guarda el camino tomado como texto
    private int ini;          // Nodo inicial
    private int fin;          // Nodo final

    // 🔹 Constructor: inicializa los valores del objeto Dijkstra
    public Dijkstra(int n, String re, int ini, int fin) {
        this.cantidad = n;
        this.recorrido = re;
        this.ini = ini;
        this.fin = fin;
    }

    // 🔹 Muestra el resultado en un formato legible
    @Override
    public String toString() {
        return "Mínimo: " + this.cantidad + " | Recorrido: " + this.ini + " " + this.recorrido + this.fin;
    }

    // 🔹 Getters y setters (para acceder o modificar los atributos)
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getRecorrido() {
        return recorrido;
    }

    public void setRecorrido(String recorrido) {
        this.recorrido = recorrido;
    }
}
