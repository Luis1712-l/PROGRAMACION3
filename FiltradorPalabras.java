import java.util.*;

public class FiltradorPalabras {
    public static List<String> filtrarPorLongitud(String[] palabras, int longitud) {
        Queue<String> cola = new LinkedList<>();
        for (String palabra : palabras) {
            cola.offer(palabra);
        }
        
        List<String> resultado = new ArrayList<>();
        
        while (!cola.isEmpty()) {
            String palabra = cola.poll();
            if (palabra.length() == longitud) {
                resultado.add(palabra);
            }
        }
        
        return resultado;
    }
}