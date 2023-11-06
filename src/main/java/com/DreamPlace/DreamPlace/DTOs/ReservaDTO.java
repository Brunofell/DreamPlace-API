package com.DreamPlace.DreamPlace.DTOs;


import com.DreamPlace.DreamPlace.domain.Reserva;

import java.io.Serializable;

public class ReservaDTO implements Serializable {
    private Integer id;
    private String nome;
    private String email;
    private String numero;
    private String checkIn;
    private String checkOut;
    private String quarto;
    private String pagamento;

    public ReservaDTO() {
    }

    public ReservaDTO(Reserva obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.email = obj.getEmail();
        this.numero = obj.getNumero();
        this.checkIn = obj.getCheckIn();
        this.checkOut = obj.getCheckOut();
        this.quarto = obj.getQuarto();
        this.pagamento = obj.getPagamento();
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
}
