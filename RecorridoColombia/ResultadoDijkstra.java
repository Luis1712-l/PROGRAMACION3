import java.util.List;

// Guarda el resultado del algoritmo de Dijkstra
public class ResultadoDijkstra {

    public int distanciaMinima;       // Costo total
    public List<Integer> caminoIDs;   // Camino usando índices
    public List<String> caminoNombres; // Camino usando nombres

    public ResultadoDijkstra(int distanciaMinima, List<Integer> caminoIDs, List<String> caminoNombres) {
        this.distanciaMinima = distanciaMinima;
        this.caminoIDs = caminoIDs;
        this.caminoNombres = caminoNombres;
    }

    @Override
    public String toString() {
        return "Distancia mínima: " + distanciaMinima + 
               " | Camino: " + caminoNombres;
    }
}
