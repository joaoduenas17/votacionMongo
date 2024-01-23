package com.example.mongodb.service;

import com.example.mongodb.domain.Candidato;

import java.util.List;

public interface CandidatoService {
    public Candidato save(Candidato candidato);

    List<Candidato> getAllCandidatos();

    Candidato getCandidatoById(String id);

    Candidato updateCandidato(String id, Candidato candidato);

    void deleteCandidato(String id);
}
