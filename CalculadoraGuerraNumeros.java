import java.util.*;

public class CalculadoraGuerraNumeros {
    public static int calcularDiferencia(int[] numeros) {
        Queue<Integer> cola = new LinkedList<>();
        for (int num : numeros) {
            cola.offer(num);
        }
        
        int sumaPares = 0;
        int sumaImpares = 0;
        
        while (!cola.isEmpty()) {
            int num = cola.poll();
            if (num % 2 == 0) {
                sumaPares += num;
            } else {
                sumaImpares += num;
            }
        }
        
        return Math.abs(sumaImpares - sumaPares);
    }
}