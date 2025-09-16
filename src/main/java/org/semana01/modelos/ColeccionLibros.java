package main.java.org.semana01.modelos;

import java.util.ArrayList;

public class ColeccionLibros {
    ArrayList<Libro> libros =new ArrayList<>();
    public void anadirlibro(Libro libro){
        libros.add(libro);
    }

    public int cantidadLibrosMas500Paginas() {
        int cantidad=0;
        for (int i=0;i<libros.toArray().length;i++){
            if (libros.>500){
                cantidad++;
            }
        }
        return cantidad;
    }
    // ¿Qué tipo de colección es la más adecuada para almacenar los libros?

    // Crea los métodos solicitados en el enunciado del ejercicio
}
