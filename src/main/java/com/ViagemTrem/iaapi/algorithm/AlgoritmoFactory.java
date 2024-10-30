package com.ViagemTrem.iaapi.algorithm;

public class AlgoritmoFactory {

    public static AlgoritmoBusca getAlgoritmo(String tipo) {
        switch (tipo) {
            case "Largura":
                return new BuscaLargura();
            case "Aprofundamento Iterativo":
                return new AprofundamentoIterativo();
            case "A*":
                return new AEstrela();
            default:
                throw new IllegalArgumentException("Tipo de algoritmo não suportado");
        }
    }
}
