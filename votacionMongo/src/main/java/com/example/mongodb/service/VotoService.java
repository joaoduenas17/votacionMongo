package com.example.mongodb.service;

import com.example.mongodb.domain.Voto;



import java.util.List;

public interface VotoService {
    public Voto save(Voto voto);

    List<Voto> getAllVotos();


    Voto getVotoById(String id);

    Voto updateVoto(String id, Voto voto);

    void deleteVoto(String id);
    List<Object[]> obtenerVotosGenerales();
}
