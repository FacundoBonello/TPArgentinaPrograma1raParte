package org.tp;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Partido {

    private Equipo equipo1;
    private Equipo equipo2;
    private Integer golesEquipo1;
    private Integer golesEquipo2;

    private GanadorEnum resultado;


    public Partido(Equipo equipo1, Equipo equipo2) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
    }

    public Partido(Equipo equipo1, Equipo equipo2, Integer golesEquipo1, Integer golesEquipo2, GanadorEnum resultado) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.golesEquipo1 = golesEquipo1;
        this.golesEquipo2 = golesEquipo2;
        this.resultado = resultado;
    }

    protected Equipo getEquipo1() {
        return equipo1;
    }


    protected Equipo getEquipo2() {
        return equipo2;
    }

    protected int getGolesEquipo1() {
        return golesEquipo1;
    }


    protected int getGolesEquipo2() {
        return golesEquipo2;
    }

    public GanadorEnum getResultado() {
        return resultado;
    }




    /*en este metodo se lee el archivo y se busca que los nombres en el archivo coincidan con los que se pasaron de la clase Equipo para saber la cantidad de goles */

    public static void leerPartido(List<Partido> listaPartidos) throws IOException {

        List<Equipo> listaEquipos = new ArrayList<>();

        String[] datos;
        FileReader fr = null;
        BufferedReader br = null;

        fr = new FileReader("Resultados.csv"); //se abre el archivo resultados
        br = new BufferedReader(fr);

        String linea = br.readLine();

        while (linea != null) { //leemos todas las lineas del archivo


            datos = linea.split(";"); //guardamos en un array llamado datos todas las palabras que contenga la linea


            if (!datos[1].equals("Equipo1")) { //junta los equipos en la lista de equipos

                Equipo equipo = new Equipo(datos[1]);
                Equipo equipo2 = new Equipo(datos[4]);

                if (!listaEquipos.contains(equipo)) {
                    listaEquipos.add(equipo);
                }
                if (!listaEquipos.contains(equipo2)) {
                    listaEquipos.add(equipo2);
                }
            }


//            for (String resultado : datos) { //recorro el array
//                if(resultado.equals(equipo1.getNombre())) {
//
//                    golesEquipo1 = Integer.parseInt(datos[2]); /*Si en la linea leida se encuentra el nombre del Equipo 1 enotnces el campo de datos[2]
//     				                                             Es donde se encuentra la cantidad de goles anotados por el equipo 1 */
//                }
//
//                if(resultado.equals(equipo2.getNombre())) {
//
//                    golesEquipo2 = Integer.parseInt(datos[3]); //si coincide con el equipo 2 entonces el campo de los goles corresponde a datos[3]
//                }
//
//
//            }

            //junta los goles y crea el partido
            Equipo equipo1Lista = null;
            Equipo equipo2Lista = null;
            int golesEq1 = 0;
            int golesEq2 = 0;
            GanadorEnum resultado = null;
            for (Equipo equipo : listaEquipos) {
                if (equipo.getNombre().equals(datos[1])) {
                    equipo1Lista = equipo;
                    golesEq1 = Integer.parseInt(datos[2]);

                }
            }
            for (Equipo equipo : listaEquipos) {
                if (equipo.getNombre().equals((datos[4]))) {
                    equipo2Lista = equipo;
                    golesEq2 = Integer.parseInt(datos[3]);
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
                listaPartidos.add(partido);
            }


            linea = br.readLine(); //leo la siguiente linea y repito
        }


        fr.close();
        System.out.println(listaEquipos); //
        System.out.println(listaPartidos); //


    }


//    public ResultadoEnum resultado(Equipo equipo) {
//
//        ResultadoEnum resultadoequipo = null;
//
//        if(equipo.getNombre().equals(this.equipo1.getNombre())) { //comparo si el equipo que le pase al metodo coincide con el Equipo 1 de la clase
//
//            if(golesEquipo1 > golesEquipo2) { //si coinciden entonces me fijo si el equipo 1 metio mas goles que el equipo 2, en caso de ser cierto el equipo que pasamos
//                //por parametro es el ganador
//
//                resultadoequipo = ResultadoEnum.GANADOR;
//            }
//            else if(golesEquipo1 < golesEquipo2){
//                resultadoequipo = ResultadoEnum.PERDEDOR; //comparo si el equipo 2 metio mas goles que el 1
//            }
//            else {
//                resultadoequipo = ResultadoEnum.EMPATE;
//            }
//
//        }
//
//        if(equipo.getNombre().equals(this.equipo2.getNombre())) { //si el equipo no coincide con el quipo 1 entonces comparo con el equipo 2
//
//            if(golesEquipo1 < golesEquipo2) {
//
//                resultadoequipo = ResultadoEnum.GANADOR;
//            }
//            else if(golesEquipo1 > golesEquipo2){
//                resultadoequipo = ResultadoEnum.PERDEDOR;
//            }
//            else {
//                resultadoequipo = ResultadoEnum.EMPATE;
//            }
//        }
//
//
//
//        return resultadoequipo;
//
//    }


    @Override
    public String toString() {
        return equipo1 + "" + golesEquipo1.toString() + "-" + golesEquipo2.toString() + "" + equipo2 + " Ganador:" + resultado;
    }

}

