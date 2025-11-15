import java.util.*;

public class Probando {

    public static void main(String[] args) {

        // 7 ciudades del mapa
        String[] ciudades = {
                "Cali",        // 0
                "Medellín",    // 1
                "Bogotá",      // 2
                "Bucaramanga", // 3
                "Cartagena",   // 4
                "Santa Marta", // 5
                "Cúcuta"       // 6
        };

        Grafo grafoColombia = new Grafo(7, ciudades);

        // Agregar conexiones con pesos simulados
        grafoColombia.agregarConexion(0, 1, 5);
        grafoColombia.agregarConexion(0, 2, 10);

        grafoColombia.agregarConexion(1, 4, 7);
        grafoColombia.agregarConexion(1, 5, 8);
        grafoColombia.agregarConexion(1, 2, 4);

        grafoColombia.agregarConexion(2, 3, 6);
        grafoColombia.agregarConexion(2, 6, 9);

        grafoColombia.agregarConexion(3, 5, 7);
        grafoColombia.agregarConexion(3, 6, 4);

        grafoColombia.agregarConexion(4, 5, 3);

        // Ejecutar Dijkstra: Cali → Cartagena
        ResultadoDijkstra resultadoUnico = grafoColombia.dijkstra(0, 4);

        // Guardar resultados
        List<ResultadoDijkstra> listaResultados = new ArrayList<>();
        listaResultados.add(resultadoUnico);

        // Ordenar
        Ordenamiento.ordenarPorDistancia(listaResultados);

        // Mostrar
        System.out.println("=============== RESULTADOS ORDENADOS ===============");
        for (ResultadoDijkstra r : listaResultados) {
            System.out.println(r);
        }
    }
}
