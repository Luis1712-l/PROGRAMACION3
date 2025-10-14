import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ExamenPilaMapa {

    static class PilaEnteros {
        private int[] datos;
        private int tope; // -1 si está vacía

        public PilaEnteros(int capacidad) {
            datos = new int[capacidad];
            tope = -1;
        }

        public boolean estaVacia() { return tope == -1; }
        public boolean estaLlena() { return tope + 1 == datos.length; }

        public void apilar(int x) {
            if (estaLlena()) throw new IllegalStateException("Pila llena");
            tope++;
            datos[tope] = x;
        }

        public int desapilar() {
            if (estaVacia()) throw new IllegalStateException("Pila vacía");
            int v = datos[tope];
            tope--;
            return v;
        }
    }

    // (50 pts) Verifica si los paréntesis están balanceados.
    public static boolean esBalanceado(String s) {
        // Crear pila con capacidad igual a la longitud del string
        PilaEnteros pila = new PilaEnteros(s.length());
        
        // Recorrer cada caracter del string
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == '(') {
                // Apilar 1 cuando encontramos paréntesis de apertura
                pila.apilar(1);
            } else if (c == ')') {
                // Si encontramos paréntesis de cierre y la pila está vacía, no está balanceado
                if (pila.estaVacia()) {
                    return false;
                }
                // Desapilar paréntesis de apertura correspondiente
                pila.desapilar();
            }
        }
        
        // La cadena está balanceada si la pila queda vacía al final
        return pila.estaVacia();
    }

    // (50 pts) Actualiza la calificación si existe el id y está en rango 0..100.
    public static boolean actualizarCalificacion(Map<Integer, Integer> califPorId, int id, int nuevo) {
        // Validar que la nueva calificación esté en el rango permitido 0-100
        if (nuevo < 0 || nuevo > 100) {
            return false; // Calificación fuera de rango
        }
        
        // Verificar si el ID existe en el mapa
        if (!califPorId.containsKey(id)) {
            return false; // ID no encontrado
        }
        
        // Actualizar la calificación para el ID especificado
        califPorId.put(id, nuevo);
        return true; // Actualización exitosa
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String cadena = sc.nextLine();
        System.out.println("Balanceado: " + esBalanceado(cadena));

        Map<Integer, Integer> mapa = new HashMap<Integer, Integer>();
        mapa.put(101, 70);
        System.out.println("Actualizado: " + actualizarCalificacion(mapa, 101, 95));

        sc.close();
    }
}