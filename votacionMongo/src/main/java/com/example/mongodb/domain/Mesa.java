package com.example.mongodb.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "mesa")
public class Mesa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String id;

    private Curso curso;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}