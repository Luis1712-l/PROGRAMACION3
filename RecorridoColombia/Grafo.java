import java.util.*;

public class Grafo {

    private List<List<Arista>> conexiones; // Lista de adyacencia
    private String[] nombresCiudades;      // Nombres de ciudades

    public Grafo(int cantidadNodos, String[] nombresCiudades) {
        this.nombresCiudades = nombresCiudades;
        conexiones = new ArrayList<>();

        for (int i = 0; i < cantidadNodos; i++) {
            conexiones.add(new ArrayList<>());
        }
    }

    // Agregar arista NO dirigida
    public void agregarConexion(int origen, int destino, int peso) {
        conexiones.get(origen).add(new Arista(destino, peso));
        conexiones.get(destino).add(new Arista(origen, peso));
    }

    // Dijkstra simple
    public ResultadoDijkstra dijkstra(int inicio, int fin) {

        int n = conexiones.size();

        int[] distancia = new int[n];   // distancia mínima
        int[] anterior = new int[n];    // nodo previo

        Arrays.fill(distancia, Integer.MAX_VALUE);
        Arrays.fill(anterior, -1);

        distancia[inicio] = 0;

        PriorityQueue<int[]> cola = new PriorityQueue<>(
                Comparator.comparingInt(a -> a[1])
        );

        cola.add(new int[]{inicio, 0});

        while (!cola.isEmpty()) {
            int[] actual = cola.poll();
            int nodoActual = actual[0];
            int costoActual = actual[1];

            if (nodoActual == fin) break;

            for (Arista ar : conexiones.get(nodoActual)) {
                int nuevoCosto = costoActual + ar.peso;

                if (nuevoCosto < distancia[ar.destino]) {
                    distancia[ar.destino] = nuevoCosto;
                    anterior[ar.destino] = nodoActual;

                    cola.add(new int[]{ar.destino, nuevoCosto});
                }
            }
        }

        // Reconstruir camino
        List<Integer> camino = new ArrayList<>();
        int nodo = fin;

        while (nodo != -1) {
            camino.add(nodo);
            nodo = anterior[nodo];
        }

        Collections.reverse(camino);

        // Convertir a nombres
        List<String> caminoNombres = new ArrayList<>();
        for (int id : camino) {
            caminoNombres.add(nombresCiudades[id]);
        }

        return new ResultadoDijkstra(distancia[fin], camino, caminoNombres);
    }
}
