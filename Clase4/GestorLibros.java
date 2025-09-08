package Clase4;

class GestorLibros {

    static void ordenarPorPrecio(Libro[] libros) {
        for (int i = 0; i < libros.length - 1; i++) {
            for (int j = 0; j < libros.length - i - 1; j++) 
                if (libros[j].getPrecio() > libros[j + 1].getPrecio()) {
                    Libro temp = libros[j];
                    libros[j] = libros[j + 1];
                    libros[j + 1] = temp;
                }
            }
        }
    void actualizarPrecio(Libro[] libros, String titulo, double nuevoPrecio) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equals(titulo)) {
                libro.setPrecio(nuevoPrecio);
            }
        }
    }

    static Libro buscarPorTitulo(Libro[] libros, String titulo) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equals(titulo)) {
                return libro;
            }
        }
        return null;
    }
}

