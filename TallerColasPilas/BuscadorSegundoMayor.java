import java.util.*;

public class BuscadorSegundoMayor {
    public static int encontrarSegundoMayor(int[] numeros) {
        if (numeros.length < 2) {
            throw new IllegalArgumentException("Debe haber al menos 2 números");
        }
        
        Queue<Integer> cola = new LinkedList<>();
        for (int num : numeros) {
            cola.offer(num);
        }
        
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        
        while (!cola.isEmpty()) {
            int actual = cola.poll();
            
            if (actual > max1) {
                max2 = max1;
                max1 = actual;
            } else if (actual > max2 && actual != max1) {
                max2 = actual;
            } else if (actual == max1 && max2 < actual) {
                max2 = actual;
            }
        }
        
        if (max2 == Integer.MIN_VALUE) {
            return max1;
        }
        
        return max2;
    }
}