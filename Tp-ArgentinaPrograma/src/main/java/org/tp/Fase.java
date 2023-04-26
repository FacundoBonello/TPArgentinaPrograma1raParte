package org.tp;

import java.util.ArrayList;
import java.util.List;

public class Fase {

    private List<Ronda> rondas;
    private int numeroFase;

    public Fase(int numeroFase){
        this.rondas = new ArrayList<>();
        this.numeroFase = numeroFase;
    }

    public void agregarRonda(Ronda ronda){
        for (Ronda r : this.rondas){
            if (r.getNumeroRonda() == ronda.getNumeroRonda()){
                throw new RuntimeException("La ronda ya existe");
            }
        }
        this.rondas.add(ronda);
    }


    public int getNumeroFase(){
        return numeroFase;
    }

    public Ronda buscarRonda(int numeroRonda){
        Ronda ronda = null;

        for(Ronda r : this.rondas){
            if(r.getNumeroRonda() == numeroRonda){
                ronda = r;
            }
        }
        return ronda;
    }







}
