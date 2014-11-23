package Modelo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;

/**
 * Clase que representa un evento que puede ocurrir durante la ejecución del
 * programa
 * @author vaio
 */
public class Evento {

    protected ArrayList<Observer> miembros;
    protected int idEvento;
    protected String nombreEvento;

    /**
     * Constructor por defecto. Inicializa el objeto con un entero que representa
     * el identificador de un evento.
     * @param idEvento el identificador del evento.
     */
    public Evento(int idEvento) {
        this.miembros=new ArrayList();
        this.idEvento=idEvento;
    }
    

    /**
     * Método que agrega un observador al arreglo de miembros.
     * @param miembro el observador a agregar.
     */
    public void agregarMiembro(Observer miembro){
        miembros.add(miembro);
    }
    
    /**
     * Método que elimina un observador miembro del arreglo de miembros.
     * @param miembro el observador a eliminar.
     */
    public void eliminarMiembro(Observer miembro){
        miembros.remove(miembro);
    }
    
    /** Método para obtener todos los observadores.
     * @return los miembros.
     */
    public ArrayList<Observer> getMiembros() {
        return miembros;
    }

    /**
     * Método para obtener el identificador de un evento.
     * @return el idEvento
     */
    public int getIdEvento() {
        return idEvento;
    }

    /**
     * Método para agregar elementos a la lista de observadores
     * @param miembros los miembros a agregar.
     */
    public void setMiembros(ArrayList<Observer> miembros) {
        this.miembros = miembros;
    }

    /**
     * Método para asignar el identificador de un evento.
     * @param idEvento el idEvento a asignar.
     */
    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    /**
     * Método para obtener el nombre de une evento.
     * @return el nombreEvento.
     */
    public String getNombreEvento() {
        return nombreEvento;
    }

    /**
     * Método para asignar el nombre de un evento.
     * @param nombreEvento el nombre del evento a asignar.
     */
    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }
    
    
    
}
