public class Casillero {
    private Paquete paquete;

    public boolean estaDisponible() {
        return paquete == null;
    }

    public void asignarPaquete(Paquete paquete) {
        this.paquete = paquete;
    }

    public Paquete getPaquete() {
        return paquete;
    }

    public void liberar() {
        paquete = null;
    }
}
