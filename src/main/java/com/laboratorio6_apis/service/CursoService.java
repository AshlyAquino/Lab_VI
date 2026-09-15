package com.laboratorio6_apis.service;

import com.laboratorio6_apis.model.Curso;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CursoService {

    private List<Curso> cursos = new ArrayList<>();

    private Long siguienteId = 1L;

    // Crear curso
    public Curso crearCurso(Curso curso) {
        curso.setId(siguienteId);
        siguienteId++;

        cursos.add(curso);

        return curso;
    }

    // Consultar todos los cursos
    public List<Curso> consultarCursos() {
        return cursos;
    }

    // Consultar curso por código
    public Curso consultarPorCodigo(String codigo) {

        for (Curso curso : cursos) {

            if (curso.getCodigo().equalsIgnoreCase(codigo)) {
                return curso;
            }
        }

        return null;
    }

    // Consultar curso por ID
    public Curso consultarPorId(Long id) {

        for (Curso curso : cursos) {

            if (curso.getId().equals(id)) {
                return curso;
            }
        }

        return null;
    }

    // Actualizar curso
    public Curso actualizarCurso(Long id, Curso datos) {

        Curso curso = consultarPorId(id);

        if (curso != null) {

            curso.setNombre(datos.getNombre());
            curso.setCodigo(datos.getCodigo());
            curso.setCreditos(datos.getCreditos());
            curso.setEstado(datos.getEstado());

            return curso;
        }

        return null;
    }

    // Eliminar curso
    public boolean eliminarCurso(Long id) {

        Curso curso = consultarPorId(id);

        if (curso != null) {

            cursos.remove(curso);
            return true;
        }

        return false;
    }
}