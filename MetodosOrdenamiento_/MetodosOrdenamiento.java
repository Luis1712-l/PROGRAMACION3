import java.util.Scanner;

public class MetodosOrdenamiento {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Arreglo base con algunos números desordenados
        int[] arregloOriginal = {5, 3, 8, 1, 2, 9, 4, 7};
        int opcion;

        do {
            System.out.println("\n===== Menu De Ordenamiento =====");
            System.out.println("1. Burbuja");
            System.out.println("2. Quick Sort");
            System.out.println("3. Merge Sort");
            System.out.println("4. Insercion");
            System.out.println("5. Seleccion");
            System.out.println("6. Salir");
            System.out.print("Elige una opcion: ");
            opcion = sc.nextInt();

            // Se hace una copia del arreglo original para no modificarlo directamente
            int[] arreglo = arregloOriginal.clone();

            switch (opcion) {
                case 1:
                    System.out.println("\n--- Ordenamiento Burbuja ---");
                    burbuja(arreglo);
                    mostrarArreglo(arreglo);
                    break;

                case 2:
                    System.out.println("\n--- Ordenamiento Quick Sort ---");
                    quickSort(arreglo, 0, arreglo.length - 1);
                    mostrarArreglo(arreglo);
                    break;

                case 3:
                    System.out.println("\n--- Ordenamiento Merge Sort ---");
                    mergeSort(arreglo, 0, arreglo.length - 1);
                    mostrarArreglo(arreglo);
                    break;

                case 4:
                    System.out.println("\n--- Ordenamiento Por Insercion ---");
                    insercion(arreglo);
                    mostrarArreglo(arreglo);
                    break;

                case 5:
                    System.out.println("\n--- Ordenamiento Por  Seleccion ---");
                    seleccion(arreglo);
                    mostrarArreglo(arreglo);
                    break;

                case 6:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no valida, intenta de nuevo.");
            }

        } while (opcion != 6);

