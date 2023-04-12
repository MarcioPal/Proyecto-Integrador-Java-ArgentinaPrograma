/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proy_integrador;

import com.mycompany.proy_integrador.DB.Conectar;
import static com.mycompany.proy_integrador.Equipo.buscarEquipoPorId;
import static com.mycompany.proy_integrador.ResultadoEnum.EMPATE;
import static com.mycompany.proy_integrador.ResultadoEnum.GANADOR;
import static com.mycompany.proy_integrador.ResultadoEnum.PERDEDOR;
import static com.mycompany.proy_integrador.Pronostico.pronosticos;
import static com.mycompany.proy_integrador.Participante.participantes;
import static com.mycompany.proy_integrador.Equipo.equipos;
import static com.mycompany.proy_integrador.Partido.partidos;
import static com.mycompany.proy_integrador.Fase.fases;
import static com.mycompany.proy_integrador.Ronda.rondas;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class Main {

    public static void main(String[] args) {
        
        //TRAIGO TODO LOS DATOS DESDE LA DB Y RECONSTRUYO LOS OBJETOS

        try {

            Connection con = new Conectar().getConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM equipos");
            while (rs.next()) {
                equipos.add(new Equipo(rs.getLong("id"), rs.getString("nombre"), rs.getString("descripcion")));
            }

            rs = st.executeQuery("SELECT * FROM participantes");
            while (rs.next()) {
                participantes.add(new Participante(rs.getLong("id"), rs.getString("nombre"), rs.getString("apellido"), rs.getInt("dni")));
            }

            rs = st.executeQuery("SELECT * FROM partidos");
            while (rs.next()) {
                partidos.add(new Partido(rs.getLong("id"), Equipo.buscarEquipoPorId(equipos, rs.getLong("equipo1")), buscarEquipoPorId(equipos, rs.getLong("equipo2")), rs.getInt("golesEq1"), rs.getInt("golesEq2")));
            }

            rs = st.executeQuery("SELECT * FROM pronosticos");

            while (rs.next()) {
                pronosticos.add(new Pronostico(rs.getLong("id"), Partido.buscarPartidoPorId(partidos, rs.getLong("idPartido")), buscarEquipoPorId(equipos, rs.getLong("idEquipo")), getResultadoEnum(rs.getString("resultado")), Participante.buscarParticipantePorId(participantes, rs.getLong("idPart"))));
            }

            rs = st.executeQuery("SELECT * FROM fases");
            while (rs.next()) {
                fases.add(new Fase(rs.getInt("nroFase")));
            }

            Connection conn = new Conectar().getConexion();
            Statement stat = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM rondas");

            while (rs.next()) {  //Recorro cada ronda
                ArrayList<Partido> partidosRonda = new ArrayList<>();
                ResultSet p = stat.executeQuery("SELECT * FROM partidos");
                while (p.next()) { //Recorro cada partido
                    if (p.getInt("ronda") == rs.getInt("nroRonda")) {
                        partidosRonda.add(new Partido(p.getLong("id"), Equipo.buscarEquipoPorId(equipos, p.getLong("equipo1")), Equipo.buscarEquipoPorId(equipos, p.getLong("equipo2")), p.getInt("golesEq1"), p.getInt("golesEq2")));
                    }
                }
                Ronda ronda = new Ronda(rs.getInt("nroRonda"), partidosRonda);
                
                for (Fase f : fases) { //Recorro cada fase
                    if (rs.getInt("nroFase") == f.getNroFase()) { 
                        f.getRondas().add(ronda);
                    }
                }
                rondas.add(ronda);
            }

            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //MOSTRAR LOS RESULTADOS DE TODOS LOS PARTIDOS
        for (Ronda r : rondas) {
            System.out.println("\nResultados partidos Ronda nro: " + r.getNro() + "\n");
            for (Partido p : r.getPartidos()) {
                System.out.println(p.getEquipo1().getNombre() + " " + p.getGolesEquipo1() + "  " + p.getGolesEquipo2() + " " + p.getEquipo2().getNombre());
            }
        }

        System.out.println("\nPronosticos realizados: ");
        for (Pronostico pro : pronosticos) {
            System.out.println("\nParticipante: " + pro.getParticipante().getNombre() + " " + pro.getParticipante().getApellido() + "\n Partido: "
                    + pro.getPartido().getEquipo1().getNombre() + " vs "
                    + pro.getPartido().getEquipo2().getNombre()
                    + "\n Pronostico realizado: " + pro.getEquipo().getNombre() + " " + pro.getResultado());
        }

        System.out.println("\nPuntos por participante\n");
        for (Participante p : participantes) {
            System.out.println(p.getNombre() + " " + p.getApellido() + " " + p.getpuntosObtenidos(pronosticos, p) + " puntos");
        }

    }

    public static ResultadoEnum getResultadoEnum(String r) throws Exception {
        if (r.equals(GANADOR.name())) {
            return ResultadoEnum.GANADOR;
        } else {
            if (r.equals(PERDEDOR.name())) {
                return ResultadoEnum.PERDEDOR;
            } else {
                if (r.equals(EMPATE.name())) {
                    return ResultadoEnum.EMPATE;
                } else {
                    throw new Exception("Error resultado no coincide con alguno existente");
                }
            }
        }
    }
}
