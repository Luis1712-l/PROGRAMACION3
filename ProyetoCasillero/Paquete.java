public class Paquete {
    private String destinatario;
    private String fechaIngreso;

    public Paquete(String destinatario, String fechaIngreso) {
        this.destinatario = destinatario;
        this.fechaIngreso = fechaIngreso;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    @Override
    public String toString() {
        return "Destinatario: " + destinatario + ", Fecha de ingreso: " + fechaIngreso;
    }
}
