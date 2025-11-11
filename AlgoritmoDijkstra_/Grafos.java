import java.util.Scanner;

// Clase que representa un grafo ponderado NO dirigido
// Permite crear el grafo, mostrarlo y aplicar el algoritmo de Dijkstra
public class Grafos {
    private int[][] aristas;     // Matriz principal del grafo (conexiones y pesos)
    private int[][] matrizAux;   // Matriz auxiliar (se modifica durante Dijkstra)
    private Scanner sc = new Scanner(System.in); // Para leer datos del usuario

    // 🔹 Constructor: inicializa las matrices con el tamaño indicado (n nodos)
    public Grafos(int n) {
        this.aristas = new int[n][n];
        this.matrizAux = new int[n][n];
    }

    // 🔹 Getter y setter de la matriz auxiliar
    public int[][] getMatrizAux() {
        return matrizAux;
    }

    public void setMatrizAux(int[][] matrizAux) {
        this.matrizAux = matrizAux;
    }

    // 🔹 Método que llena la matriz de adyacencia del grafo con los pesos
    // Se pregunta al usuario si hay relación entre dos nodos y con qué peso
    public void ponderadoNODir() {
        for (int i = 0; i < aristas.length; i++) {
            // Comienza en j = i + 1 para no repetir relaciones (porque es no dirigido)
            for (int j = i + 1; j < aristas[0].length; j++) {
                System.out.print("¿Hay relación entre " + (i + 1) + " y " + (j + 1) + "? (0 si no, peso si sí): ");
                String relacion = sc.next();

                try {
                    // Si el usuario ingresa un número, se interpreta como peso
                    int peso = Integer.parseInt(relacion);
                    aristas[i][j] = aristas[j][i] = peso;
                    matrizAux[i][j] = matrizAux[j][i] = peso;
                } catch (NumberFormatException e) {
                    // Si el valor no es numérico, se asigna 0 (sin conexión)
                    aristas[i][j] = aristas[j][i] = 0;
                    matrizAux[i][j] = matrizAux[j][i] = 0;
                }
            }
        }
        System.out.println();
    }

    // 🔹 Muestra la matriz de adyacencia del grafo
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

    // 🔹 Restaura la matriz auxiliar con los valores originales
    // Se usa después de cada llamada recursiva de Dijkstra
    public void volverLlenar() {
        for (int i = 0; i < aristas.length; i++) {
            for (int j = i; j < aristas[0].length; j++) {
                matrizAux[i][j] = matrizAux[j][i] = aristas[i][j];
            }
        }
    }

    // 🔹 Implementación recursiva del algoritmo de Dijkstra
    // vertice = nodo actual, fin = destino, trae = distancia acumulada,
    // recorrido = camino actual, mejor = mejor resultado encontrado
    public Dijkstra dijkstra(int vertice, int fin, int trae, String recorrido, Dijkstra mejor) {

        // Si hay conexión directa al nodo final y mejora la distancia mínima
        if (matrizAux[vertice][fin] != 0 && mejor.getCantidad() > matrizAux[vertice][fin] + trae) {
            // Actualiza el resultado con la nueva distancia más corta
            mejor.setCantidad(matrizAux[vertice][fin] + trae);
            // Elimina la conexión (para evitar volver atrás)
            matrizAux[vertice][fin] = matrizAux[fin][vertice] = 0;
            // Guarda el recorrido actual
            mejor.setRecorrido(recorrido);
        }

        // Recorre todos los nodos vecinos del vértice actual
        for (int i = 0; i < matrizAux.length; i++) {
            // Si hay conexión y se puede mejorar la distancia
            if (matrizAux[vertice][i] != 0 && mejor.getCantidad() > (matrizAux[vertice][i] + trae)) {
                int temporal = matrizAux[vertice][i] + trae; // Nueva distancia acumulada
                matrizAux[vertice][i] = matrizAux[i][vertice] = 0; // Marca la conexión como usada
                String nuevoRecorrido = recorrido + " " + i + " "; // Agrega el nodo al recorrido

                // Llamada recursiva desde el nuevo vértice
                mejor = dijkstra(i, fin, temporal, nuevoRecorrido, mejor);
            }
        }

        // Restaura las conexiones para próximas llamadas
        volverLlenar();
        return mejor;
    }
}
