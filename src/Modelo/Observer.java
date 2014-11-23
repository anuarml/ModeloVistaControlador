package Modelo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Interface que representa un observador.
 * @author a09001005
 */
public interface Observer {
    
    /**
     * Método para actualizar la información recibida de un objeto.
     * @param o el objeto con la información a actualizar.
     */
    public void actualizar(Object o);
}
