package Clase4;

class Vehiculo {
    String marca;
    int year;

    Vehiculo(String marca, int year) {
        this.marca = marca;
        this.year = year;
    }

    void mostrarInfo() {
        System.out.println("Marca: " + marca + ", Año: " + year);
    }
}

