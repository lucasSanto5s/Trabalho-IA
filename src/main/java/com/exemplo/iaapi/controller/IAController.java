package com.exemplo.iaapi.controller;

import com.exemplo.iaapi.model.DadosEntrada;
import com.exemplo.iaapi.model.Resultado;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*") // Habilita CORS para todos os domínios
public class IAController {

    @PostMapping("/process")
    public Resultado processarDados(@RequestBody DadosEntrada dados) {
        double resultado = algoritmoIA(dados);
        return new Resultado(resultado);
    }

    private double algoritmoIA(DadosEntrada dados) {
        // Algoritmo simples de exemplo
        return dados.getValor1() * 2 + dados.getValor2();
    }
}

