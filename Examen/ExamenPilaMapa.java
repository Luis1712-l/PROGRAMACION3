import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ExamenPilaMapa {

    static class PilaEnteros {
        private int[] datos;
        private int tope; // -1 si e s t v a c a

        public PilaEnteros(int capacidad) {
            datos = new int[capacidad];
            tope = -1;
        }

        public boolean estaVacia() {
            return tope == -1;
        }

        public boolean estaLlena() {
            return tope + 1 == datos.length;
        }

        public void apilar(int x) {
            if (estaLlena())
                throw new IllegalStateException(" Pila llena ");
            tope++;
            datos[tope] = x;
        }

        public int desapilar() {
            if (estaVacia()) throw new IllegalStateException(" Pila v a c a ");
            int v = datos[tope];
            tope--;  
            return v;
        }
    }

    // (50 pts ) Verifica si los p a r n t e s i s e s t n balanceados .
    public static boolean esBalanceado(String s) {
        // Crear pila con capacidad igual a longitud del string
        PilaEnteros pila = new PilaEnteros(s.length());

        // Recorrer cada caracter del string
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                // Si encontramos parentesis abierto, apilamos 1
                pila.apilar(1);
            } else if (c == ')') {
                // Si encontramos parentesis cerrado
                if (pila.estaVacia()) {
                    // Pila vacia significa que hay parentesis cerrado sin abrir
                    return false;
                }
                // Desapilamos el parentesis abierto correspondiente
                pila.desapilar();
            }
        }

        // Si la pila esta vacia al final, todos los parentesis estan balanceados
        return pila.estaVacia();
    }

    // (50 pts ) Actualiza la c a l i f i c a c i n si existe el id y e s t en rango 0..100.
    public static boolean actualizarCalificacion(Map<Integer, Integer> califPorId, int id, int nuevo) {
        // Verificar si la nueva calificacion esta en rango valido (0-100)
        if (nuevo < 0 || nuevo > 100) {
            return false; // Calificacion fuera de rango
        }

        // Verificar si el ID existe en el mapa
        if (!califPorId.containsKey(id)) {
            return false; // ID no encontrado
        }

        // Actualizar la calificacion para el ID
        califPorId.put(id, nuevo);
        return true; // Actualizacion exitosa
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String cadena = sc.nextLine();
        System.out.println(" Balanceado : " + esBalanceado(cadena));

        Map<Integer, Integer> mapa = new HashMap<Integer, Integer>();
        mapa.put(101, 70);
        System.out.println(" Actualizado : " + actualizarCalificacion(mapa, 101, 95));

        sc.close();
    }
}

