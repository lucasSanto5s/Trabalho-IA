package com.ViagemTrem.iaapi.service;

import com.ViagemTrem.iaapi.algorithm.AlgoritmoBusca;
import com.ViagemTrem.iaapi.algorithm.AlgoritmoFactory;
import com.ViagemTrem.iaapi.model.Capital;
import com.ViagemTrem.iaapi.model.ResultadoBusca;
import org.springframework.stereotype.Service;

@Service
public class BuscaService {

    public ResultadoBusca buscar(String origem, String destino, String algoritmo) {
        AlgoritmoBusca algoritmoBusca = AlgoritmoFactory.getAlgoritmo(algoritmo);
        Capital capitalOrigem = new Capital(origem);
        Capital capitalDestino = new Capital(destino);
        return algoritmoBusca.buscar(capitalOrigem, capitalDestino);
    }
}
