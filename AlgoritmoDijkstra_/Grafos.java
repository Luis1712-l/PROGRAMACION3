import java.util.Scanner;

// Clase que representa un grafo ponderado no dirigido
// Permite crear el grafo y aplicar el algoritmo de Dijkstra
public class Grafos {
    private int[][] aristas;     // Matriz principal del grafo (pesos de las conexiones)
    private int[][] matrizAux;   // Copia auxiliar para modificar durante Dijkstra
    private Scanner sc = new Scanner(System.in);

    // Constructor: inicializa las matrices con el tamaño indicado (n nodos)
    public Grafos(int n) {
        this.aristas = new int[n][n];
        this.matrizAux = new int[n][n];
    }

    // Metodo para llenar el grafo con pesos entre los vertices
    public void ponderadoNODir() {
        for (int i = 0; i < aristas.length; i++) {
            // Empieza en j = i + 1 para no repetir conexiones (es no dirigido)
            for (int j = i + 1; j < aristas[0].length; j++) {
                System.out.print("Peso entre " + i + " y " + j + " (0 si no hay conexión): ");
                int peso = sc.nextInt();

                // Se asigna el peso a ambos lados (no dirigido)
                aristas[i][j] = aristas[j][i] = peso;
                matrizAux[i][j] = matrizAux[j][i] = peso;
            }
        }
        System.out.println();
    }

    // Muestra la matriz de adyacencia
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int[] fila : aristas) {
            for (int valor : fila) {
                s.append(valor).append("\t");
            }
            s.append("\n");
        }
        return s.toString();
    }

    // Restaura la matriz auxiliar a su estado original
    public void volverLlenar() {
        for (int i = 0; i < aristas.length; i++) {
            for (int j = i; j < aristas[0].length; j++) {
                matrizAux[i][j] = matrizAux[j][i] = aristas[i][j];
            }
        }
    }

    // Algoritmo recursivo de Dijkstra (versión simplificada)
    public Dijkstra dijkstra(int vertice, int fin, int distancia, String recorrido, Dijkstra mejor) {

        // Si hay conexión directa al destino y mejora la distancia mínima
        if (matrizAux[vertice][fin] != 0 && mejor.getCantidad() > matrizAux[vertice][fin] + distancia) {
            mejor.setCantidad(matrizAux[vertice][fin] + distancia);
            mejor.setRecorrido(recorrido);
            matrizAux[vertice][fin] = matrizAux[fin][vertice] = 0; // Marca como usada
        }

        // Recorre los vecinos del vértice actual
        for (int i = 0; i < matrizAux.length; i++) {
            if (matrizAux[vertice][i] != 0 && mejor.getCantidad() > matrizAux[vertice][i] + distancia) {
                int nuevaDistancia = matrizAux[vertice][i] + distancia;
                matrizAux[vertice][i] = matrizAux[i][vertice] = 0; // Evita volver atrás
                String nuevoRecorrido = recorrido + " " + i + " ";
                mejor = dijkstra(i, fin, nuevaDistancia, nuevoRecorrido, mejor);
            }
        }

        volverLlenar(); // Restaura la matriz auxiliar
        return mejor;
    }
}
