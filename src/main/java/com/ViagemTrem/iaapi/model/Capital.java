package com.ViagemTrem.iaapi.model;

import java.util.HashMap;
import java.util.Map;

public class Capital {
    private String nome;
    private Map<Capital, Integer> vizinhos; // Vizinhos e suas distâncias
    private Capital pai; // Para reconstruir o caminho ao final
    private double Fn = 0; // Custo do caminho real ate a Capital + heurística para o destino
    private double Gn = Double.POSITIVE_INFINITY; // Custo do caminho real (trem) ate a Capital atual;
    private int nivel =0;


    public Capital(String nome) {
        this.nome = nome;
        this.vizinhos = new HashMap<>();

    }

    public Capital(Capital outraCapital) {
        this.nome = outraCapital.nome;
        this.vizinhos = new HashMap<>(outraCapital.vizinhos); // Cria um novo Map com os mesmos vizinhos e distâncias
        this.Fn = outraCapital.Fn;
        this.Gn = outraCapital.Gn;
        this.nivel = outraCapital.nivel;
    }

    // Método para adicionar um vizinho com as distâncias correspondentes
    public void adicionarVizinho(Capital vizinho, int distanciaTrem) {
        vizinhos.put(vizinho, distanciaTrem);
    }

    // Getter para obter os vizinhos
    public Map<Capital, Integer> getVizinhos() {
        return vizinhos;
    }

    // Getter para o nome da capital
    public String getNome() {
        return nome;
    }

    // Métodos para definir e obter o nó pai
    public void setPai(Capital pai) {
        this.pai = pai;
    }

    public Capital getPai() {
        return pai;
    }

    public double getFn() {
        return this.Fn;
    }

    public void setFn(double x) {
        this.Fn = x ;
    }

    public double getGn() {
        return  this.Gn;
    }

    public void setGn(double x) {
        this.Gn = x;
    }
  
    public int getNivel() {
        return this.nivel;
    }

    public void setNivel(int x) {
        this.nivel = x ;
    }
    // Método para calcular a distância de trem até outro vizinho, se o vizinho existir
    public int distanciaTremPara(Capital vizinho) {
        return vizinhos.getOrDefault(vizinho ,Integer.MAX_VALUE);
    }

   
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Capital capital = (Capital) obj;
        return nome.equals(capital.nome);
    }

    @Override
    public int hashCode() {
        return nome.hashCode();
    }
}