package Clase4;

public class EjecutarLibro {
    public static void main(String[] args) {
        Libro[] libros = new Libro[5];

        libros[0] = new Libro("Cien años de soledad", "Gabriel García Márquez", 25990);
        libros[1] = new Libro("Don Quijote de la Mancha", "Miguel de Cervantes", 19500);
        libros[2] = new Libro("El Principito", "Antoine de Saint-Exupéry", 15750);
        libros[3] = new Libro("Rayuela", "Julio Cortázar", 22300);
        libros[4] = new Libro("Ficciones", "Jorge Luis Borges", 18400);

        System.out.println("Listado de libros:");
        for (Libro libro : libros) {
            libro.mostrarInfo();
        }

        double precioTotal = 0;
        for (Libro libro : libros) {
            precioTotal += libro.getPrecio();
        }
        System.out.println("\nPrecio total: $" + precioTotal);

        System.out.println("\nLibros con precio mayor a $20,000:");
        for (Libro libro : libros) {
            if (libro.getPrecio() > 20000) {
                libro.mostrarInfo();
            }
        }

        GestorLibros.ordenarPorPrecio(libros);
        System.out.println("\nLibros ordenados por precio (menor a mayor):");
        for (Libro libro : libros) {
            libro.mostrarInfo();
        }

        GestorLibros gestorLibros = new GestorLibros();
        gestorLibros.actualizarPrecio(libros, "El Principito", 18000);
        System.out.println("\nDespués de actualizar precio de 'El Principito':");
        for (Libro libro : libros) {
            libro.mostrarInfo();
        }

        Libro encontrado = GestorLibros.buscarPorTitulo(libros, "Rayuela");
        if (encontrado != null) {
            System.out.println("\nLibro encontrado:");
            encontrado.mostrarInfo();
        } else {
            System.out.println("\nLibro no encontrado.");
        }
    }
}
