
package com.tenniskiss.modelo;
public class Jugador {
    private long documento;
    private String nombre;
    private String apellido;
    private String nacionalidad;
    private int rankingIndividual;
    private int rankingDobles;

    private String evento;
    
    public long getDocumento() {
        return documento;
    }

    public void setDocumento(long documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public int getRankingIndividual() {
        return rankingIndividual;
    }

    public void setRankingIndividual(int rankingIndividual) {
        this.rankingIndividual = rankingIndividual;
    }

    public int getRankingDobles() {
        return rankingDobles;
    }

    public void setRankingDobles(int rankingDobles) {
        this.rankingDobles = rankingDobles;
    }

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }
    
}
