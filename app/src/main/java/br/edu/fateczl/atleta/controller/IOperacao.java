package br.edu.fateczl.atleta.controller;

import java.util.List;

public interface IOperacao<T>{

    /*
     *@author: Kelvin Santos Guimarães
     */

    public void cadastrar(T t);
    public List<T> listar();

}
