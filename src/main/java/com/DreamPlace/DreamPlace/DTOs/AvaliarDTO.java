package com.DreamPlace.DreamPlace.DTOs;

import com.DreamPlace.DreamPlace.domain.Avaliar;

import java.io.Serializable;

public class AvaliarDTO implements Serializable {
    private Integer id;
    private String nome;
    private String email;
    private String numero;
    private String nota;

    public AvaliarDTO() {
    }
    public AvaliarDTO(Avaliar obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.email = obj.getEmail();
        this.numero = obj.getNumero();
        this.nota = obj.getNota();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }
}
