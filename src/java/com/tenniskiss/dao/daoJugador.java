package com.tenniskiss.dao;

import com.tenniskiss.conexion.Conexion;
import com.tenniskiss.modelo.Jugador;
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

    public void guardarJugador() {

        String query = "INSERT INTO `Jugador` (`documento`, `Nombre`, `apellido`, `nacionalidad`, `RankingIndividual`, `RankingDoble`, `Evento`) VALUES ";
        String values = "('" + getDocumento() + "', '" + getNombre() + "', '" + getApellido() + "', '" + getNacionalidad() + "', '" + getRankingIndividual() + "', '" + getRankingDobles() + "', '" + getEvento() + "');";
        String sql = query + values;

        Conexion conexion = new Conexion();
        boolean b = conexion.CUD(sql);
        if (b) {
            b = true;
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", "No se pudo guarda los datos, intente nuevamente"));
        } else {
            vaciar();
            b = false;
           
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardados", "Datos registrados satisfactoriamente."));
    
         
        }
        conexion.cerrarConexion();

    }

   

    private void vaciar() {
        setApellido(null);
        setDocumento(0);
        setEvento(null);
        setNacionalidad(null);
        setNombre(null);
        setRankingDobles(0);
        setRankingIndividual(0);
    }

    public ArrayList<Jugador> getListaJugadores() {
        String sql = "Select nombre, apellido, RankingIndividual, RankingDoble from jugador order by 3 asc";
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
