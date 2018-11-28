/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tenniskiss.dao;

import com.tenniskiss.conexion.Conexion;
import com.tenniskiss.modelo.Jugador;
import com.tenniskiss.modelo.JugadorPorTorneo;
import com.tenniskiss.modelo.Torneo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author jhon
 */
@ManagedBean
public class DaoTorneo extends Torneo {

    public void crearTorneo() {
        Conexion conexion = new Conexion();

        String sql = "insert into torneo values (null, '" + getNombre() + "', '" + getFechaInicio() + "', '" + getFechaFin() + "')";
        boolean b = conexion.CUD(sql);
        conexion.cerrarConexion();
        if (b) {
            b = true;
            mensaje(FacesMessage.SEVERITY_ERROR, "Error", "Se ha generado un error al guardar el torneo");
        } else {
            b = false;
            mensaje(FacesMessage.SEVERITY_INFO, "Información", "Se ha guardado el torneo");
        }
        vaciar();
    }

    public void mensaje(FacesMessage.Severity x, String tituloMsj, String msj) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(x, tituloMsj, msj));
    }
    private ArrayList<Torneo> torneos = new ArrayList<Torneo>();

    public ArrayList<Torneo> getTorneos() {

        String sql = "Select idtorneo, nombre,fecha_inicio,fecha_fin from torneo";
        Conexion conexion = new Conexion();
        ResultSet r = conexion.consultar(sql);

        try {
            while (r.next()) {
                Torneo t = new Torneo();
                t.setIdTorneo(r.getLong(1));
                t.setNombre(r.getString(2));
                t.setFechaFin(r.getString(3));
                t.setFechaInicio(r.getString(4));

                torneos.add(t);
            }
        } catch (SQLException ex) {
            Logger.getLogger(daoJugador.class.getName()).log(Level.SEVERE, null, ex);
        }
        conexion.cerrarConexion();

        return torneos;
    }

    private void vaciar() {
        setIdTorneo(0);
        setNombre(null);
        setFechaFin(null);
        setFechaInicio(null);
    }
    private ArrayList<JugadorPorTorneo> UsuarioPorTorneo = new ArrayList<JugadorPorTorneo>();

    public ArrayList<JugadorPorTorneo> getUsuarioPorTorneo() {
        String sql = "select u.nombre,u.apellido, idtorneo, t.nombre, fecha_inicio, fecha_fin from usuario u natural join jugador j inner join jugador_x_torneo on j.documento=jugador_documento inner join torneo t on idtorneo=torneo_idtorneo;";
        Conexion conexion = new Conexion();
        ResultSet r = conexion.consultar(sql);

        try {
            while (r.next()) {
                JugadorPorTorneo jpt = new JugadorPorTorneo();
                jpt.setNombreJugador(r.getString(1));
                jpt.setApellidoJugador(r.getString(2));
                jpt.setTorneoIdtorneo(r.getLong(3));
                jpt.setNombreTorneo(r.getString(4));
                jpt.setFechaFin(r.getString(5));
                jpt.setFechaInicio(r.getString(6));

                UsuarioPorTorneo.add(jpt);
            }
        } catch (SQLException ex) {
            Logger.getLogger(daoJugador.class.getName()).log(Level.SEVERE, null, ex);
        }
        conexion.cerrarConexion();
        return UsuarioPorTorneo;
    }

}
