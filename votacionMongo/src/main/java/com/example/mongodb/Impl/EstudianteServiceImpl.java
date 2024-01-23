package com.example.mongodb.Impl;
import com.example.mongodb.domain.Estudiante;
import com.example.mongodb.repository.EstudiantePersistence;
import com.example.mongodb.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class EstudianteServiceImpl implements EstudianteService {
    @Autowired
    private EstudiantePersistence estudianteRepo;

    @Override
    public Estudiante save(Estudiante estudiante) {
        return estudianteRepo.save(estudiante);
    }

    @Override
    public List<Estudiante> getAllEstudiantes() {
        return estudianteRepo.findAll();
    }

    @Override
    public List<Estudiante> getByCurso(String curso) {
        return estudianteRepo.findByIdCurso(curso);
    }
    @Override
    public Estudiante getEstudianteById(String id) {
        Optional<Estudiante> estudiante = estudianteRepo.findById(id);
        return estudiante.orElse(null);
    }

    @Override
    public Estudiante updateEstudiante(String id, Estudiante updatedEstudiante) {
        Optional<Estudiante> existingEstudiante = estudianteRepo.findById(id);

        if (existingEstudiante.isPresent()) {
            Estudiante estudiante = existingEstudiante.get();
            estudiante.setNombre_completo(updatedEstudiante.getNombre_completo());
            estudiante.setCurso(updatedEstudiante.getCurso());
            estudiante.setParalelo(updatedEstudiante.getParalelo());
            estudiante.setAsistencia(updatedEstudiante.getAsistencia());
            return estudianteRepo.save(estudiante);
        } else {
            return null;
        }
    }

    @Override
    public void deleteEstudiante(String id) {
        estudianteRepo.deleteById(id);
    }

}
