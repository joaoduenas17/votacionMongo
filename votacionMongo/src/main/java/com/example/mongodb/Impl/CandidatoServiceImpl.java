package com.example.mongodb.Impl;
import com.example.mongodb.domain.Candidato;
import com.example.mongodb.repository.CandidatoPersistence;
import com.example.mongodb.service.CandidatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class CandidatoServiceImpl implements CandidatoService {
    @Autowired
    private CandidatoPersistence candidatoRepo;

    @Override
    public Candidato save(Candidato candidato) {
        return candidatoRepo.save(candidato);
    }

    @Override
    public List<Candidato> getAllCandidatos() {
        return candidatoRepo.findAll();
    }

    @Override
    public Candidato getCandidatoById(String id) {
        Optional<Candidato> candidato = candidatoRepo.findById(id);
        return candidato.orElse(null);
    }

    @Override
    public Candidato updateCandidato(String id, Candidato updatedCandidato) {
        Optional<Candidato> existingCandidato = candidatoRepo.findById(id);

        if (existingCandidato.isPresent()) {
            Candidato candidato = existingCandidato.get();
            candidato.setLista(updatedCandidato.getLista());
            candidato.setNombre_candidato(updatedCandidato.getNombre_candidato());
            return candidatoRepo.save(candidato);
        } else {
            return null;
        }
    }

    @Override
    public void deleteCandidato(String id) {
        candidatoRepo.deleteById(id);
    }

}