        sc.close();
    }

    // MÉTODOS DE ORDENAMIENTO

    //BURBUJA
    // Compara pares de elementos adyacentes e intercambia si están en el orden incorrecto.
    public static void burbuja(int[] arreglo) {
        for (int i = 0; i < arreglo.length - 1; i++) {
            for (int j = 0; j < arreglo.length - 1 - i; j++) {
                // Si el elemento actual es mayor que el siguiente, los intercambia
                if (arreglo[j] > arreglo[j + 1]) {
                    int temporal = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temporal;
                }
            }
        }
    }

    //QUICK SORT
    // Divide el arreglo usando un "pivote" para separar los menores y mayores.
    public static void quickSort(int[] arreglo, int indiceInicio, int indiceFinal) {
        if (indiceInicio < indiceFinal) {
            int indicePivote = particion(arreglo, indiceInicio, indiceFinal);
            // Ordena la parte izquierda del pivote
            quickSort(arreglo, indiceInicio, indicePivote - 1);
            // Ordena la parte derecha del pivote
            quickSort(arreglo, indicePivote + 1, indiceFinal);
        }
    }

    // Coloca el pivote en su posición final y acomoda los elementos a su alrededor.
    public static int particion(int[] arreglo, int indiceInicio, int indiceFinal) {
        int pivote = arreglo[indiceFinal]; // Elemento de referencia
        int indiceMenor = indiceInicio - 1; // Marca la posición donde van los menores al pivote

        for (int i = indiceInicio; i < indiceFinal; i++) {
            if (arreglo[i] < pivote) {
                indiceMenor++;
                int temporal = arreglo[indiceMenor];
                arreglo[indiceMenor] = arreglo[i];
                arreglo[i] = temporal;
            }
        }

        // Coloca el pivote en su lugar correcto
        int temporal = arreglo[indiceMenor + 1];
        arreglo[indiceMenor + 1] = arreglo[indiceFinal];
        arreglo[indiceFinal] = temporal;

        return indiceMenor + 1; // Devuelve la posición del pivote
    }

    //MERGE SORT
    // Divide el arreglo en mitades y luego las mezcla ordenadas.
    public static void mergeSort(int[] arreglo, int indiceInicio, int indiceFinal) {
        if (indiceInicio < indiceFinal) {
            int indiceMedio = (indiceInicio + indiceFinal) / 2;
            // Ordena primera mitad
            mergeSort(arreglo, indiceInicio, indiceMedio);
            // Ordena segunda mitad
            mergeSort(arreglo, indiceMedio + 1, indiceFinal);
            // Une las dos mitades ya ordenadas
            merge(arreglo, indiceInicio, indiceMedio, indiceFinal);
        }
    }

    // Une dos subarreglos ya ordenados
    public static void merge(int[] arreglo, int indiceInicio, int indiceMedio, int indiceFinal) {
        int tamanioIzquierda = indiceMedio - indiceInicio + 1;
        int tamanioDerecha = indiceFinal - indiceMedio;

        int[] izquierda = new int[tamanioIzquierda];
        int[] derecha = new int[tamanioDerecha];

        // Copia los datos a los subarreglos
        for (int i = 0; i < tamanioIzquierda; i++)
            izquierda[i] = arreglo[indiceInicio + i];
        for (int j = 0; j < tamanioDerecha; j++)
            derecha[j] = arreglo[indiceMedio + 1 + j];

        int indiceIzquierda = 0, indiceDerecha = 0, indiceMezcla = indiceInicio;

        // Mezcla ordenada
        while (indiceIzquierda < tamanioIzquierda && indiceDerecha < tamanioDerecha) {
            if (izquierda[indiceIzquierda] <= derecha[indiceDerecha]) {
                arreglo[indiceMezcla] = izquierda[indiceIzquierda];
                indiceIzquierda++;
            } else {
                arreglo[indiceMezcla] = derecha[indiceDerecha];
                indiceDerecha++;
            }
            indiceMezcla++;
        }

        // Copia los elementos restantes (si quedan)
        while (indiceIzquierda < tamanioIzquierda) {
            arreglo[indiceMezcla++] = izquierda[indiceIzquierda++];
        }
        while (indiceDerecha < tamanioDerecha) {
            arreglo[indiceMezcla++] = derecha[indiceDerecha++];
        }
    }

    //INSERCIÓN
    // Toma cada elemento y lo coloca en la posición correcta moviendo los mayores a la derecha.
    public static void insercion(int[] arreglo) {
        for (int i = 1; i < arreglo.length; i++) {
            int elementoActual = arreglo[i]; // Elemento que se va a insertar
            int indiceAnterior = i - 1;

            // Desplaza los elementos mayores hacia la derecha
            while (indiceAnterior >= 0 && arreglo[indiceAnterior] > elementoActual) {
                arreglo[indiceAnterior + 1] = arreglo[indiceAnterior];
                indiceAnterior--;
            }

            // Coloca el elemento en su posición correcta
            arreglo[indiceAnterior + 1] = elementoActual;
        }
    }

    //SELECCIÓN
    // Busca el elemento más pequeño y lo coloca en la posición correcta cada vez.
    public static void seleccion(int[] arreglo) {
        for (int i = 0; i < arreglo.length - 1; i++) {
            int posicionMinimo = i; // Guarda el índice del número más pequeño

            // Busca el número más pequeño en el resto del arreglo
            for (int j = i + 1; j < arreglo.length; j++) {
                if (arreglo[j] < arreglo[posicionMinimo]) {
                    posicionMinimo = j;
                }
            }

            // Intercambia el número menor encontrado con el de la posición actual
            int temporal = arreglo[i];
            arreglo[i] = arreglo[posicionMinimo];
            arreglo[posicionMinimo] = temporal;
        }
    }

    //Muestra el contenido del arreglo
    public static void mostrarArreglo(int[] arreglo) {
        System.out.print("Arreglo ordenado: ");
        for (int numero : arreglo) {
            System.out.print(numero + " ");
        }
        System.out.println();
    }
}
