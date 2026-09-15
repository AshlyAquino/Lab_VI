package com.laboratorio6_apis.service;

import com.laboratorio6_apis.model.Libro;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LibroService {

    private List<Libro> libros = new ArrayList<>();

    private Long siguienteId = 1L;

    // Registrar libro
    public Libro registrarLibro(Libro libro) {

        libro.setId(siguienteId);
        siguienteId++;

        libros.add(libro);

        return libro;
    }

    // Consultar libros
    public List<Libro> consultarLibros() {
        return libros;
    }

    // Consultar por título
    public List<Libro> consultarPorTitulo(String titulo) {

        List<Libro> resultados = new ArrayList<>();

        for (Libro libro : libros) {

            if (libro.getTitulo()
                    .toLowerCase()
                    .contains(titulo.toLowerCase())) {

                resultados.add(libro);
            }
        }

        return resultados;
    }

    // Consultar por ID
    public Libro consultarPorId(Long id) {

        for (Libro libro : libros) {

            if (libro.getId().equals(id)) {
                return libro;
            }
        }

        return null;
    }

    // Actualizar libro
    public Libro actualizarLibro(Long id, Libro datos) {

        Libro libro = consultarPorId(id);

        if (libro != null) {

            libro.setTitulo(datos.getTitulo());
            libro.setAutor(datos.getAutor());
            libro.setIsbn(datos.getIsbn());
            libro.setAnioPublicacion(datos.getAnioPublicacion());
            libro.setEstado(datos.getEstado());

            return libro;
        }

        return null;
    }

    // Eliminar libro
    public boolean eliminarLibro(Long id) {

        Libro libro = consultarPorId(id);

        if (libro != null) {

            libros.remove(libro);

            return true;
        }

        return false;
    }
}