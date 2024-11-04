package br.edu.fateczl.atleta.controller;

import java.util.ArrayList;
import java.util.List;

import br.edu.fateczl.atleta.model.AtletaOutros;

public class OperacaoOutros implements IOperacao<AtletaOutros>{

    /*
     *@author: Kelvin Santos Guimarães
     */

    private List<AtletaOutros> listaOutros;

    public OperacaoOutros() {
        this.listaOutros = new ArrayList<>();
    }

    @Override
    public void cadastrar(AtletaOutros atletaOutros) {
        listaOutros.add(atletaOutros);
    }

    @Override
    public List<AtletaOutros> listar() {
        return listaOutros;
    }
}
