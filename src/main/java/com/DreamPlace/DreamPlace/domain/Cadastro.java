package com.DreamPlace.DreamPlace.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Cadastro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message= "Campo NOME requerido!")
    @Length(min = 3, max = 100, message = "O campo nome deve ter entre 3 e 100 caracteres.")
    private String nome;
    @NotEmpty(message= "Campo EMAIL requerido!")
    @Length(min = 3, max = 100, message = "O campo EMAIL deve ter entre 3 e 100 caracteres.")
    private String email;
    @NotEmpty(message= "Campo SENHA requerido!")
    @Length(min = 3, max = 50, message = "O campo SENHA deve ter entre 3 e 50 caracteres.")
    private String senha;
    @NotEmpty(message= "Campo CPF requerido!")
    @Length(min = 11, max = 11, message = "O campo CPF deve ter 11 caracteres.")
    private String cpf;
    @NotEmpty(message= "Campo numero requerido!")
    @Length(min = 11, max = 11, message = "Digite um NÚMERO válido.")
    private String numero;

    @OneToMany(mappedBy = "cadastro", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reserva> reservas = new ArrayList<>();

    @OneToMany(mappedBy = "cadastro", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Avaliar> avaliar = new ArrayList<>();

    @OneToMany(mappedBy = "cadastro", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ticket> ticket = new ArrayList<>();
    // contrutores e getetrs e setter ja estão implementados

    public Cadastro() {
    }

    public Cadastro(Integer id, String nome, String email, String senha, String cpf, String numero) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cpf = cpf;
        this.numero = numero;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public List<Avaliar> getAvaliar() {
        return avaliar;
    }

    public void setAvaliar(List<Avaliar> avaliar) {
        this.avaliar = avaliar;
    }

    public List<Ticket> getTicket() {
        return ticket;
    }

    public void setTicket(List<Ticket> ticket) {
        this.ticket = ticket;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cadastro cadastro = (Cadastro) o;
        return Objects.equals(id, cadastro.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
