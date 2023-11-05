package com.DreamPlace.DreamPlace.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class Reserva implements Serializable {
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
    private String checkIn;
    private String checkOut;
    private String quarto;
    private String pagamento;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "cadastro_id")
    private Cadastro cadastro;

    public Reserva() {
    }

    public Reserva(Integer id, String nome, String email, String numero, String checkIn, String checkOut, String quarto, String pagamento, Cadastro cadastro) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.numero = numero;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.quarto = quarto;
        this.pagamento = pagamento;
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

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    public String getQuarto() {
        return quarto;
    }

    public void setQuarto(String quarto) {
        this.quarto = quarto;
    }

    public String getPagamento() {
        return pagamento;
    }

    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
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
        Reserva reserva = (Reserva) o;
        return Objects.equals(id, reserva.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
