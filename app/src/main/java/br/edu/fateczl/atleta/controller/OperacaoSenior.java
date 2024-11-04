package br.edu.fateczl.atleta.controller;

import java.util.ArrayList;
import java.util.List;

import br.edu.fateczl.atleta.model.AtletaSenior;

public class OperacaoSenior implements IOperacao<AtletaSenior>{

    /*
     *@author: Kelvin Santos Guimarães
     */

    private List<AtletaSenior> listaSenior;

    public OperacaoSenior() {
        this.listaSenior = new ArrayList<>();
    }

    @Override
    public void cadastrar(AtletaSenior atletaSenior) {
        listaSenior.add(atletaSenior);
    }

    @Override
    public List<AtletaSenior> listar() {
        return this.listaSenior;
    }
}
