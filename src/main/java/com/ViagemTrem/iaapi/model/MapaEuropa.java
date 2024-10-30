package com.ViagemTrem.iaapi.model;

import java.util.HashMap;
import java.util.Map;

public class MapaEuropa {
    private Map<String, Capital> capitais;

    public MapaEuropa() {
        capitais = new HashMap<>();
        // Inicializar capitais e suas conexões
    }

    public Capital getCapital(String nome) {
        return capitais.get(nome);
    }

    public Map<String, Capital> getCapitais() {
        return capitais;
    }
}
