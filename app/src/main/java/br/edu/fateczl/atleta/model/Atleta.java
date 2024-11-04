package br.edu.fateczl.atleta.model;

import java.util.Date;

public class Atleta {

    /*
     *@author: Kelvin Santos Guimarães
     */

    private String nome;
    private Date dataNascimento;
    private String bairro;

    Atleta() {
        super();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;

    }
}
