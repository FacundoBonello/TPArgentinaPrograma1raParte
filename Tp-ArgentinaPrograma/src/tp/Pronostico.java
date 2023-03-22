package tp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Pronostico {
	
	private Partido partido;
	private Equipo equipo;
	private ResultadoEnum resultado;
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


	protected ResultadoEnum getResultado() {
		return resultado;
	}


	public void leerPronostico() throws IOException{
		
		
		FileReader fr = null;
        BufferedReader br = null;
        
        fr = new FileReader ("Pronostico.csv"); //se abre el archivo pronosticos
        br = new BufferedReader(fr);
        
        String linea = br.readLine();
        
        while(linea != null) {
        	
        	datos = linea.split(";");
        	
        	for (String pronostico : datos) {
        		
    
        		if(partido.getEquipo1().getNombre().equals(pronostico)) {
        			
        			if(datos[1].equals("X")) {
        				
        				this.equipo = partido.getEquipo1();
        				this.resultado = ResultadoEnum.GANADOR;
        			}
        			else if(datos[2].equals("X")) {
        				this.equipo = partido.getEquipo1();
            			this.resultado = ResultadoEnum.EMPATE;
            		}
        		}
        		
        	    if(partido.getEquipo2().getNombre().equals(pronostico)) {
        			
        			if(datos[3].equals("X")) {
        				
        				this.equipo = partido.getEquipo2();
        				this.resultado = ResultadoEnum.GANADOR;
        			}
        			else if(datos[2].equals("X")) {
        				this.equipo = partido.getEquipo2();
            			this.resultado = ResultadoEnum.EMPATE;
            		}
        		}
        	    
        		
        	
        		
        	}
        	
        	linea = br.readLine();
        }
        
        br.close();
	}
	
	public int puntos() {
		int puntos = 0;
		ResultadoEnum resultadoRealParaEquipo = this.partido.resultado(this.equipo);
		if(resultadoRealParaEquipo == this.resultado) {
			puntos = 20;
		}
		return puntos;
	}
}


