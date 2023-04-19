package org.tp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Pronostico {

    private Partido partido;
    private Equipo equipo;
    private GanadorEnum resultado;
    private String [] datos;

    public Pronostico(Partido partido) {

        this.partido = partido;


    }


    protected Partido getPartido() {
        return partido;
    }


    protected Equipo getEquipo() {
        return equipo;
    }


    protected GanadorEnum getResultado() {
        return resultado;
    }


    public void leerPronostico() throws IOException{

        Map<String, Integer> participantes = new HashMap<>();


        FileReader fr = null;
        BufferedReader br = null;

        fr = new FileReader ("Pronostico.csv"); //se abre el archivo pronosticos
        br = new BufferedReader(fr);

        String linea = br.readLine();

        while(linea != null) {

            datos = linea.split(";");

            if(!datos[0].equals("Participante")){           //verifico que no estoy en la primer linea
                if(!participantes.containsKey(datos[0])){   //verifico que no añadí al participante
                    participantes.put(datos[0], 0);
                }


            }







//
//            for (String pronostico : datos) {
//
//
//                if(partido.getEquipo1().getNombre().equals(pronostico)) {
//
//                    if(datos[2].equals("X")) {
//
//                        this.equipo = partido.getEquipo1();
//                        this.resultado = ResultadoEnum.GANADOR;
//                    }
//                    else if(datos[3].equals("X")) {
//                        this.equipo = partido.getEquipo1();
//                        this.resultado = ResultadoEnum.EMPATE;
//                    }
//                }
//
//                if(partido.getEquipo2().getNombre().equals(pronostico)) {
//
//                    if(datos[4].equals("X")) {
//
//                        this.equipo = partido.getEquipo2();
//                        this.resultado = ResultadoEnum.GANADOR;
//                    }
//                    else if(datos[3].equals("X")) {
//                        this.equipo = partido.getEquipo2();
//                        this.resultado = ResultadoEnum.EMPATE;
//                    }
//                }
//
//
//
//
//            }

            linea = br.readLine();
        }

        br.close();
    }

//    public int puntos(int cantPuntos, int cantPuntosExtra) {
//        int puntos = 0;
//        int puntosExtra = 0;
//        ResultadoEnum resultadoRealParaEquipo = this.partido.resultado(this.equipo);
//        if(resultadoRealParaEquipo == this.resultado) {
//            puntos = cantPuntos;
//        }
//        return puntos;
//    }
}


