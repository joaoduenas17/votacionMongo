package com.example.mongodb.api.v1;


import com.example.mongodb.domain.Voto;
import com.example.mongodb.service.VotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1.0/voto")
public class VotoController {

    @Autowired
    private VotoService votoService;

    @PostMapping
    public ResponseEntity<Voto> create(@RequestBody Voto voto) {
        return new ResponseEntity<>(votoService.save(voto), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Voto>> getAll() {
        List<Voto> VotoEntityList = votoService.getAllVotos();
        return new ResponseEntity<>(VotoEntityList, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Voto> getById(@PathVariable("id") String id) {
        Voto voto = votoService.getVotoById(id);
        return new ResponseEntity<>(voto, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Voto> update(@PathVariable("id") String id, @RequestBody Voto voto) {
        Voto updatedVoto = votoService.updateVoto(id, voto);
        return new ResponseEntity<>(updatedVoto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id) {
        votoService.deleteVoto(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/votosGenerales")
    public ResponseEntity<List<Object[]>> obtenerVotosGenerales() {
        List<Object[]> votosGenerales = votoService.obtenerVotosGenerales();
        return ResponseEntity.ok(votosGenerales);
    }
}