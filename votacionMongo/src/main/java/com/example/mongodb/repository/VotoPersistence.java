package com.example.mongodb.repository;


import com.example.mongodb.domain.Voto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface VotoPersistence extends MongoRepository<Voto, String> {

    @Query(value = "{'candidato': { $ne: null } }", fields = "{'candidato': 1, '_id': 0}")
    List<Object[]> obtenerVotosGenerales();
}