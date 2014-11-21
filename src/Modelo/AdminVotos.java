package Modelo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Cache.MainCache;
import java.util.ArrayList;


/**
 *
 * @author a09001005
 */
public class AdminVotos extends Modelo {

    static AdminVotos adminVtos;
    private ArrayList<Candidato> cands;
    private int contador = 0;

    
    public AdminVotos() {
        this.cands = new ArrayList();
        inicializarCandidatos();
        inicializarEventos();
        super.datos = cands;
    }

    public static AdminVotos getInstance() {
        if (adminVtos == null) {
            adminVtos = new AdminVotos();
        }
        return adminVtos;
    }

    public void inicializarCandidatos() {
        Candidato A = new Candidato("A");
        cands.add(A);
        llamarCache(A);
        Candidato B = new Candidato("B");
        cands.add(B);
        llamarCache(B);
        Candidato C = new Candidato("C");
        cands.add(C);
        llamarCache(C);
        
    }

    private void inicializarEventos() {
        int numeroDeEventos=3;
        for (int i = 0; i < numeroDeEventos; i++) {
            eventos.add(new Evento(i));
        }
    }


    public void agregarCandidatos(ArrayList<Candidato> candidatos) {
        
        for (Candidato candidato:candidatos) {
            llamarCache(candidato);
        }
        super.setDatos(candidatos);
        notificarObservadoresEvento(0);
     
    }

    public void agregarVoto(String nombre) {
        for (Candidato cand : (ArrayList<Candidato>) getDatos()) {
            if (cand.getNombre().equals(nombre)) {
                cand.agregarVoto();
            }
        }
        notificarObservadoresEvento(0);
    }

    public void agregarCandidatos(String nombre) {
        Candidato temp = new Candidato(nombre);
        ((ArrayList<Candidato>) super.getDatos()).add(temp);
        notificarObservadoresEvento(0);
    }

    public void eliminarCandidatos(String nombre, String peticion) {
        for (Candidato candidato : ((ArrayList<Candidato>)getDatos())) {
            if (candidato.getNombre().equals(nombre)) {
                ((ArrayList<Candidato>) getDatos()).remove(candidato);
                break;
            }
        }
        notificarObservadoresEvento(0);
    }
    
    public void llamarCache(Candidato candidato){
        MainCache mainCache = new MainCache();
        mainCache.putInCache(candidato);
    }


}
