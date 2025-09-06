import java.util.Scanner;

public class Ejecutar {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        SistemaCasilleros sistema = new SistemaCasilleros(3, 3); // ejemplo 3x3

        boolean activo = true;
        while (activo) {
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Registrar paquete");
            System.out.println("2. Consultar casilleros disponibles");
            System.out.println("3. Información de paquete");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = leer.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Fila: ");
                    int fila = leer.nextInt();
                    System.out.print("Columna: ");
                    int columna = leer.nextInt();
                    leer.nextLine(); // limpiar buffer
                    System.out.print("Destinatario: ");
                    String destinatario = leer.nextLine();
                    System.out.print("Fecha de ingreso: ");
                    String fecha = leer.nextLine();
                    Paquete paquete = new Paquete(destinatario, fecha);
                    if (sistema.asignarPaquete(fila, columna, paquete)) {
                        System.out.println("Paquete asignado correctamente.");
                    } else {
                        System.out.println("Casillero ocupado.");
                    }
                    break;
                case 2:
                    sistema.mostrarCasilleros();
                    break;
                case 3:
                    System.out.print("Fila: ");
                    fila = leer.nextInt();
                    System.out.print("Columna: ");
                    columna = leer.nextInt();
                    sistema.consultarPaquete(fila, columna);
                    break;
                case 4:
                    activo = false;
                    System.out.println("Aplicación cerrada.");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }

        leer.close(); // cerrar el Scanner
    }
}
