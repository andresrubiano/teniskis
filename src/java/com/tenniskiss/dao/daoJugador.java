package com.tenniskiss.dao;

import com.tenniskiss.conexion.Conexion;
import com.tenniskiss.modelo.Jugador;
import com.tenniskiss.modelo.Torneo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class daoJugador extends Jugador {

    boolean m = false;
    private ArrayList<Jugador> listaJugadores = new ArrayList<>();

    public void guardarUsuario() {
        Conexion conexion = new Conexion();
        String sql = "insert into usuario values('" + getDocumento() + "','" + getNombre() + "','" + getApellido() + "','" + getNacionalidad() + "','" + getSexo() + "')";
        boolean b = conexion.CUD(sql);
        conexion.cerrarConexion();
        if (b) {
            b = true;
            mensaje(FacesMessage.SEVERITY_ERROR, "Error", "Se ha generado un error al guardar el usuario");
        } else {
            b = false;
            mensaje(FacesMessage.SEVERITY_INFO, "Información", "Se ha guardado el usuario");
        }
    }

    public void mensaje(FacesMessage.Severity x, String tituloMsj, String msj) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(x, tituloMsj, msj));
    }

    public void guardarJugador() {
        guardarUsuario();
        Conexion conexion = new Conexion();

        String sql = "insert into jugador values ('" + getDocumento() + "', '" + getRankingIndividual() + "', '" + getRankingDobles() + "')";
        boolean b = conexion.CUD(sql);
        conexion.cerrarConexion();
        if (b) {
            b = true;
            mensaje(FacesMessage.SEVERITY_ERROR, "Error", "Se ha generado un error al guardar el jugador");
        } else {
            b = false;
            mensaje(FacesMessage.SEVERITY_INFO, "Información", "Se ha guardado el jugador");
        }
        //guardarJugadorEnTorneo();
    }
    public ArrayList<Torneo> consultarTorneos(){
        ArrayList<Torneo> listaTorneo=new ArrayList<>();
        Conexion conexion = new Conexion();
        String sql = "SELECT nombre, fecha_inicio, fecha_fin FROM torneo";
        ResultSet r=conexion.consultar(sql);
        try {
            while (r.next()) {
                Torneo t=new Torneo();
                t.setNombre(r.getString(1));
                t.setFechaInicio(r.getString(2));
                t.setFechaFin(r.getString(2));
                listaTorneo.add(t);
            }
        } catch (SQLException ex) {
            Logger.getLogger(daoJugador.class.getName()).log(Level.SEVERE, null, ex);
        }
        conexion.cerrarConexion();
        return listaTorneo;
    }


    public long getTorneo() {
        return torneo;
    }

    public void setTorneo(long torneo) {
        this.torneo = torneo;
    }


    long torneo;

    public void guardarJugadorEnTorneo() {
        Conexion conexion = new Conexion();

        String sql = "insert into jugador_x_torneo values (null,'"+getDocumento()+"','"+getTorneo()+"')";
        boolean b = conexion.CUD(sql);
        conexion.cerrarConexion();
        if (b) {
            b = true;
            mensaje(FacesMessage.SEVERITY_ERROR, "Error", "Se ha generado un error al registrarse al torneo");
        } else {
            b = false;
            mensaje(FacesMessage.SEVERITY_INFO, "Información", "Se ha guardado el registro del torneo");
        }
        vaciar();
    }

    private void vaciar() {
        setApellido(null);
        setDocumento(0);
        setTorneo(0);
        setNacionalidad(null);
        setNombre(null);
        setRankingDobles(0);
        setRankingIndividual(0);
    }

    public ArrayList<Jugador> getListaJugadores() {
        String sql = "Select nombre, apellido, RankingIndividual, RankingDoble from usuario u inner join jugador j on u.documento=j.documento order by 3 asc";
        Conexion conexion = new Conexion();
        ResultSet r = conexion.consultar(sql);

        try {
            while (r.next()) {
                Jugador j = new Jugador();
                j.setNombre(r.getString(1));
                j.setApellido(r.getString(2));
                j.setRankingIndividual(r.getInt(3));
                j.setRankingDobles(r.getInt(4));
                listaJugadores.add(j);
            }
        } catch (SQLException ex) {
            Logger.getLogger(daoJugador.class.getName()).log(Level.SEVERE, null, ex);
        }
        conexion.cerrarConexion();
        return listaJugadores;
    }

    public void setListaJugadores(ArrayList<Jugador> listaJugadores) {
        this.listaJugadores = listaJugadores;
    }

}
