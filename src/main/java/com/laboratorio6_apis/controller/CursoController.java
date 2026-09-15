package com.laboratorio6_apis.controller;

import com.laboratorio6_apis.model.Curso;
import com.laboratorio6_apis.service.CursoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @PostMapping
    public ResponseEntity<Curso> crearCurso(@RequestBody Curso curso) {
        Curso nuevoCurso = cursoService.crearCurso(curso);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoCurso);
    }

    @GetMapping
    public ResponseEntity<List<Curso>> consultarCursos() {
        return ResponseEntity.ok(
                cursoService.consultarCursos()
        );
    }

    @GetMapping("/buscar")
    public ResponseEntity<Curso> consultarPorCodigo(
            @RequestParam String codigo) {

        Curso curso = cursoService.consultarPorCodigo(codigo);

        if (curso != null) {
            return ResponseEntity.ok(curso);
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curso> actualizarCurso(
            @PathVariable Long id,
            @RequestBody Curso datos) {

        Curso cursoActualizado =
                cursoService.actualizarCurso(id, datos);

        if (cursoActualizado != null) {
            return ResponseEntity.ok(cursoActualizado);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCurso(
            @PathVariable Long id) {

        boolean eliminado =
                cursoService.eliminarCurso(id);

        if (eliminado) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}