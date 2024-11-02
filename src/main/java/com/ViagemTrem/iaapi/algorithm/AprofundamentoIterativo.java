package com.ViagemTrem.iaapi.algorithm;

import com.ViagemTrem.iaapi.model.Capital;
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

public class AprofundamentoIterativo implements AlgoritmoBusca {

    @Override
    public  ResultadoBusca buscar(Capital origem, Capital destinoParam) {

        // long startTime = System.nanoTime(); descomente para usar

        // Mapa de capitais
        MapaEuropa mapa = new MapaEuropa();

        // Variáveis para o resultado
        List<String> rota = new ArrayList<>();
        double distanciaTotal = 0.0;
        int nosGerados = 0; // Contador de nós gerados
        int nosExpandidos = 0; // Contador de nós expandidos
        Capital destino = mapa.getCapital(destinoParam.getNome());

        // Aprofundamento Iterativo, vai aumentado o limite a cada tentiva
        for (int limite = 0; limite < Integer.MAX_VALUE; limite++) {
            Set<Capital> visitados = new HashSet<>();

            ResultadoBusca result = buscarComLimite(origem, destino, limite, visitados, nosGerados, nosExpandidos);

            if (result != null) {
                // long endTime = System.nanoTime(); descomente para usar
                // result.setTempoExecucao(endTime - startTime); descomente para usar
                return result;
            }
        }
        return null; // Se o destino não for encontrado (apenas por segurança)
    }

    private ResultadoBusca buscarComLimite(Capital atual, Capital destino, int limite, Set<Capital> visitados,
            int nosGerados, int nosExpandidos) {
        // Verifica se a profundidade limite foi atingida
        if (limite == 0) {
            return null;
        }

        // Marca o nó como visitado e expande
        visitados.add(atual);
        nosExpandidos++;

        // Se encontrou o destino, inicia a reconstrução do caminho
        if (atual.equals(destino)) {
            List<String> rota = new ArrayList<>();
            double distanciaTotal = 0.0;
            Capital passo = destino;

            while (passo != null) {
                rota.add(0, passo.getNome()); // Adiciona o nome da capital ao início da rota

                if (passo.getPai() != null) {
                    distanciaTotal += passo.getPai().distanciaPara(passo); // Soma a distância entre o nó e seu pai
                }

                passo = passo.getPai(); // Vai para o pai para continuar reconstruindo
            }

            return new ResultadoBusca(rota, distanciaTotal, nosGerados, nosExpandidos, 0); // Tempo de execução será atualizado mais tarde
        }

        // Expande para cada vizinho, se ainda não foi visitado
        for (Map.Entry<Capital, Integer> vizinho : atual.getVizinhos().entrySet()) {
            Capital vizinhoCapital = vizinho.getKey();

            if (!visitados.contains(vizinhoCapital)) {
                vizinhoCapital.setPai(atual); // Define o pai para reconstruir o caminho depois
                nosGerados++;

                ResultadoBusca result = buscarComLimite(vizinhoCapital, destino, limite - 1, visitados, nosGerados,nosExpandidos); //reduz o limite, se n encontrar nada ele vai entrar no if(limite == 0)
                if (result != null) {
                    return result; // Encerra a busca se encontrar o destino
                }

                // Remove o nó do conjunto de visitados para permitir outras iterações no
                // aprofundamento iterativo
                visitados.remove(vizinhoCapital);
            }
        }

         return null; // Retorna null se não encontrou o destino nesta profundidade
    }
    


}
