/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tenniskiss.modelo;

/**
 *
 * @author jhon
 */
public class JugadorPorTorneo {
    private long idJugadorTorneo;
    private long torneoIdtorneo;
    private long jugadorDocumento;
    private String nombreTorneo;
    private String nombreJugador;
    private String apellidoJugador;
    private String fechaFin;
    private String fechaInicio;
    

    public long getIdJugadorTorneo() {
        return idJugadorTorneo;
    }

    public void setIdJugadorTorneo(long idJugadorTorneo) {
        this.idJugadorTorneo = idJugadorTorneo;
    }

    public long getTorneoIdtorneo() {
        return torneoIdtorneo;
    }

    public void setTorneoIdtorneo(long torneoIdtorneo) {
        this.torneoIdtorneo = torneoIdtorneo;
    }

    public long getJugadorDocumento() {
        return jugadorDocumento;
    }

    public void setJugadorDocumento(long jugadorDocumento) {
        this.jugadorDocumento = jugadorDocumento;
    }

    public String getNombreTorneo() {
        return nombreTorneo;
    }

    public void setNombreTorneo(String nombreTorneo) {
        this.nombreTorneo = nombreTorneo;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public String getApellidoJugador() {
        return apellidoJugador;
    }

    public void setApellidoJugador(String apellidoJugador) {
        this.apellidoJugador = apellidoJugador;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
}
