package com.ViagemTrem.iaapi.algorithm;

import com.ViagemTrem.iaapi.model.Capital;
import com.ViagemTrem.iaapi.model.MapaEuropa;
import com.ViagemTrem.iaapi.model.ResultadoBusca;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.ArrayList;
import java.util.HashSet;

public class AprofundamentoIterativo implements AlgoritmoBusca {

    long startTime = System.nanoTime();
    int resets = 0;

    @Override
    public ResultadoBusca buscar(Capital origem, Capital destino) {
        long startTime = System.nanoTime();

        // Mapa de capitais
        MapaEuropa mapa = new MapaEuropa();

        int nosGerados = 1; // Contador de nós gerados (a origem é o primeiro nó)
        int nosExpandidos = 0; // Contador de nós expandidos
        Boolean encontrado = false;
        // Variáveis para o resultado
        List<String> rota = new ArrayList<>();
        double distanciaTotal = 0.0;

        for (int profundidadeLimite = 0; encontrado == false; profundidadeLimite++) {

            // Substitua a fila por uma pilha para realizar a busca em profundidade
            Stack<Capital> pilha = new Stack<>();

            // Set para armazenar capitais já visitadas
            Set<Capital> visitados = new HashSet<>();

            // Inicialize a pilha com a capital de origem
            pilha.push(mapa.getCapital(origem.getNome()));

            origem.setPai(null); // O nó inicial não tem pai
            visitados.add(origem);

            nosGerados = 1;
            nosExpandidos = 0;

            // Busca em profundidade (DFS) usando uma pilha
            while (!pilha.isEmpty() && encontrado == false) {
                Capital atual = pilha.pop(); // Remova o elemento do topo da pilha
                nosExpandidos++;


                // Se a profundidade do nó atual for maior que o limite, não expanda seus
                // vizinhos
                int profundidadeAtual = obterProfundidade(atual);


                if (profundidadeAtual < profundidadeLimite) {
                    for (Map.Entry<Capital, Integer> vizinho : atual.getVizinhos().entrySet()) {

                        Capital vizinhoCapital = vizinho.getKey();

                        if (!visitados.contains(vizinhoCapital)) {

                            vizinhoCapital.setPai(atual); // Definimos o pai do vizinho para reconstruir a rota depois

                            pilha.push(vizinhoCapital); // Adiciona o vizinho ao topo da pilha
                            visitados.add(vizinhoCapital);
                            nosGerados++;

                            // Se o destino foi encontrado, reconstruímos o caminho e encerramos a busca
                            if (vizinhoCapital.equals(destino)) {
                                encontrado = true;
                                Capital passo = vizinhoCapital;

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

                            }

                        }
                    }
                }


            }

        }
        long endTime = System.nanoTime();
        long tempoExecucao = endTime - startTime;

        return new ResultadoBusca(rota, distanciaTotal, nosGerados, nosExpandidos,
                tempoExecucao);

    }

    // Método para calcular a profundidade de um nó
    private int obterProfundidade(Capital capital) {
        int profundidade = 0;
        while (capital.getPai() != null) {
            profundidade++;
            capital = capital.getPai();
        }
        return profundidade;
    }

}
