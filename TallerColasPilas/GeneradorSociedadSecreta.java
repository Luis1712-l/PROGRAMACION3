import java.util.*;

public class GeneradorSociedadSecreta {
    public static String generarNombre(String[] nombres) {
        Queue<String> cola = new LinkedList<>();
        for (String nombre : nombres) {
            cola.offer(nombre);
        }
        
        List<Character> iniciales = new ArrayList<>();
        
        while (!cola.isEmpty()) {
            String nombre = cola.poll();
            if (!nombre.isEmpty()) {
                char inicial = Character.toUpperCase(nombre.charAt(0));
                iniciales.add(inicial);
            }
        }
        
        Collections.sort(iniciales);
        
        StringBuilder resultado = new StringBuilder();
        for (char c : iniciales) {
            resultado.append(c);
        }
        
        return resultado.toString();
    }
}