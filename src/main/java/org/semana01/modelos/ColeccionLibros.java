package main.java.org.semana01.modelos;

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
        int totalPaginas = 0;
        for (int i=0;i<libros.toArray().length;i++){
            totalPaginas = totalPaginas + libros.get(i).getPaginas();
        }
        return totalPaginas;
    }

    public String listarLibrosMasPaginasPromedio() {
        String titulos = "";
        int promedio = sumaTotalPaginas() / libros.toArray().length;
        libros.sort(Comparator.comparingInt(Libro::getPaginas).reversed());
        for (int i = 0; i< libros.toArray().length; i++) {
            if (promedio>= libros.get(i).getPaginas()){
                titulos = titulos + ", " + libros.get(i).getTitulo();
            }
        }
        return titulos;
    }

    public String listarAutores() {
        String autores = "";
        for (int i=0;i<libros.toArray().length;i++){
            if (!autores.contains(libros.get(i).getAutor())){
                autores = autores + ", " + libros.get(i).getAutor();
            }
        }
        return autores;
    }

    public String libroMasPaginas() {
        ArrayList<Libro> librosOrdenadosPaginas =new ArrayList<>(libros);
        librosOrdenadosPaginas.sort(Comparator.comparingInt(Libro::getPaginas).reversed());
        return librosOrdenadosPaginas.get(0).getTitulo();
    }

    public String listarTitulos() {
        String titulos = "";
        for (int i=0;i<libros.toArray().length;i++){
            titulos = titulos + ", " + libros.get(i).getTitulo();
        }
        return titulos;
    }

    // Tuve que utilizar ayuda de la IA para este metodo
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
