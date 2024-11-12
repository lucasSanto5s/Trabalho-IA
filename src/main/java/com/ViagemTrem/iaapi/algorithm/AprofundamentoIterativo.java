package com.ViagemTrem.iaapi.algorithm;

import com.ViagemTrem.iaapi.model.Capital;
import com.ViagemTrem.iaapi.model.MapaEuropa;
import com.ViagemTrem.iaapi.model.MapaTeste;
import com.ViagemTrem.iaapi.model.ResultadoBusca;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.ArrayList;


public class AprofundamentoIterativo implements AlgoritmoBusca {

    @Override
    public ResultadoBusca buscar(Capital origem, Capital destino) {
        long startTime = System.nanoTime();

        // Mapa de capitais
        MapaEuropa mapa = new MapaEuropa();

        int nosGerados = 1; // Contador de nós gerados (a origem é o primeiro nó)
        int nosExpandidos = 0; // Contador de nós expandidos

        // Variáveis para o resultado
        List<String> rota = new ArrayList<>();
        double distanciaTotal = 0.0;

        for (int profundidadeLimite = 0; profundidadeLimite <= 10; profundidadeLimite++) {

            // Substitua a fila por uma pilha para realizar a busca em profundidade
            Stack<Capital> pilha = new Stack<>();

            // Inicialize a pilha com a capital de origem
            pilha.push(mapa.getCapital(origem.getNome()));

            origem.setPai(null); // O nó inicial não tem pai
            nosGerados = 1;
            nosExpandidos = 0;

            // Busca em profundidade (DFS) usando uma pilha
            while (!pilha.isEmpty()) {
                Capital atual = pilha.pop(); // Remova o elemento do topo da pilha

                nosExpandidos++;
                for (Map.Entry<Capital, Integer> vizinho : atual.getVizinhos().entrySet()) {
                
                    Capital vizinhoCapital =new Capital(vizinho.getKey());

                    if (vizinhoCapital.equals(destino)) {

                        Capital passo = vizinhoCapital;

                        nosGerados++;

                        vizinhoCapital.setPai(atual); // Definimos o pai do vizinho para reconstruir a rota depois
                        vizinhoCapital.setNivel(atual.getNivel() + 1);

                        while (passo != null) {
                            rota.add(0, passo.getNome()); // Adiciona o nome da capital ao início da rota

                            if (passo.getPai() != null) {
                                distanciaTotal += passo.getPai().distanciaTremPara(passo); // Soma a distância
                                                                                           // entre
                                                                                           // o
                                                                                           // nó e seu
                                                                                           // pai
                            }

                            passo = passo.getPai(); // Vai para o pai para continuar reconstruindo
                        }

                        long endTime = System.nanoTime();
                        long tempoExecucao = endTime - startTime;

                        return new ResultadoBusca(rota, distanciaTotal, nosGerados, nosExpandidos,
                                tempoExecucao);

                    } else if (atual.getPai() == null || !vizinhoCapital.equals(atual.getPai())) {

                        nosGerados++;

                        vizinhoCapital.setPai(atual); // Definimos o pai do vizinho para reconstruir a rota depois
                        vizinhoCapital.setNivel(atual.getNivel() + 1);
                        if (atual.getNivel() + 1 < profundidadeLimite) {
                            pilha.push(vizinhoCapital);
                        }

                    }

                }

            }

        }
        return null;

    }

}
