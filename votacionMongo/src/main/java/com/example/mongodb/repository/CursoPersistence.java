package com.example.mongodb.repository;

import com.example.mongodb.domain.Curso;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CursoPersistence extends MongoRepository<Curso, String> {


}