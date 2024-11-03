package com.ViagemTrem.iaapi.model;

public class Distancia {
    private int distanciaTrem;
    private double distanciaLinhaReta;

    public Distancia(int distanciaTrem, double distanciaLinhaReta) {
        this.distanciaTrem = distanciaTrem;
        this.distanciaLinhaReta = distanciaLinhaReta;
    }

    public int getDistanciaTrem() {
        return distanciaTrem;
    }

    public double getDistanciaLinhaReta() {
        return distanciaLinhaReta;
    }
}