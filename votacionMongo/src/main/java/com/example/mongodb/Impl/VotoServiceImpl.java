package com.example.mongodb.Impl;
import com.example.mongodb.domain.Voto;
import com.example.mongodb.repository.VotoPersistence;
import com.example.mongodb.service.VotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class VotoServiceImpl implements VotoService {
    @Autowired
    private VotoPersistence votoRepo;

    @Override
    public Voto save(Voto voto) {
        return votoRepo.save(voto);
    }

    @Override
    public List<Voto> getAllVotos() {
        return votoRepo.findAll();
    }

    @Override
    public Voto getVotoById(String id) {
        Optional<Voto> voto = votoRepo.findById(id);
        return voto.orElse(null);
    }

    @Override
    public Voto updateVoto(String id, Voto updatedVoto) {
        Optional<Voto> existingVoto = votoRepo.findById(id);

        if (existingVoto.isPresent()) {
            Voto voto = existingVoto.get();
            voto.setEstudiante(updatedVoto.getEstudiante());
            voto.setCandidato(updatedVoto.getCandidato());
            voto.setMesa(updatedVoto.getMesa());
            return votoRepo.save(voto);
        } else {
            return null;
        }
    }

    @Override
    public void deleteVoto(String id) {
        votoRepo.deleteById(id);
    }

    @Override
    public List<Object[]> obtenerVotosGenerales() {
        return votoRepo.obtenerVotosGenerales();
    }

}
