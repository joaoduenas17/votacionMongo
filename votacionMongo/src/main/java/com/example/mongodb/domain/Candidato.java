package com.example.mongodb.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.io.Serializable;

@Document(collection = "candidato")
public class Candidato implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String id;

    private String lista;

    private String nombre_candidato;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLista() {
        return lista;
    }

    public void setLista(String lista) {
        this.lista = lista;
    }

    public String getNombre_candidato() {
        return nombre_candidato;
    }

    public void setNombre_candidato(String nombre_candidato) {
        this.nombre_candidato = nombre_candidato;
    }
}