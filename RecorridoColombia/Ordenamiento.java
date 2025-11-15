import java.util.List;

public class Ordenamiento {

    public static void ordenarPorDistancia(List<ResultadoDijkstra> lista) {

        for (int i = 0; i < lista.size() - 1; i++) {
            for (int j = 0; j < lista.size() - i - 1; j++) {

                if (lista.get(j).distanciaMinima > lista.get(j + 1).distanciaMinima) {

                    ResultadoDijkstra temp = lista.get(j);
                    lista.set(j, lista.get(j + 1));
                    lista.set(j + 1, temp);
                }
            }
        }
    }
}

