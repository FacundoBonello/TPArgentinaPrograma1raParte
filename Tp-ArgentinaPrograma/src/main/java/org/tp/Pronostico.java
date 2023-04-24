package org.tp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pronostico {

    private Partido partido;
    private Equipo equipo;
    private GanadorEnum resultado;

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


    public static void leerPronostico(String archivoPronostico, List<Partido> listaPartidos, int cantPuntos, int cantPuntosExtra) throws IOException{
        String [] datos;

        Map<String, Integer> participantes = new HashMap<>();


        FileReader fr = null;
        BufferedReader br = null;

        fr = new FileReader (archivoPronostico); //se abre el archivo pronosticos
        br = new BufferedReader(fr);

        String linea = br.readLine();

        while(linea != null) {

            datos = linea.split(";");

            if(!datos[0].equals("Participante")){           //verifico que no estoy en la primer linea
                if(!participantes.containsKey(datos[0])){   //verifico que no añadí al participante
                    participantes.put(datos[0], 0);
                }
                for(Partido partido : listaPartidos){
                    if(partido.getEquipo1().getNombre().equals(datos[1]) && partido.getEquipo2().getNombre().equals(datos[5])){
                        GanadorEnum ganadorReal = partido.getResultado();
                        GanadorEnum ganadorPronostico = null;
                        if(datos[2].equals("X")){
                            ganadorPronostico = GanadorEnum.EQUIPO1;
                        } else if (datos[3].equals("X")) {
                            ganadorPronostico = GanadorEnum.EMPATE;
                        } else if (datos[4].equals("X")) {
                            ganadorPronostico = GanadorEnum.EQUIPO2;
                        }
                        if(ganadorReal == ganadorPronostico){              //suma los puntos
                            Integer puntos = participantes.get(datos[0]) + puntos(cantPuntos, cantPuntosExtra);
                            participantes.put(datos[0], puntos);
                        }
                    }
                }

            }









            linea = br.readLine();
        }
        System.out.println(participantes);

        br.close();
    }


        public static int puntos(int cantPuntos, int cantPuntosExtra) {
        int puntos = cantPuntos;
        return puntos;
    }
}


