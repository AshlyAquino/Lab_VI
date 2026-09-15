package com.laboratorio6_apis.service;

import com.laboratorio6_apis.model.libro;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class libroservice {

    private List<libro> libros = new ArrayList<>();

    private Long siguienteId = 1L;

    // Registrar libro
    public libro registrarLibro(libro libro) {

        libro.setId(siguienteId);
        siguienteId++;

        libros.add(libro);

        return libro;
    }

    // Consultar libros
    public List<libro> consultarLibros() {
        return libros;
    }

    // Consultar por título
    public List<libro> consultarPorTitulo(String titulo) {

        List<libro> resultados = new ArrayList<>();

        for (libro libro : libros) {

            if (libro.getTitulo()
                    .toLowerCase()
                    .contains(titulo.toLowerCase())) {

                resultados.add(libro);
            }
        }

        return resultados;
    }

    // Consultar por ID
    public libro consultarPorId(Long id) {

        for (libro libro : libros) {

            if (libro.getId().equals(id)) {
                return libro;
            }
        }

        return null;
    }

    // Actualizar libro
    public libro actualizarLibro(Long id, libro datos) {

        libro libro = consultarPorId(id);

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

        libro libro = consultarPorId(id);

        if (libro != null) {

            libros.remove(libro);

            return true;
        }

        return false;
    }
}