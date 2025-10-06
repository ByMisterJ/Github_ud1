package org.semana01.modelos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class ColeccionLibros {
    ArrayList<Libro> libros =new ArrayList<>();

    public void anadirlibro(Libro libro){
        libros.add(libro);
    }

    public int cantidadLibrosMas500Paginas() {
        int cantidad = (int) libros.stream()
                .filter (libro -> libro.getPaginas() > 500)
                .count();
        return cantidad;
    }

    public int cantidadLibrosMenos300Paginas() {
        int cantidad = (int) libros.stream()
                .filter (libro -> libro.getPaginas() < 300)
                .count();
        return cantidad;
    }

    public String listarLibrosMas500Paginas() {
        return libros.stream()
                .filter(libro -> libro.getPaginas() > 500)
                .map(Libro::getTitulo)
                .collect(Collectors.joining(", "));
    }

    public String listarTresLibrosMasPaginas() {
        return libros.stream()
                .sorted(Comparator.comparingInt(Libro::getPaginas).reversed())
                .limit(3)
                .map(Libro::getTitulo)
                .collect(Collectors.joining(", "));
    }

    public int sumaTotalPaginas() {
        return libros.stream()
                .mapToInt(Libro::getPaginas)
                .sum();
    }

    public String listarLibrosMasPaginasPromedio() {
        double promedio = libros.stream()
                .mapToInt(Libro::getPaginas)
                .average()
                .orElse(0);

        return libros.stream()
                .filter(libro -> libro.getPaginas() >= promedio)
                .sorted(Comparator.comparingInt(Libro::getPaginas).reversed())
                .map(Libro::getTitulo)
                .collect(Collectors.joining(", "));
    }

    public String listarAutores() {
        return libros.stream()
                .map(Libro::getAutor)
                .distinct()
                .collect(Collectors.joining(", "));
    }

    public String libroMasPaginas() {
        return libros.stream()
                .max(Comparator.comparingInt(Libro::getPaginas))
                .map(Libro::getTitulo)
                .orElse("No hay libros");
    }

    public String listarTitulos() {
        return libros.stream()
                .map(Libro::getTitulo)
                .collect(Collectors.joining(", "));
    }



    public String listarAutoresConMasDeUnLibro() {
            return libros.stream()
                .collect(Collectors.groupingBy(Libro::getAutor))
                .entrySet().stream()
                .filter(entry -> entry.getValue().size() > 1)
                .map(entry -> entry.getKey())
                .collect(Collectors.joining(", "));
        }


    // ¿Qué tipo de colección es la más adecuada para almacenar los libros?

    // Crea los métodos solicitados en el enunciado del ejercicio
}
