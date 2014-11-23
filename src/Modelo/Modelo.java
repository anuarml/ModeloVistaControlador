package Modelo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;


/**
 *
 * @author a09001005
 */
public class Modelo {

    protected ArrayList<Evento> eventos;
    protected Object datos;

    
    /**
     * El constructor crea el vector con la asociacion Observable-Observador
     */
    public Modelo() {
        eventos = new ArrayList();
    }

    /**
     * Método para registrar un observador.
     * @param observer el observador a registrar.
     * @param idEvento el identificador del evento a registrar.
     */
    public void registrarObservador(Observer observer, int idEvento) {
        for (Evento evento : eventos) {
            if (evento.getIdEvento()==idEvento) {
                evento.agregarMiembro( observer);
                return;
            }
        }
    }

    /**
     * Método para eliminar el registro de un observador.
     * @param observer el observador a eliminar.
     * @param idEvento el identificador del evento a eliminar.
     */
    public void eliminarObservador(Observer observer, int idEvento) {
        for (Evento evento : eventos) {
            if (evento.getIdEvento()==idEvento) {
                evento.eliminarMiembro(observer);
                return;
            }
        }
    }

    /**
     * Método para añadir un evento.
     * @param evento el evento a añadir.
     */
    public void agregarEvento(Evento evento) {
        for (Evento evt : this.eventos) {
            if (evt.getIdEvento() == evento.getIdEvento()) {
                break;
            } else {
                eventos.add(evento);
            }
        }
    }

    /**
     * Método para notificar a los observadores  de que un nuevo evento a ocurrido 
     * y que esté actualice la información que recibe.
     * @param idEvento el identificador del evento a notificar.
     */
    public void notificarObservadoresEvento(int idEvento) {
        for (Evento evento : eventos) {
            if (evento.getIdEvento() == idEvento) {
                for (Observer observer : evento.getMiembros()) {
                    observer.actualizar(getDatos());
                }
                break;
            }
        }
    }

    /**
     * @return los datos
     */
    public Object getDatos() {
        return datos;
    }

    /**
     * @param datos los datos a agregar.
     */
    public void setDatos(Object datos) {
        this.datos = datos;
    }

}
