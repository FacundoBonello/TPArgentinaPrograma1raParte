package org.tp;

public class Equipo {

    private String nombre;

    public Equipo(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }


    @Override
    public String toString() {
        return nombre;
    }



}
