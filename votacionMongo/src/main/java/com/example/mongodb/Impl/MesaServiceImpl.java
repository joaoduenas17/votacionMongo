package com.example.mongodb.Impl;
import com.example.mongodb.domain.Mesa;
import com.example.mongodb.repository.MesaPersistence;
import com.example.mongodb.service.MesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class MesaServiceImpl implements MesaService {
    @Autowired
    private MesaPersistence mesaRepo;

    @Override
    public Mesa save(Mesa mesa) {
        return mesaRepo.save(mesa);
    }

    @Override
    public List<Mesa> getAllMesas() {
        return mesaRepo.findAll();
    }

    @Override
    public Mesa getMesaById(String id) {
        Optional<Mesa> mesa = mesaRepo.findById(id);
        return mesa.orElse(null);
    }

    @Override
    public Mesa updateMesa(String id, Mesa updatedMesa) {
        Optional<Mesa> existingMesa = mesaRepo.findById(id);

        if (existingMesa.isPresent()) {
            Mesa mesa = existingMesa.get();
            mesa.setCurso(updatedMesa.getCurso());
            return mesaRepo.save(mesa);
        } else {
            return null;
        }
    }

    @Override
    public void deleteMesa(String id) {
        mesaRepo.deleteById(id);
    }

}
