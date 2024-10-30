package com.ViagemTrem.iaapi.algorithm;

import com.ViagemTrem.iaapi.model.Capital;
import com.ViagemTrem.iaapi.model.ResultadoBusca;

public interface AlgoritmoBusca {
    ResultadoBusca buscar(Capital origem, Capital destino);
}
