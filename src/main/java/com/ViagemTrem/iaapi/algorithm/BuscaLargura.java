package com.ViagemTrem.iaapi.algorithm;

import com.ViagemTrem.iaapi.model.Capital;
import com.ViagemTrem.iaapi.model.Distancia;
import com.ViagemTrem.iaapi.model.MapaEuropa;
import com.ViagemTrem.iaapi.model.ResultadoBusca;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class BuscaLargura implements AlgoritmoBusca {

    @Override
    public ResultadoBusca buscar(Capital origem, Capital destinoParam) {
        long startTime = System.nanoTime();

        // Mapa de capitais
        MapaEuropa mapa = new MapaEuropa();

        // Fila para armazenar as capitais a serem visitadas
        Queue<Capital> fila = new LinkedList<>();

        // Set para armazenar capitais já visitadas
        Set<Capital> visitados = new HashSet<>();

        // Inicializar a fila com a capital de origem
        fila.add(mapa.getCapital(origem.getNome()));
        Capital destino = mapa.getCapital(destinoParam.getNome());

        origem.setPai(null); // O nó inicial não tem pai
        visitados.add(origem);

        int nosGerados = 1; // Contador de nós gerados (a origem é o primeiro nó)
        int nosExpandidos = 0; // Contador de nós expandidos
        Boolean encontrado = false;
        // Variáveis para o resultado
        List<String> rota = new ArrayList<>();
        double distanciaTotal = 0.0;

        // Busca em largura
        while (!fila.isEmpty() && encontrado == false) {
            Capital atual = fila.poll();
            nosExpandidos++;

            // Se o destino foi encontrado, reconstruímos o caminho e encerramos a busca

         
            // Para cada vizinho da capital atual, se ainda não foi visitado, adiciona à
            // fila
            for (Map.Entry<Capital, Distancia> vizinho : atual.getVizinhos().entrySet()) {
                Capital vizinhoCapital = vizinho.getKey();
              

                if (!visitados.contains(vizinhoCapital)) {

                    vizinhoCapital.setPai(atual); // Definimos o pai do vizinho para reconstruir a rota depois
                   
                    fila.add(vizinhoCapital);
                    visitados.add(vizinhoCapital);
                    nosGerados++;
                    
                    if (vizinhoCapital.equals(destino)) {
                        encontrado = true; // Encerra o loop ao encontrar o destino
                        Capital passo = destino;

                        while(passo!= null) {
                            
                            rota.add(0, passo.getNome()); // Adiciona o nome da capital ao início da rota
        
                            if (passo.getPai() != null) {
                                distanciaTotal += passo.getPai().distanciaTremPara(passo); // Soma a distância entre o nó e seu pai
                            }
        
                            passo = passo.getPai(); // Vai para o pai para continuar reconstruindo
                           
                        }
                    }
                }
            }

         
        }

        long endTime = System.nanoTime();
        long tempoExecucao = endTime - startTime;

        return new ResultadoBusca(rota, distanciaTotal, nosGerados, nosExpandidos, tempoExecucao);
    }

}
