package com.example.mongodb.Impl;

import com.example.mongodb.domain.Pais;
import com.example.mongodb.repository.PaisPersistence;

import com.example.mongodb.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PaisServiceImpl implements PaisService {
	@Autowired
	private PaisPersistence paisRepo;

	@Override
	public Pais save(Pais pais) {
		return paisRepo.save(pais);
	}

	@Override
	public List<Pais> getAllPais() {
		return paisRepo.findAll();
	}

	@Override
	public List<Pais> searchPais(String name) {
		return paisRepo.findByName(name);
	}

}
