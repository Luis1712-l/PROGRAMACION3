package Clase4;

public class Main {
    public static void main(String[] args) {
        Vehiculo[] autos = new Vehiculo[3];

        autos[0] = new Vehiculo("Toyota", 2020);
        autos[1] = new Vehiculo("Honda", 2018);
        autos[2] = new Vehiculo("Ford", 2022);

        for (Vehiculo auto : autos) {
            auto.mostrarInfo();
        }
    }
}

