package com.example.mongodb.repository;

import com.example.mongodb.domain.Candidato;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CandidatoPersistence extends MongoRepository<Candidato, String> {


}