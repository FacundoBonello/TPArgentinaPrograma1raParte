package org.tp;

public class Pronostico {

    private Partido partido;
    private GanadorEnum resultado;

    private Fase fase;
    private Ronda ronda;
    private Persona persona;


    public Pronostico(Fase fase, Ronda ronda, Persona persona, Partido partido, GanadorEnum resultado){
        this.fase = fase;
        this.ronda = ronda;
        this.persona = persona;
        this.partido = partido;
        this.resultado = resultado;
    }




    public Partido getPartido() {
        return partido;
    }




    public Fase getFase(){
        return fase;
    }
    public Ronda getRonda() {
        return ronda;
    }
    public Persona getPersona(){
        return persona;
    }
    public boolean fueAcertado(){
        return this.partido.getResultadoPartido().equals(this.resultado);
    }

}


