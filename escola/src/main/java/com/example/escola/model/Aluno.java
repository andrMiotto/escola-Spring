package com.example.escola.model;

import java.sql.Date;

public class Aluno {
    int id;
    String nome;
    String email;
    int matricula;
    Date data_nascimento;

    public Aluno(int id, String nome, String email, int matricula, Date data_nascimento) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.matricula = matricula;
        this.data_nascimento = data_nascimento;
    }

    public Aluno(String nome, String email, int matricula, Date data_nascimento) {
        this.nome = nome;
        this.email = email;
        this.matricula = matricula;
        this.data_nascimento = data_nascimento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public Date getDataNascimento() {
        return data_nascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.data_nascimento = dataNascimento;
    }
}
