package com.example.mongodb.repository;


import com.example.mongodb.domain.Mesa;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MesaPersistence extends MongoRepository<Mesa, String> {


}