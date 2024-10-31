package com.ViagemTrem.iaapi.model;

import java.util.HashMap;
import java.util.Map;

public class Capital {
    private String nome;
    private Map<Capital, Integer> vizinhos; // Vizinhos e distância para cada um deles
    private Capital pai; // Para reconstruir o caminho ao final
    private double estimativa; // Heurística para o algoritmo A*

    public Capital(String nome) {
        this.nome = nome;
        this.vizinhos = new HashMap<>();
    }

    // Método para adicionar um vizinho com a distância correspondente
    public void adicionarVizinho(Capital vizinho, int distancia) {
        vizinhos.put(vizinho, distancia);
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

    // Método para definir a estimativa (distância heurística para o destino)
    public void setEstimativa(double estimativa) {
        this.estimativa = estimativa;
    }

    public double getEstimativa() {
        return estimativa;
    }

    // Método para calcular a distância até outro vizinho, se o vizinho existir
    public int distanciaPara(Capital vizinho) {
        return vizinhos.getOrDefault(vizinho, Integer.MAX_VALUE); // Retorna uma distância muito grande se não forem vizinhos
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
