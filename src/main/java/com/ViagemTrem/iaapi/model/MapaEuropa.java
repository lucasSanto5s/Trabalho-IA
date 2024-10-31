package com.ViagemTrem.iaapi.model;

import java.util.HashMap;
import java.util.Map;

public class MapaEuropa {
    private Map<String, Capital> capitais;

    public MapaEuropa() {
        capitais = new HashMap<>();

        // Criando capitais com os nomes dos países
        Capital albania = new Capital("Albânia");
        Capital alemanha = new Capital("Alemanha");
        Capital andorra = new Capital("Andorra");
        Capital armenia = new Capital("Armênia");
        Capital austria = new Capital("Áustria");
        Capital azerbaijao = new Capital("Azerbaijão");
        Capital belgica = new Capital("Bélgica");
        Capital bielorrussia = new Capital("Bielorrússia");
        Capital bosniaHerzegovina = new Capital("Bósnia-Herzegovina");
        Capital bulgaria = new Capital("Bulgária");
        Capital cazaquistao = new Capital("Cazaquistão");
        Capital croacia = new Capital("Croácia");
        Capital dinamarca = new Capital("Dinamarca");
        Capital eslovaquia = new Capital("Eslováquia");
        Capital eslovenia = new Capital("Eslovênia");
        Capital espanha = new Capital("Espanha");
        Capital estonia = new Capital("Estônia");
        Capital finlandia = new Capital("Finlândia");
        Capital frança = new Capital("França");
        Capital georgia = new Capital("Geórgia");
        Capital grecia = new Capital("Grécia");
        Capital hungria = new Capital("Hungria");
        Capital italia = new Capital("Itália");
        Capital kosovo = new Capital("Kosovo");
        Capital letonia = new Capital("Letônia");
        Capital litvania = new Capital("Lituânia");
        Capital liechtenstein = new Capital("Liechtenstein");
        Capital luxemburgo = new Capital("Luxemburgo");
        Capital macedoniaNorte = new Capital("Macedônia do Norte");
        Capital moldavia = new Capital("Moldávia");
        Capital monaco = new Capital("Mônaco");
        Capital montenegro = new Capital("Montenegro");
        Capital noruega = new Capital("Noruega");
        Capital paisesBaixos = new Capital("Países Baixos");
        Capital polonia = new Capital("Polônia");
        Capital portugal = new Capital("Portugal");
        Capital inglaterra = new Capital("Inglaterra");
        Capital romenia = new Capital("Romênia");
        Capital russia = new Capital("Rússia");
        Capital sanMarino = new Capital("San Marino");
        Capital servia = new Capital("Sérvia");
        Capital suecia = new Capital("Suécia");
        Capital suica = new Capital("Suíça");
        Capital republicaTcheca = new Capital("República Tcheca");
        Capital ucrania = new Capital("Ucrânia");
        Capital vaticano = new Capital("Vaticano");

        // Adicionando as capitais ao mapa
        capitais.put("Albânia", albania);
        capitais.put("Alemanha", alemanha);
        capitais.put("Andorra", andorra);
        capitais.put("Armênia", armenia);
        capitais.put("Áustria", austria);
        capitais.put("Azerbaijão", azerbaijao);
        capitais.put("Bélgica", belgica);
        capitais.put("Bielorrússia", bielorrussia);
        capitais.put("Bósnia-Herzegovina", bosniaHerzegovina);
        capitais.put("Bulgária", bulgaria);
        capitais.put("Cazaquistão", cazaquistao);
        capitais.put("Croácia", croacia);
        capitais.put("Dinamarca", dinamarca);
        capitais.put("Eslováquia", eslovaquia);
        capitais.put("Eslovênia", eslovenia);
        capitais.put("Espanha", espanha);
        capitais.put("Estônia", estonia);
        capitais.put("Finlândia", finlandia);
        capitais.put("França", frança);
        capitais.put("Geórgia", georgia);
        capitais.put("Grécia", grecia);
        capitais.put("Hungria", hungria);
        capitais.put("Itália", italia);
        capitais.put("Kosovo", kosovo);
        capitais.put("Letônia", letonia);
        capitais.put("Lituânia", litvania);
        capitais.put("Liechtenstein", liechtenstein);
        capitais.put("Luxemburgo", luxemburgo);
        capitais.put("Macedônia do Norte", macedoniaNorte);
        capitais.put("Moldávia", moldavia);
        capitais.put("Mônaco", monaco);
        capitais.put("Montenegro", montenegro);
        capitais.put("Noruega", noruega);
        capitais.put("Países Baixos", paisesBaixos);
        capitais.put("Polônia", polonia);
        capitais.put("Portugal", portugal);
        capitais.put("Inglaterra", inglaterra);
        capitais.put("Romênia", romenia);
        capitais.put("Rússia", russia);
        capitais.put("San Marino", sanMarino);
        capitais.put("Sérvia", servia);
        capitais.put("Suécia", suecia);
        capitais.put("Suíça", suica);
        capitais.put("República Tcheca", republicaTcheca);
        capitais.put("Ucrânia", ucrania);
        capitais.put("Vaticano", vaticano);
    }

    public Capital getCapital(String nome) {
        return capitais.get(nome);
    }

    public Map<String, Capital> getCapitais() {
        return capitais;
    }
}
