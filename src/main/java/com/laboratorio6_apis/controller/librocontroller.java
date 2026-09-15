package com.laboratorio6_apis.controller;

import com.laboratorio6_apis.model.libro;
import com.laboratorio6_apis.service.libroservice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libros")
public class librocontroller {

    private final libroservice libroservice;

    public librocontroller(libroservice libroservice) {
        this.libroservice = libroservice;
    }

    // POST - Registrar libro
    @PostMapping
    public ResponseEntity<libro> registrarLibro(@RequestBody libro libro) {

        libro nuevoLibro = libroservice.registrarLibro(libro);

        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoLibro);
    }

    // GET - Consultar libros
    @GetMapping
    public ResponseEntity<List<libro>> consultarLibros() {

        return ResponseEntity.ok(
                libroservice.consultarLibros()
        );
    }

    // GET - Consultar por título
    @GetMapping("/buscar")
    public ResponseEntity<List<libro>> consultarPorTitulo(
            @RequestParam String titulo) {

        return ResponseEntity.ok(
                libroservice.consultarPorTitulo(titulo)
        );
    }

    // GET - Consultar por ID
    @GetMapping("/{id}")
    public ResponseEntity<libro> consultarPorId(
            @PathVariable Long id) {

        libro libro = libroservice.consultarPorId(id);

        if (libro != null) {
            return ResponseEntity.ok(libro);
        }

        return ResponseEntity.notFound().build();
    }

    // PUT - Actualizar libro
    @PutMapping("/{id}")
    public ResponseEntity<libro> actualizarLibro(
            @PathVariable Long id,
            @RequestBody libro datos) {

        libro libroActualizado =
                libroservice.actualizarLibro(id, datos);

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
                libroservice.eliminarLibro(id);

        if (eliminado) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}