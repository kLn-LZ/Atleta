package br.edu.fateczl.atleta.model;

import androidx.annotation.NonNull;
import java.text.SimpleDateFormat;
import java.util.Date;


public class AtletaJuvenil extends Atleta {

    /*
     *@author: Kelvin Santos Guimarães
     */

    private int qtdAnoPraticaEsporte;

    public AtletaJuvenil () {
        super();
    }

    public int getQtdAnoPraticaEsporte() {
        return qtdAnoPraticaEsporte;
    }

    public void setQtdAnoPraticaEsporte(int qtdAnoPraticaEsporte) {
        this.qtdAnoPraticaEsporte = qtdAnoPraticaEsporte;
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
                ", Quantidade de anos praticados=' " + String.valueOf(qtdAnoPraticaEsporte) + '\'' +
                '}';
    }
}
