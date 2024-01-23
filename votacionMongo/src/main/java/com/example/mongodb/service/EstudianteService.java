package com.example.mongodb.service;

import com.example.mongodb.domain.Estudiante;

import java.util.List;

public interface EstudianteService {
    public Estudiante save(Estudiante estudiante);

    List<Estudiante> getAllEstudiantes();

    List<Estudiante> getByCurso(String curso);

    Estudiante getEstudianteById(String id);

    Estudiante updateEstudiante(String id, Estudiante estudiante);

    void deleteEstudiante(String id);
}
