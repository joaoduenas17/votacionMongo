package com.example.mongodb.api.v1;

import com.example.mongodb.domain.Curso;
import com.example.mongodb.domain.Estudiante;
import com.example.mongodb.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1.0/estudiante")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    @PostMapping
    public ResponseEntity<Estudiante> create(@RequestBody Estudiante Estudiante) {
        return new ResponseEntity<>(estudianteService.save(Estudiante), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Estudiante>> getAll() {
        List<Estudiante> EstudianteEntityList = estudianteService.getAllEstudiantes();
        return new ResponseEntity<>(EstudianteEntityList, HttpStatus.OK);
    }

    @GetMapping("/por-curso")
    public ResponseEntity<List<Estudiante>> getByCurso(
            @RequestParam(name = "nombre_curso") String nombreCurso) {

        if (nombreCurso != null) {
            List<Estudiante> estudiantes = estudianteService.getByCurso(nombreCurso);
            return new ResponseEntity<>(estudiantes, HttpStatus.OK);
        } else {
            List<Estudiante> estudiantes = estudianteService.getAllEstudiantes();
            return new ResponseEntity<>(estudiantes, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estudiante> getById(@PathVariable("id") String id) {
        Estudiante estudiante = estudianteService.getEstudianteById(id);
        return new ResponseEntity<>(estudiante, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estudiante> update(@PathVariable("id") String id, @RequestBody Estudiante estudiante) {
        Estudiante updatedEstudiante = estudianteService.updateEstudiante(id, estudiante);
        return new ResponseEntity<>(updatedEstudiante, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id) {
        estudianteService.deleteEstudiante(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
