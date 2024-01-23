package com.example.mongodb.repository;

import com.example.mongodb.domain.Curso;
import com.example.mongodb.domain.Estudiante;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface EstudiantePersistence extends MongoRepository<Estudiante, String> {

    @Query("{ 'curso' : ?0 }")
    List<Estudiante> findByIdCurso(String curso);

}