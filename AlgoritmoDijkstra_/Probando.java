import java.util.Scanner;

// Clase principal para ejecutar y probar el algoritmo de Dijkstra
public class Probando {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Se pide al usuario cuántos vértices tendrá el grafo
        System.out.print("Digite el número de vértices: ");
        int numero = sc.nextInt();

        // Se crea el grafo con el tamaño indicado
        Grafos grafo = new Grafos(numero);

        // Se llena el grafo pidiendo al usuario los pesos
        grafo.ponderadoNODir();

        // Se muestra la matriz de adyacencia del grafo
        System.out.println("\nMatriz de adyacencia del grafo:");
        System.out.println(grafo);

        // Se pide vértice inicial y final
        System.out.print("Digite el vértice inicial (0 a " + (numero - 1) + "): ");
        int inicio = sc.nextInt();

        System.out.print("Digite el vértice final (0 a " + (numero - 1) + "): ");
        int fin = sc.nextInt();

        // Se crea un objeto Dijkstra con un valor grande inicial (999 = infinito)
        Dijkstra dij = new Dijkstra(999, "", inicio, fin);

        // Se ejecuta el algoritmo desde el vertice inicial al final
        Dijkstra resultado = grafo.dijkstra(inicio, fin, 0, "", dij);

        // Se muestra el resultado final
        System.out.println("\nResultado:");
        System.out.println(resultado);

        sc.close(); // Cierra el Scanner
    }
}
