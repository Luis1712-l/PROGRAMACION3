public class Paquete {
    private String nombreRemitente;
    private String idRemitente;
    private String direccionRemitente;
    private String nombreDestinatario;
    private String idDestinatario;
    private String direccionDestinatario;
    private String fechaIngreso;

    public Paquete(String nombreRem, String idRem, String dirRem,
            String nombreDest, String idDest, String dirDest,
            String fechaIngreso) {
        this.nombreRemitente = nombreRem;
        this.idRemitente = idRem;
        this.direccionRemitente = dirRem;
        this.nombreDestinatario = nombreDest;
        this.idDestinatario = idDest;
        this.direccionDestinatario = dirDest;
        this.fechaIngreso = fechaIngreso;
    }

    public String toString() {
        return "Fecha de ingreso: " + fechaIngreso + "\n" +
                "Remitente: " + nombreRemitente + " (ID: " + idRemitente + ", Dirección: " + direccionRemitente + ")\n"
                +
                "Destinatario: " + nombreDestinatario + " (ID: " + idDestinatario + ", Dirección: "
                + direccionDestinatario + ")";
    }

    public void mostrarInformacion() {
        System.out.println("Fecha de ingreso: " + fechaIngreso);
        System.out.println(
                "Remitente: " + nombreRemitente + " (ID: " + idRemitente + ", Dirección: " + direccionRemitente + ")");
        System.out.println("Destinatario: " + nombreDestinatario + " (ID: " + idDestinatario + ", Dirección: "
                + direccionDestinatario + ")");
    }
}
