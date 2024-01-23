package com.example.mongodb.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.io.Serializable;

@Document(collection = "voto")
public class Voto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String id;

    private Estudiante estudiante;

    private Candidato candidato;

    private Mesa mesa;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }
}