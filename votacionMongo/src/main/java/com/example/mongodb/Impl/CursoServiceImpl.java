package com.example.mongodb.Impl;
import com.example.mongodb.domain.Curso;
import com.example.mongodb.repository.CursoPersistence;
import com.example.mongodb.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class CursoServiceImpl implements CursoService {
    @Autowired
    private CursoPersistence cursoRepo;

    @Override
    public Curso save(Curso curso) {
        return cursoRepo.save(curso);
    }

    @Override
    public List<Curso> getAllCursos() {
        return cursoRepo.findAll();
    }

    @Override
    public Curso getCursoById(String id) {
        Optional<Curso> curso = cursoRepo.findById(id);
        return curso.orElse(null);
    }

    @Override
    public Curso updateCurso(String id, Curso updatedCurso) {
        Optional<Curso> existingCurso = cursoRepo.findById(id);

        if (existingCurso.isPresent()) {
            Curso curso = existingCurso.get();
            curso.setNombre_curso(updatedCurso.getNombre_curso());
            return cursoRepo.save(curso);
        } else {
            return null;
        }
    }

    @Override
    public void deleteCurso(String id) {
        cursoRepo.deleteById(id);
    }

}
