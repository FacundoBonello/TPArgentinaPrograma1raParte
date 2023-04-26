package org.tp.utilidades;

import org.tp.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LectorDB {

    private LectorCSV lectorCSV;
    private List<Persona> personas;
    private List<Pronostico> pronosticos;

    public LectorDB(LectorCSV lectorCSV){
        this.lectorCSV = lectorCSV;
        this.personas = new ArrayList<>();
        this.pronosticos = new ArrayList<>();
    }

    public List<Pronostico> getPronosticos() {
        return pronosticos;
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void levantarPronosticos() {


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pronosticos","root","1234");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from pronosticos");

            while(rs.next()) {

                Fase fase = lectorCSV.buscarFase(rs.getInt("fase"));
                if(fase == null){
                    throw new RuntimeException("La fase no existe");
                }

                Ronda ronda = fase.buscarRonda(rs.getInt("ronda"));
                if (ronda == null){
                    throw new RuntimeException("La ronda no existe");
                }



                Persona persona = this.obtenerPersona(rs.getString("persona"));

                Partido partido = ronda.obtenerPartido(rs.getString("equipo_1"), rs.getString("equipo_2"));
                if(partido == null){
                    throw new RuntimeException("El partido no existe");
                }

                boolean gana1 = rs.getBoolean("gana_1");
                boolean empata = rs.getBoolean("empata");
                boolean gana2 = rs.getBoolean("gana_2");

                GanadorEnum resultadoPronostico = null;

                if (gana1) {
                    resultadoPronostico = GanadorEnum.EQUIPO1;

                }else if(gana2){
                    resultadoPronostico = GanadorEnum.EQUIPO2;
                } else if (empata) {
                    resultadoPronostico = GanadorEnum.EMPATE;
                }

                Pronostico pronostico = new Pronostico(fase, ronda, persona, partido, resultadoPronostico);


                this.agregarPronostico(pronostico);

            }
            con.close();

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }




    }



    private void agregarPronostico(Pronostico pronostico) {

        for(Pronostico p: this.pronosticos){
            if(p.getFase().equals(pronostico.getFase())
                    && p.getPartido().equals(pronostico.getPartido())
                    && p.getRonda().equals(pronostico.getRonda())
                    && p.getPersona().equals(pronostico.getPersona())){
                throw new RuntimeException("Ya hay un pronostico");
            }
        }

        this.pronosticos.add(pronostico);

    }

    private Persona obtenerPersona(String nombrePersona) {

        Persona persona = null;

        for(Persona p : this.personas){
            if (p.getNombre().equals(nombrePersona)){
                persona = p;
            }
        }
        if(persona == null){
            persona = new Persona(nombrePersona);
            this.personas.add(persona);
        }

        return persona;

    }
}
