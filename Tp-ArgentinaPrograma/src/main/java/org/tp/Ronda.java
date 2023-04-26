package org.tp;

import java.util.ArrayList;
import java.util.List;

public class Ronda {

    private int numeroRonda;
    private List<Partido> partidos;

    public Ronda(int numeroRonda){
        this.numeroRonda = numeroRonda;
        this.partidos = new ArrayList<>();
    }

    public int getNumeroRonda(){
        return numeroRonda;
    }

    public void agregarPartido(Partido partido){
        for(Partido p : this.partidos){
            if (p.igual(partido)){
                throw new RuntimeException("El partido ya existe");
            }
        }
        this.partidos.add(partido);
    }

    public Partido obtenerPartido(String equipo1, String equipo2) {

        Partido partido = null;

        for(Partido p : this.partidos){
            if(p.tieneEquipos(equipo1, equipo2)){
                partido = p;
            }
        }

        return partido;
    }
}
