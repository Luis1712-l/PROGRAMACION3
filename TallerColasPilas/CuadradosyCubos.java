import java.util.*;

public class CuadradosyCubos {
    public static boolean sonRaicesEquivalentes(int a, int b) {
        Stack<Double> pila = new Stack<>();
        pila.push((double) b);
        pila.push((double) a);
        
        double valorA = pila.pop();
        double valorB = pila.pop();
        
        double raizCuadrada = Math.sqrt(valorA);
        double raizCubica = Math.cbrt(valorB);
        
        return Math.abs(raizCuadrada - raizCubica) < 0.0001;
    }
}