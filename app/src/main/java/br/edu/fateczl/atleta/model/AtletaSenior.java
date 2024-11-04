package br.edu.fateczl.atleta.model;

import androidx.annotation.NonNull;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AtletaSenior extends Atleta{

    /*
     *@author: Kelvin Santos Guimarães
     */

    private boolean temProblemaCardiaco;

    public AtletaSenior() {
        super();
    }

    public boolean isTemProblemaCardiaco() {
        return temProblemaCardiaco;
    }

    public void setTemProblemaCardiaco(boolean temProblemaCardiaco) {
        this.temProblemaCardiaco = temProblemaCardiaco;
    }

    @NonNull
    @Override
    public String toString() {
        Date data = getDataNascimento();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String dataString = formato.format(data);

        return "AtletaJuvenil{" +
                "nome=' " + getNome() + '\'' +
                ", data de nascimento=' " + dataString + '\'' +
                ", bairro=' " + getBairro() + '\'' +
                ", Tem problema cardíaco=' " + String.valueOf(temProblemaCardiaco) + '\'' +
                '}';
    }
}
