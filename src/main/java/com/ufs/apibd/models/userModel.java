package com.ufs.apibd.models;

import java.time.LocalDateTime;

public class userModel {
    private int cpf;
    private String nome;
    private LocalDateTime dta_nascimeto;

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDateTime getDta_nascimeto() {
        return dta_nascimeto;
    }

    public void setDta_nascimeto(LocalDateTime dta_nascimeto) {
        this.dta_nascimeto = dta_nascimeto;
    }
}
