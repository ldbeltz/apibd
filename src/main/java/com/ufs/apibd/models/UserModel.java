package com.ufs.apibd.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "USERS")
public class UserModel implements Serializable {

    @Id
    private long cpf;
    @Column
    private String name;
    @Column
    private LocalDate dtaNascimento;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDtaNascimento() {
        return dtaNascimento;
    }

    public void setDtaNascimento(LocalDate dtaNascimento) {
        this.dtaNascimento = dtaNascimento;
    }
}
