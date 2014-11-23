package Controlador;


import Modelo.Modelo;
import Modelo.Observer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author a09001005
 */
public abstract class Controlador implements Observer {

    /**
     *
     */
    protected Modelo modelo;

    /**
     * Constructor por defecto. Inicializa el controlador con un Modelo y un Evento
     * @param modelo el modelo a agregar
     * @param idEvento el evento a agregar
     */
    public Controlador(Modelo modelo, int idEvento) {
        this.modelo = modelo;
        this.modelo.registrarObservador(this, idEvento);
    }

    /**
     * Método que actualiza el estado de un evento
     * @param o el objeto a actualizar
     */
    @Override
    public void actualizar(Object o) {
        System.out.println("si actualiza, controlador");
    }

    /**
     * Método para obtener el modelo con el que se está interactuando
     * @return el modelo actual
     */
    public Modelo getModelo() {
        return modelo;
    }

    /**
     * Método para asignar el modelo para a ser tratado 
     * @param modelo el modelo a asignar
     */
    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

}
