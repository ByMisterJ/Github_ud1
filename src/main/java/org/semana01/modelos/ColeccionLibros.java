package main.java.org.semana01.modelos;

import java.util.ArrayList;
import java.util.Comparator;

public class ColeccionLibros {
    ArrayList<Libro> libros =new ArrayList<>();

    public void anadirlibro(Libro libro){
        libros.add(libro);
    }

    public int cantidadLibrosMas500Paginas() {
        int cantidad=0;
        for (int i=0;i<libros.toArray().length;i++){
            if (libros.get(i).getPaginas()>500){
                cantidad++;
            }
        }
        return cantidad;
    }

    public int cantidadLibrosMenos300Paginas() {
        int cantidad=0;
        for (int i=0;i<libros.toArray().length;i++){
            if (libros.get(i).getPaginas()<300){
                cantidad++;
            }
        }
        return cantidad;
    }

    public String listarLibrosMas500Paginas() {
        String titulos = "";
        for (int i=0;i<libros.toArray().length;i++){
            if (libros.get(i).getPaginas()>500){
                titulos = titulos + ", " + libros.get(i).getTitulo();
            }
        }
        return titulos;
    }

    public String listarTresLibrosMasPaginas() {
        String titulos = "";
        ArrayList<Libro> librosOrdenadosPaginas =new ArrayList<>(libros);
        librosOrdenadosPaginas.sort(Comparator.comparingInt(Libro::getPaginas).reversed());
        for (int i = 0; i< librosOrdenadosPaginas.toArray().length; i++) {
            if (i<3){
                titulos = titulos + ", " + librosOrdenadosPaginas.get(i).getTitulo();
            }
        }
        return titulos;
    }
    // ¿Qué tipo de colección es la más adecuada para almacenar los libros?

    // Crea los métodos solicitados en el enunciado del ejercicio
}
