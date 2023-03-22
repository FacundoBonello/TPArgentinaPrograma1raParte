package tp;
import java.io.*;

public class Partido {
	
	private Equipo equipo1;
	private Equipo equipo2;
	private Integer golesEquipo1 ;
	private Integer golesEquipo2 ;
	private String [] datos;
	
	
	public Partido(Equipo equipo1, Equipo equipo2) {
		this.equipo1 = equipo1;
		this.equipo2 = equipo2;
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



/*en este metodo se lee el archivo y se busca que los nombres en el archivo coincidan con los que se pasaron de la clase Equipo para saber la cantidad de goles */

	public void leerPartido() throws IOException {
		
		FileReader fr = null;
        BufferedReader br = null;
        
        fr = new FileReader ("Resultados.csv"); //se abre el archivo resultados
        br = new BufferedReader(fr);
        
        String linea = br.readLine();
        
        while(linea != null){ //leemos todas las lineas del archivo
        	
        	
        	datos = linea.split(";"); //guardamos en un array llamado datos todas las palabras que contenga la linea
        	
        	 for (String resultado : datos) { //recorro el array
     			if(resultado.equals(equipo1.getNombre())) { 
     				
     				golesEquipo1 = Integer.parseInt(datos[1]); /*Si en la linea leida se encuentra el nombre del Equipo 1 enotnces el campo de datos[1]
     				                                             Es donde se encuentra la cantidad de goles anotados por el equipo 1 */
     			}
     			
     			if(resultado.equals(equipo2.getNombre())) {
     				
     				golesEquipo2 = Integer.parseInt(datos[2]); //si coincide con el equipo 2 entonces el campo de los goles corresponde a datos[2]
     			}
     			
     		
     		}
        	
        	linea = br.readLine(); //leo la siguiente linea y repito
        }
        
        
       
        
        fr.close(); 
	}
	
	
   public ResultadoEnum resultado(Equipo equipo) {
	   
	   ResultadoEnum resultadoequipo = null;
	   
  if(equipo.getNombre().equals(this.equipo1.getNombre())) { //comparo si el equipo que le pase al metodo coincide con el Equipo 1 de la clase
	  
	  if(golesEquipo1 > golesEquipo2) { //si coinciden entonces me fijo si el equipo 1 metio mas goles que el equipo 2, en caso de ser cierto el equipo que pasamos 
		                                //por parametro es el ganador
		   
		  resultadoequipo = ResultadoEnum.GANADOR;
	   }
	  else if(golesEquipo1 < golesEquipo2){
		  resultadoequipo = ResultadoEnum.PERDEDOR; //comparo si el equipo 2 metio mas goles que el 1
	  }
	  else {
			resultadoequipo = ResultadoEnum.EMPATE;
		}
	   
  }
  
if(equipo.getNombre().equals(this.equipo2.getNombre())) { //si el equipo no coincide con el quipo 1 entonces comparo con el equipo 2
	  
	  if(golesEquipo1 < golesEquipo2) {
		   
		  resultadoequipo = ResultadoEnum.GANADOR;
	   }
	  else if(golesEquipo1 > golesEquipo2){
		  resultadoequipo = ResultadoEnum.PERDEDOR;
	  }
	  else {
			resultadoequipo = ResultadoEnum.EMPATE;
		}
  }



return resultadoequipo;
  
   }
   
   
   
  

}
