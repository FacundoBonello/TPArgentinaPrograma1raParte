package org.tp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        List<Partido> listaPartidos = new ArrayList<>();
        Partido.leerPartido(args[0], listaPartidos);
        System.out.println(listaPartidos.get(0));
        Pronostico.leerPronostico(args[1], listaPartidos, 1, 0);





    }

}