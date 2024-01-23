package com.example.mongodb.api.v1;


import com.example.mongodb.domain.Mesa;
import com.example.mongodb.service.MesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1.0/mesa")
public class MesaController {

    @Autowired
    private MesaService mesaService;

    @PostMapping
    public ResponseEntity<Mesa> create(@RequestBody Mesa mesa) {
        return new ResponseEntity<>(mesaService.save(mesa), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Mesa>> getAll() {
        List<Mesa> mesaEntityList = mesaService.getAllMesas();
        return new ResponseEntity<>(mesaEntityList, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Mesa> getById(@PathVariable("id") String id) {
        Mesa mesa = mesaService.getMesaById(id);
        return new ResponseEntity<>(mesa, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mesa> update(@PathVariable("id") String id, @RequestBody Mesa mesa) {
        Mesa updatedMesa = mesaService.updateMesa(id, mesa);
        return new ResponseEntity<>(updatedMesa, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id) {
        mesaService.deleteMesa(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}