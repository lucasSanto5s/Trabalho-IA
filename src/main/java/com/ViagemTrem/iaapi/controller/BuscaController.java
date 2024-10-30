package com.ViagemTrem.iaapi.controller;

import com.ViagemTrem.iaapi.algorithm.AlgoritmoFactory;
import com.ViagemTrem.iaapi.model.Capital;
import com.ViagemTrem.iaapi.model.MapaEuropa;
import com.ViagemTrem.iaapi.model.ResultadoBusca;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class BuscaController {

    private final MapaEuropa mapaEuropa = new MapaEuropa();

    @PostMapping("/buscar")
    public ResultadoBusca buscar(@RequestParam String origem, @RequestParam String destino, @RequestParam String algoritmo) {
        Capital capitalOrigem = mapaEuropa.getCapital(origem);
        Capital capitalDestino = mapaEuropa.getCapital(destino);

        if (capitalOrigem == null || capitalDestino == null) {
            throw new IllegalArgumentException("Capital inválida");
        }

        return AlgoritmoFactory.getAlgoritmo(algoritmo).buscar(capitalOrigem, capitalDestino);
    }
}
