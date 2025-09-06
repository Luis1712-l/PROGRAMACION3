public class SistemaCasilleros {
    private Casillero[][] casilleros;

    public SistemaCasilleros(int filas, int columnas) {
        casilleros = new Casillero[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                casilleros[i][j] = new Casillero();
            }
        }
    }

    public boolean asignarPaquete(int fila, int columna, Paquete paquete) {
        if (casilleros[fila][columna].estaDisponible()) {
            casilleros[fila][columna].asignarPaquete(paquete);
            return true;
        }
        return false;
    }

    public void mostrarCasilleros() {
        for (int i = 0; i < casilleros.length; i++) {
            for (int j = 0; j < casilleros[i].length; j++) {
                System.out.print(casilleros[i][j].estaDisponible() ? "[ ] " : "[X] ");
            }
            System.out.println();
        }
    }

    public void consultarPaquete(int fila, int columna) {
        Paquete paquete = casilleros[fila][columna].getPaquete();
        if (paquete != null) {
            System.out.println(paquete);
        } else {
            System.out.println("Casillero vacío.");
        }
    }
}
