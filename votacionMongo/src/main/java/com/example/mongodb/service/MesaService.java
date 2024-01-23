package com.example.mongodb.service;

import com.example.mongodb.domain.Mesa;



import java.util.List;

public interface MesaService {
    public Mesa save(Mesa mesa);

    List<Mesa> getAllMesas();


    Mesa getMesaById(String id);

    Mesa updateMesa(String id, Mesa mesa);

    void deleteMesa(String id);
}
