package com.ViagemTrem.iaapi.model;

import java.util.HashMap;
import java.util.Map;

public class MapaTeste {
    private Map<String, Capital> capitais;

    public MapaTeste() {
        capitais = new HashMap<>();

        // Criando capitais
        Capital portoAlegre = new Capital("Porto Alegre");
        Capital florianopolis = new Capital("Florianópolis");
        Capital curitiba = new Capital("Curitiba");
        Capital saoPaulo = new Capital("São Paulo");
        Capital rioDeJaneiro = new Capital("Rio de Janeiro");
        Capital beloHorizonte = new Capital("Belo Horizonte");
        Capital brasilia = new Capital("Brasília");
        Capital salvador = new Capital("Salvador");
        Capital cuiaba = new Capital("Cuiabá");
        Capital fortaleza = new Capital("Fortaleza");
        Capital manaus = new Capital("Manaus");

        // Adicionando capitais ao mapa
        capitais.put("Porto Alegre", portoAlegre);
        capitais.put("Florianópolis", florianopolis);
        capitais.put("Curitiba", curitiba);
        capitais.put("São Paulo", saoPaulo);
        capitais.put("Rio de Janeiro", rioDeJaneiro);
        capitais.put("Belo Horizonte", beloHorizonte);
        capitais.put("Brasília", brasilia);
        capitais.put("Salvador", salvador);
        capitais.put("Cuiabá", cuiaba);
        capitais.put("Fortaleza", fortaleza);
        capitais.put("Manaus", manaus);

        adicionarConexoes();
    }

    private void adicionarConexoes() {
        // Definindo conexões entre capitais e suas respectivas distâncias
        capitais.get("Porto Alegre").adicionarVizinho(capitais.get("Florianópolis"), 376);
        capitais.get("Porto Alegre").adicionarVizinho(capitais.get("São Paulo"), 852);

        capitais.get("Florianópolis").adicionarVizinho(capitais.get("Curitiba"), 251);
        capitais.get("Florianópolis").adicionarVizinho(capitais.get("Porto Alegre"), 376);

        capitais.get("Curitiba").adicionarVizinho(capitais.get("Florianópolis"), 251);
        capitais.get("Curitiba").adicionarVizinho(capitais.get("Rio de Janeiro"), 676);
        capitais.get("Curitiba").adicionarVizinho(capitais.get("São Paulo"), 339);

        capitais.get("São Paulo").adicionarVizinho(capitais.get("Belo Horizonte"), 490);
        capitais.get("São Paulo").adicionarVizinho(capitais.get("Curitiba"), 339);
        capitais.get("São Paulo").adicionarVizinho(capitais.get("Porto Alegre"), 852);
        capitais.get("São Paulo").adicionarVizinho(capitais.get("Salvador"), 1454);

        capitais.get("Rio de Janeiro").adicionarVizinho(capitais.get("Belo Horizonte"), 340);
        capitais.get("Rio de Janeiro").adicionarVizinho(capitais.get("Cuiabá"), 1576);
        capitais.get("Rio de Janeiro").adicionarVizinho(capitais.get("Curitiba"), 676);

        capitais.get("Belo Horizonte").adicionarVizinho(capitais.get("Brasília"), 600);
        capitais.get("Belo Horizonte").adicionarVizinho(capitais.get("Cuiabá"), 1373);
        capitais.get("Belo Horizonte").adicionarVizinho(capitais.get("São Paulo"), 490);
        capitais.get("Belo Horizonte").adicionarVizinho(capitais.get("Rio de Janeiro"), 340);

        capitais.get("Brasília").adicionarVizinho(capitais.get("Belo Horizonte"), 600);
        capitais.get("Brasília").adicionarVizinho(capitais.get("Fortaleza"), 1600);

        capitais.get("Salvador").adicionarVizinho(capitais.get("Fortaleza"), 1028);
        capitais.get("Salvador").adicionarVizinho(capitais.get("São Paulo"), 1454);

        capitais.get("Cuiabá").adicionarVizinho(capitais.get("Belo Horizonte"), 1373);
        capitais.get("Cuiabá").adicionarVizinho(capitais.get("Manaus"), 1453);
        capitais.get("Cuiabá").adicionarVizinho(capitais.get("Rio de Janeiro"), 1576);

        capitais.get("Fortaleza").adicionarVizinho(capitais.get("Manaus"), 2384);
        capitais.get("Fortaleza").adicionarVizinho(capitais.get("Salvador"), 1028);
        capitais.get("Fortaleza").adicionarVizinho(capitais.get("Brasília"), 1600);

        capitais.get("Manaus").adicionarVizinho(capitais.get("Cuiabá"), 1453);
        capitais.get("Manaus").adicionarVizinho(capitais.get("Fortaleza"), 2384);
    }


    public Capital getCapital(String nome) {
        return capitais.get(nome);
    }

    public Map<String, Capital> getCapitais() {
        return capitais;
    }
}