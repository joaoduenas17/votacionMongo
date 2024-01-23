package com.example.mongodb.api.v1;

import com.example.mongodb.domain.Curso;
import com.example.mongodb.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1.0/curso")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @PostMapping
    public ResponseEntity<Curso> create(@RequestBody Curso curso) {
        return new ResponseEntity<>(cursoService.save(curso), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Curso>> getAll() {
        List<Curso> cursoEntityList = cursoService.getAllCursos();
        return new ResponseEntity<>(cursoEntityList, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Curso> getById(@PathVariable("id") String id) {
        Curso curso = cursoService.getCursoById(id);
        return new ResponseEntity<>(curso, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curso> update(@PathVariable("id") String id, @RequestBody Curso curso) {
        Curso updatedCurso = cursoService.updateCurso(id, curso);
        return new ResponseEntity<>(updatedCurso, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id) {
        cursoService.deleteCurso(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
