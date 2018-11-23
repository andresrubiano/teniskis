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
public class Jugador extends Usuario{
    private int rankingIndividual;
    private int rankingDobles;

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
    
}
