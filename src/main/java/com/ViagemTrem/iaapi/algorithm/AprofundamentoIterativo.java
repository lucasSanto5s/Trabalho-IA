package com.ViagemTrem.iaapi.algorithm;

import com.ViagemTrem.iaapi.model.Capital;
import com.ViagemTrem.iaapi.model.ResultadoBusca;
import java.util.List;
import java.util.ArrayList;

public class AprofundamentoIterativo implements AlgoritmoBusca {

    @Override
    public ResultadoBusca buscar(Capital origem, Capital destino) {
        long startTime = System.nanoTime();
        
        // Implementação do algoritmo de aprofundamento iterativo
        List<String> rota = new ArrayList<>();
        double distanciaTotal = 0.0;
        int nosGerados = 0;
        int nosExpandidos = 0;
        
        long endTime = System.nanoTime();
        long tempoExecucao = endTime - startTime;
        
        return new ResultadoBusca(rota, distanciaTotal, nosGerados, nosExpandidos, tempoExecucao);
    }
}
