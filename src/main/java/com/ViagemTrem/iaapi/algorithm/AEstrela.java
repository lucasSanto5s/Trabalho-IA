package com.ViagemTrem.iaapi.algorithm;

import com.ViagemTrem.iaapi.model.Capital;
import com.ViagemTrem.iaapi.model.MapaEuropa;
import com.ViagemTrem.iaapi.model.MapaTeste;
import com.ViagemTrem.iaapi.model.ResultadoBusca;
import com.ViagemTrem.iaapi.service.DistanceCalculatorService;

import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;

public class AEstrela implements AlgoritmoBusca {

    private DistanceCalculatorService straightLineDistanceCalculator;


    @Override
    public ResultadoBusca buscar(Capital origemPAram, Capital destino) {
        try {
            straightLineDistanceCalculator = new DistanceCalculatorService();
        } catch (IOException e) {

            e.printStackTrace();
        }

        long startTime = System.nanoTime();

        // Mapa de capitais
         MapaEuropa mapa = new MapaEuropa();
        
         // caso deseje testar o mapa do Brasil descomentar
       //  MapaTeste mapa = new MapaTeste();

        // Implementação do algoritmo A*

        List<String> rota = new ArrayList<>();
        double distanciaTotal = 0.0;
        int nosGerados = 1;
        int nosExpandidos = 0;

        // Fila para armazenar as capitais a serem visitadas
        PriorityQueue<Capital> conjuntoAberto = new PriorityQueue<>(Comparator.comparingDouble(no -> no.getFn()));

        // Set para armazenar capitais já visitadas
        Set<Capital> conjuntoFechado = new HashSet<>();

        Capital origem = mapa.getCapital(origemPAram.getNome());
        origem.setGn(0);
        origem.setFn(straightLineDistanceCalculator.getDistance(origem.getNome(), destino.getNome()));

        conjuntoAberto.add(origem);

        while (!conjuntoAberto.isEmpty()) {
            Capital atual = conjuntoAberto.poll();

            nosExpandidos++;

            conjuntoFechado.add(atual);

         

            for (Map.Entry<Capital, Integer> vizinho : atual.getVizinhos().entrySet()) {
                Capital vizinhoCapital = vizinho.getKey();
                double custo = atual.getGn() + atual.distanciaTremPara(vizinhoCapital);
       
                if (custo < vizinhoCapital.getGn()) {
                    nosGerados++; // Caso a atualizaçao de uma rota com um Nodo ja existente conte como gerado

                    vizinhoCapital.setPai(atual); // Define o pai para reconstruir o caminho
                    vizinhoCapital.setGn(custo);
                    vizinhoCapital.setFn(custo  + straightLineDistanceCalculator.getDistance(vizinhoCapital.getNome(), destino.getNome()));

            
                    if (!conjuntoFechado.contains(vizinhoCapital)) {
                        if (!conjuntoAberto.contains(vizinhoCapital)) {
                            conjuntoAberto.add(vizinhoCapital);
                            // nosGerados++; Caso o Nodo só conte como gerado se não tiver existido antes
                            
                        }
                    }
                }
                
                // recontrói caminho
                if (vizinhoCapital.equals(destino)) {

                    Capital passo = vizinhoCapital;


                    while (passo != null) {

                        rota.add(0, passo.getNome()); // Adiciona o nome da capital ao início da rota

                        if (passo.getPai() != null) {
                            distanciaTotal += passo.getPai().distanciaTremPara(passo); // Soma a distância entre o nó e
                                                                                       // seu pai
                        }

                        passo = passo.getPai(); // Vai para o pai para continuar reconstruindo

                    }
                    long endTime = System.nanoTime();
                    long tempoExecucao = endTime - startTime;
                    return new ResultadoBusca(rota, distanciaTotal, nosGerados, nosExpandidos, tempoExecucao);
                }

            }


        }
        return null;
    }
}
