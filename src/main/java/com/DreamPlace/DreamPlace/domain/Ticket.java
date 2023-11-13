package com.DreamPlace.DreamPlace.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class Ticket implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message= "Campo NOME requerido!")
    @Length(min = 3, max = 100, message = "O campo nome deve ter entre 3 e 100 caracteres.")
    private String nome;
    @NotEmpty(message= "Campo CPF requerido!")
    @Length(min = 11, max = 11, message = "O campo CPF deve ter 11 caracteres.")
    private String cpf;
    @NotEmpty(message= "Campo TEXTO requerido!")
    @Length(min = 3, max = 1500, message = "O campo TEXTO deve ter entre 3 e 1.500 caracteres.")
    private String ticket;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "cadastro_id")
    private Cadastro cadastro;

    public Ticket() {
    }

    public Ticket(Integer id,String nome, String cpf, String ticket, Cadastro cadastro) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.ticket = ticket;
        this.cadastro = cadastro;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public Cadastro getCadastro() {
        return cadastro;
    }

    public void setCadastro(Cadastro cadastro) {
        this.cadastro = cadastro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(id, ticket.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
