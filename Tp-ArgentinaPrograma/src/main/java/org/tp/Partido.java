package org.tp;



public class Partido {

    private Equipo equipo1;
    private Equipo equipo2;
    private Integer golesEquipo1;
    private Integer golesEquipo2;

    private GanadorEnum resultado;





    public boolean igual(Partido partido){
        return (this.equipo1.equals(partido.equipo1) && this.equipo2.equals(partido.equipo2) ||
                this.equipo1.equals(partido.equipo2) && this.equipo2.equals(partido.equipo1));
    }

    public GanadorEnum getResultadoPartido(){
        if(golesEquipo1 == golesEquipo2){
            return GanadorEnum.EMPATE;
        } else if (golesEquipo1 > golesEquipo2) {
            return GanadorEnum.EQUIPO1;
        } else {
            return GanadorEnum.EQUIPO2;
        }
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



    public GanadorEnum getResultado() {
        return resultado;
    }










    @Override
    public String toString() {
        return equipo1 + "" + golesEquipo1.toString() + "-" + golesEquipo2.toString() + "" + equipo2 + " Ganador:" + resultado;
    }

    public boolean tieneEquipos(String equipo1, String equipo2) {

        return (this.equipo1.getNombre().equals(equipo1) && this.equipo2.getNombre().equals(equipo2)) ||
                (this.equipo1.getNombre().equals(equipo2) && this.equipo2.getNombre().equals(equipo1));

    }
}

