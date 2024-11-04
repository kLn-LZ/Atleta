package br.edu.fateczl.atleta.controller;

import java.util.ArrayList;
import java.util.List;

import br.edu.fateczl.atleta.model.AtletaJuvenil;

public class OperacaoJuvenil implements IOperacao<AtletaJuvenil> {

    /*
     *@author: Kelvin Santos Guimarães
     */

    private List<AtletaJuvenil> listaJuvenil;

    public OperacaoJuvenil(){
        this.listaJuvenil = new ArrayList<>();
    }



    @Override
    public void cadastrar(AtletaJuvenil atletaJuvenil) {
        listaJuvenil.add(atletaJuvenil);
    }

    @Override
    public List<AtletaJuvenil> listar() {
        return this.listaJuvenil;
    }
}
