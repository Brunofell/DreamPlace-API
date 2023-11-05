package com.DreamPlace.DreamPlace.DTOs;

import com.DreamPlace.DreamPlace.domain.Cadastro;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

public class CadastroDTO {

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

    public CadastroDTO() {
    }

    public CadastroDTO(Cadastro obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.email = obj.getEmail();
        this.senha = obj.getSenha();
        this.cpf = obj.getCpf();
        this.numero = obj.getNumero();
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
}
