package com.DreamPlace.DreamPlace.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class Avaliar implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message= "Campo NOME requerido!")
    @Length(min = 3, max = 100, message = "O campo nome deve ter entre 3 e 100 caracteres.")
    private String nome;
    @NotEmpty(message= "Campo EMAIL requerido!")
    @Length(min = 3, max = 100, message = "O campo EMAIL deve ter entre 3 e 100 caracteres.")
    private String email;
    @NotEmpty(message= "Campo numero requerido!")
    @Length(min = 11, max = 11, message = "Digite um NÚMERO válido.")
    private String numero;
    private String nota;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "cadastro_id")
    private Cadastro cadastro;

    public Avaliar() {
    }

    public Avaliar(Integer id, String nome, String email, String numero, String nota, Cadastro cadastro) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.numero = numero;
        this.nota = nota;
        this.cadastro = cadastro;
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

    public Cadastro getCadastro() {
        return cadastro;
    }

    public void setCadastro(Cadastro cadastro) {
        this.cadastro = cadastro;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Avaliar avaliar = (Avaliar) o;
        return Objects.equals(id, avaliar.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
