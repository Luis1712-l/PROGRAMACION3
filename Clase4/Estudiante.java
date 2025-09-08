package Clase4;
class Estudiante {
    String nombre;
    String matricula;
    double promedio;

    Estudiante(String nombre, String matricula, double promedio) {
        this.nombre = nombre;
        this.matricula = matricula;
        this.promedio = promedio;
    }

    void mostrarInfo() {
        System.out.println(nombre + " - " + matricula + " - Promedio: " + promedio);
    }
}

