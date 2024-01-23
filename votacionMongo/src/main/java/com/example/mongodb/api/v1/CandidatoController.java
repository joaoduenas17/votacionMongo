package com.example.mongodb.api.v1;


import com.example.mongodb.domain.Candidato;
import com.example.mongodb.service.CandidatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1.0/candidato")
public class CandidatoController {

    @Autowired
    private CandidatoService candidatoService;

    @PostMapping
    public ResponseEntity<Candidato> create(@RequestBody Candidato candidato) {
        return new ResponseEntity<>(candidatoService.save(candidato), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Candidato>> getAll() {
        List<Candidato> CandidatoEntityList = candidatoService.getAllCandidatos();
        return new ResponseEntity<>(CandidatoEntityList, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Candidato> getById(@PathVariable("id") String id) {
        Candidato candidato = candidatoService.getCandidatoById(id);
        return new ResponseEntity<>(candidato, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Candidato> update(@PathVariable("id") String id, @RequestBody Candidato candidato) {
        Candidato updatedCandidato = candidatoService.updateCandidato(id, candidato);
        return new ResponseEntity<>(updatedCandidato, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id) {
        candidatoService.deleteCandidato(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
