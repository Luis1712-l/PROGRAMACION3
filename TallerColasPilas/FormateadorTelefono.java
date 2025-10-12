import java.util.*;

public class FormateadorTelefono {
    public static String formatear(int[] digitos) {
        if (digitos.length != 10) {
            throw new IllegalArgumentException("Debe proporcionar exactamente 10 dígitos");
        }
        
        Queue<Integer> cola = new LinkedList<>();
        for (int digito : digitos) {
            cola.offer(digito);
        }
        
        StringBuilder resultado = new StringBuilder();
        resultado.append("(");
        
        for (int i = 0; i < 3; i++) {
            resultado.append(cola.poll());
        }
        
        resultado.append(") ");
        
        for (int i = 0; i < 3; i++) {
            resultado.append(cola.poll());
        }
        
        resultado.append("-");
        
        for (int i = 0; i < 4; i++) {
            resultado.append(cola.poll());
        }
        
        return resultado.toString();
    }
}