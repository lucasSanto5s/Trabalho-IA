package com.ViagemTrem.iaapi.model;

import java.util.List;

public class ResultadoBusca {
    private List<String> rota;
    private double distanciaTotal;
    private int nosGerados;
    private int nosExpandidos;
    private long tempoExecucao;

    public ResultadoBusca(List<String> rota, double distanciaTotal, int nosGerados, int nosExpandidos, long tempoExecucao) {
        this.rota = rota;
        this.distanciaTotal = distanciaTotal;
        this.nosGerados = nosGerados;
        this.nosExpandidos = nosExpandidos;
        this.tempoExecucao = tempoExecucao;
    }

    public List<String> getRota() {
        return rota;
    }

    public double getDistanciaTotal() {
        return distanciaTotal;
    }

    public int getNosGerados() {
        return nosGerados;
    }

    public int getNosExpandidos() {
        return nosExpandidos;
    }

    public long getTempoExecucao() {
        return tempoExecucao;
    }
}
