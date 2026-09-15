package com.laboratorio6_apis.controller;

import com.laboratorio6_apis.model.Libro;
import com.laboratorio6_apis.service.LibroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libros")
public class LibroController {

    private final LibroService libroService;

    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    // POST - Registrar libro
    @PostMapping
    public ResponseEntity<Libro> registrarLibro(@RequestBody Libro libro) {

        Libro nuevoLibro = libroService.registrarLibro(libro);

        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoLibro);
    }

    // GET - Consultar libros
    @GetMapping
    public ResponseEntity<List<Libro>> consultarLibros() {

        return ResponseEntity.ok(
                libroService.consultarLibros()
        );
    }

    // GET - Consultar por título
    @GetMapping("/buscar")
    public ResponseEntity<List<Libro>> consultarPorTitulo(
            @RequestParam String titulo) {

        return ResponseEntity.ok(
                libroService.consultarPorTitulo(titulo)
        );
    }

    // GET - Consultar por ID
    @GetMapping("/{id}")
    public ResponseEntity<Libro> consultarPorId(
            @PathVariable Long id) {

        Libro libro = libroService.consultarPorId(id);

        if (libro != null) {
            return ResponseEntity.ok(libro);
        }

        return ResponseEntity.notFound().build();
    }

    // PUT - Actualizar libro
    @PutMapping("/{id}")
    public ResponseEntity<Libro> actualizarLibro(
            @PathVariable Long id,
            @RequestBody Libro datos) {

        Libro libroActualizado =
                libroService.actualizarLibro(id, datos);

        if (libroActualizado != null) {
            return ResponseEntity.ok(libroActualizado);
        }

        return ResponseEntity.notFound().build();
    }

    // DELETE - Eliminar libro
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarLibro(
            @PathVariable Long id) {

        boolean eliminado =
                libroService.eliminarLibro(id);

        if (eliminado) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}