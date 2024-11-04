package br.edu.fateczl.atleta.model;

import androidx.annotation.NonNull;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AtletaOutros extends Atleta {

    /*
     *@author: Kelvin Santos Guimarães
     */

    private String academia;
    private double recorde;

    public AtletaOutros(){
        super();
    }


    public String getAcademia() {
        return academia;
    }

    public void setAcademia(String academia) {
        this.academia = academia;
    }

    public double getRecorde() {
        return recorde;
    }

    public void setRecorde(double recorde) {
        this.recorde = recorde;
    }

    @NonNull
    @Override
    public String toString() {
        Date data = getDataNascimento();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String dataString = formato.format(data);

        return "AtletaOutros{" +
                "nome=' " + getNome() + '\'' +
                ", data de nascimento=' " + dataString + '\'' +
                ", bairro=' " + getBairro() + '\'' +
                ", Academia=' " + academia + '\'' +
                ", Recorde=' " + String.valueOf(recorde) + '\'' +
                '}';
    }
}
