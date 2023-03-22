package tp;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		
	Equipo argentina =new Equipo("Argentina", "La campeona del mundo");
	Equipo arabiaSaudita =new Equipo("Arabia Saudita", "Arabes");
	Equipo mexico =new Equipo("Mexico", "los Aztecas");
	Equipo polonia =new Equipo("Polonia", "Auschwitz");
	Equipo francia =new Equipo("Francia", "segundos");
	Equipo camerun =new Equipo("Camerun", "segundos");
	Partido partido = new Partido(argentina, arabiaSaudita);
	Partido partido2 = new Partido(polonia, mexico);
	Partido partido3 = new Partido(camerun, francia);
	
	partido.leerPartido();
	
	System.out.println("los goles del equipo de " + partido.getEquipo1().getNombre() + " son: " + partido.getGolesEquipo1());
	System.out.println("los goles del equipo de " + partido.getEquipo2().getNombre() + " son: " + partido.getGolesEquipo2());
	System.out.println(partido.getEquipo1().getNombre() + " Resultó: " + partido.resultado(argentina) + " y " + partido.getEquipo2().getNombre() + " : " + partido.resultado(arabiaSaudita));
	
	partido2.leerPartido();
	
	System.out.println("los goles del equipo de " + partido2.getEquipo1().getNombre() + " son: " + partido2.getGolesEquipo1());
	System.out.println("los goles del equipo de " + partido2.getEquipo2().getNombre() + " son: " + partido2.getGolesEquipo2());
	System.out.println(partido2.getEquipo1().getNombre() + " Resultó: " + partido2.resultado(polonia) + " y " + partido2.getEquipo2().getNombre() + " : " + partido2.resultado(mexico));

partido3.leerPartido();
	
	System.out.println("los goles del equipo de " + partido3.getEquipo1().getNombre() + " son: " + partido3.getGolesEquipo1());
	System.out.println("los goles del equipo de " + partido3.getEquipo2().getNombre() + " son: " + partido3.getGolesEquipo2());
	System.out.println(partido3.getEquipo1().getNombre() + " Resultó: " + partido3.resultado(camerun) + " y " + partido3.getEquipo2().getNombre() + " : " + partido3.resultado(francia));
	
	Pronostico pronostico1 = new Pronostico(partido);
	Pronostico pronostico2 = new Pronostico(partido2);
	Pronostico pronostico3 = new Pronostico(partido3);
	
	pronostico1.leerPronostico();
	
	System.out.println("el pronostico fue que " + pronostico1.getEquipo().getNombre() + " tuvo el resultado de: " + pronostico1.getResultado() + " Y los puntos obtenidos son: " + pronostico1.puntos());
	
	pronostico2.leerPronostico();
	
	System.out.println("el pronostico fue que " + pronostico2.getEquipo().getNombre() + " tuvo el resultado de: " + pronostico2.getResultado() + " Y los puntos obtenidos son: " + pronostico2.puntos());
	
  pronostico3.leerPronostico();
	
	System.out.println("el pronostico fue que " + pronostico3.getEquipo().getNombre() + " tuvo el resultado de: " + pronostico3.getResultado() + " Y los puntos obtenidos son: " + pronostico3.puntos());


}

}