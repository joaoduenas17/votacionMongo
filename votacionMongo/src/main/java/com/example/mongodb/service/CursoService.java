package com.example.mongodb.service;

import com.example.mongodb.domain.Curso;

import java.util.List;

public interface CursoService {
    public Curso save(Curso curso);

    List<Curso> getAllCursos();


    Curso getCursoById(String id);

    Curso updateCurso(String id, Curso curso);

    void deleteCurso(String id);
}
