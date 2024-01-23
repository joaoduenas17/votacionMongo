package com.example.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.mongodb.domain.Pais;

import java.util.List;

public interface PaisPersistence extends MongoRepository<Pais, Long> {

	List<Pais> findByName(String name);
}
