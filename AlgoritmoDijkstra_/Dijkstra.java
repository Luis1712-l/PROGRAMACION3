// Clase que guarda el resultado del algoritmo de Dijkstra
public class Dijkstra {
    private int cantidad;     // Distancia minima encontrada
    private String recorrido; // Camino recorrido
    private int ini;          // Nodo inicial
    private int fin;          // Nodo final

    // Constructor
    public Dijkstra(int n, String re, int ini, int fin) {
        this.cantidad = n;
        this.recorrido = re;
        this.ini = ini;
        this.fin = fin;
    }

    // Muestra el resultado de forma que se pueda leer
@Override
    public String toString() {
        return "Mínimo: " + this.cantidad + " | Recorrido: " + this.ini + " " + this.recorrido + this.fin;
    }

    // Getters y setters
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
