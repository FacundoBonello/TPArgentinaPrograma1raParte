package org.tp;

import org.tp.utilidades.LectorCSV;
import org.tp.utilidades.LectorDB;

import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException {


        LectorCSV lectorCSV = new LectorCSV();
        LectorDB lectorDB = new LectorDB(lectorCSV);

        Integer puntajePorPartido = Integer.parseInt(args[1]);
        Integer puntajeExtraRonda = 0;
        Integer puntajeExtraFase = 0;
        lectorCSV.leerResultados(args[0]);
        lectorDB.levantarPronosticos();

        calcularPuntos(lectorDB, puntajeExtraFase, puntajeExtraRonda, puntajePorPartido);




    }

    private static void calcularPuntos(LectorDB lectorDB, Integer puntajeExtraFase, Integer puntajeExtraRonda, Integer puntajePorPartido) {

        for(Pronostico p : lectorDB.getPronosticos()){
            if(p.fueAcertado()){
                p.getPersona().sumarPuntos(puntajePorPartido);
                p.getPersona().agregarAcierto();
            }
        }
        for(Persona p : lectorDB.getPersonas()){
            System.out.println("Nombre: " + p.getNombre());
            System.out.println("Aciertos: " + p.getCantAciertos());
            System.out.println("Puntaje:  " + p.getPuntaje());
        }

    }


}