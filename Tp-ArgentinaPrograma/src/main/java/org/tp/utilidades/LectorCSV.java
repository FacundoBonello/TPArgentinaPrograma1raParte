package org.tp.utilidades;

import org.tp.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LectorCSV {

    private List<Equipo> equipos;
    private List<Fase> fases;

    public LectorCSV(){
        this.equipos = new ArrayList<>();
        this.fases = new ArrayList<>();
    }

    public void leerResultados(String archivoResultados) throws IOException {


        String[] datos;
        FileReader fr = null;
        BufferedReader br = null;

        fr = new FileReader(archivoResultados); //se abre el archivo resultados
        br = new BufferedReader(fr);
        String linea = br.readLine();

        int rondaActual = 0;
        Ronda ronda = new Ronda(0);

        int faseActual = 0;
        Fase fase = new Fase(0);

        while (linea != null) {
            datos = linea.split(";");


            if (!datos[0].equals("Fase")){
                Equipo equipo = new Equipo(datos[2]);
                Equipo equipo2 = new Equipo(datos[5]);

                if (!equipos.contains(equipo)) {
                    equipos.add(equipo);
                }
                if (!equipos.contains(equipo2)) {
                    equipos.add(equipo2);
                }

                Equipo equipo1Lista = null;
                Equipo equipo2Lista = null;
                int golesEq1 = 0;
                int golesEq2 = 0;
                GanadorEnum resultado = null;
                for (Equipo e : equipos) {
                    if (e.getNombre().equals(datos[2])) {
                        equipo1Lista = e;
                        golesEq1 = Integer.parseInt(datos[3]);

                    }
                }
                for (Equipo e : equipos) {
                    if (e.getNombre().equals((datos[5]))) {
                        equipo2Lista = e;
                        golesEq2 = Integer.parseInt(datos[4]);
                    }
                }
                if(golesEq1 > golesEq2) {
                    resultado = GanadorEnum.EQUIPO1;
                } else if (golesEq1 < golesEq2) {
                    resultado = GanadorEnum.EQUIPO2;
                } else if (golesEq1 == golesEq2) {
                    resultado = GanadorEnum.EMPATE;
                }

                if (equipo1Lista != null) {
                    Partido partido = new Partido(equipo1Lista, equipo2Lista, golesEq1, golesEq2, resultado);
                    if (rondaActual != Integer.parseInt(datos[1])) { //verifico que empiezo una ronda

                        if(rondaActual != 0){           //si estoy en una nueva ronda agrego la ronda antes de iniciar una nueva (verificando que no este en al ronda 0 osea antes de empezar)
                            fase.agregarRonda(ronda);
                        }

                        rondaActual = Integer.parseInt(datos[1]);
                        ronda = new Ronda(Integer.parseInt(datos[1]));
                        ronda.agregarPartido(partido);
                    } else if (rondaActual == Integer.parseInt(datos[1])) {
                        ronda.agregarPartido(partido);
                    }
                    if (faseActual != Integer.parseInt(datos[0])) { //fase nueva
                        faseActual = Integer.parseInt(datos[0]);
                        fase = new Fase(Integer.parseInt(datos[1]));
                    }
                }
            }


            linea = br.readLine();
        }

        fr.close();
        fase.agregarRonda(ronda);
        this.agregarFase(fase);

    }


    public void agregarFase(Fase fase){
        for(Fase f : this.fases){
            if(f.getNumeroFase() == fase.getNumeroFase()){
                throw new RuntimeException("La fase ya existe");
            }
        }
        this.fases.add(fase);
    }

    public Fase buscarFase(int numeroFase){
        Fase fase = null;

        for(Fase f : this.fases){
            if(f.getNumeroFase() == numeroFase){
                fase = f;
            }
        }
        return fase;
    }
}
