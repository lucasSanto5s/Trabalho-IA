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

        adicionarConexoes();
    }

    // Método para adicionar conexões entre as capitais
    private void adicionarConexoes() {
        // Conexões para Tirana
        capitais.get("Albânia").adicionarVizinho(capitais.get("Montenegro"), 160); // Podgorica
        capitais.get("Albânia").adicionarVizinho(capitais.get("Kosovo"), 250); // Pristina
        capitais.get("Albânia").adicionarVizinho(capitais.get("Macedônia do Norte"), 290); // Skopje
        capitais.get("Albânia").adicionarVizinho(capitais.get("Grécia"), 530); // Atenas

        // Conexões para Berlim
        capitais.get("Alemanha").adicionarVizinho(capitais.get("Polônia"), 570); // Varsóvia
        capitais.get("Alemanha").adicionarVizinho(capitais.get("República Tcheca"), 350); // Praga
        capitais.get("Alemanha").adicionarVizinho(capitais.get("Áustria"), 680); // Viena
        capitais.get("Alemanha").adicionarVizinho(capitais.get("Suíça"), 850); // Zurique
        capitais.get("Alemanha").adicionarVizinho(capitais.get("França"), 1050); // Paris
        capitais.get("Alemanha").adicionarVizinho(capitais.get("Luxemburgo"), 750); // Luxemburgo
        capitais.get("Alemanha").adicionarVizinho(capitais.get("Bélgica"), 770); // Bruxelas

        // Conexões para Andorra
        capitais.get("Andorra").adicionarVizinho(capitais.get("Espanha"), 494); // Madrid
        capitais.get("Andorra").adicionarVizinho(capitais.get("França"), 864); // Paris

        // Conexões para Yerevan
        capitais.get("Armênia").adicionarVizinho(capitais.get("Geórgia"), 375); // Tbilisi
        capitais.get("Armênia").adicionarVizinho(capitais.get("Azerbaijão"), 460); // Baku
        capitais.get("Armênia").adicionarVizinho(capitais.get("Turquia"), 1215); // Ankara
        capitais.get("Armênia").adicionarVizinho(capitais.get("Irã"), 790); // Teerã

        // Conexões para Viena
        capitais.get("Áustria").adicionarVizinho(capitais.get("Eslováquia"), 82); // Bratislava
        capitais.get("Áustria").adicionarVizinho(capitais.get("República Tcheca"), 254); // Praga
        capitais.get("Áustria").adicionarVizinho(capitais.get("Hungria"), 212); // Budapeste
        capitais.get("Áustria").adicionarVizinho(capitais.get("Eslovênia"), 380); // Ljubljana
        capitais.get("Áustria").adicionarVizinho(capitais.get("Suíça"), 800); // Berna
        capitais.get("Áustria").adicionarVizinho(capitais.get("Itália"), 1150); // Roma

        // Conexões para Baku
        capitais.get("Azerbaijão").adicionarVizinho(capitais.get("Armênia"), 293); // Yerevan
        capitais.get("Azerbaijão").adicionarVizinho(capitais.get("Geórgia"), 546); // Tbilisi
        capitais.get("Azerbaijão").adicionarVizinho(capitais.get("Irã"), 650); // Teerã

        // Conexões para Bruxelas
        capitais.get("Bélgica").adicionarVizinho(capitais.get("França"), 264); // Paris
        capitais.get("Bélgica").adicionarVizinho(capitais.get("Países Baixos"), 173); // Amsterdã
        capitais.get("Bélgica").adicionarVizinho(capitais.get("Luxemburgo"), 183); // Luxemburgo
        capitais.get("Bélgica").adicionarVizinho(capitais.get("Alemanha"), 650); // Berlim

        // Conexões para Minsk
        capitais.get("Bielorrússia").adicionarVizinho(capitais.get("Rússia"), 675); // Moscou
        capitais.get("Bielorrússia").adicionarVizinho(capitais.get("Ucrânia"), 560); // Kiev
        capitais.get("Bielorrússia").adicionarVizinho(capitais.get("Polônia"), 400); // Varsóvia
        capitais.get("Bielorrússia").adicionarVizinho(capitais.get("Lituânia"), 180); // Vilnius
        capitais.get("Bielorrússia").adicionarVizinho(capitais.get("Letônia"), 550); // Riga

        // Conexões para Sarajevo
        capitais.get("Bósnia-Herzegovina").adicionarVizinho(capitais.get("Croácia"), 390); // Zagreb
        capitais.get("Bósnia-Herzegovina").adicionarVizinho(capitais.get("Sérvia"), 300); // Belgrado
        capitais.get("Bósnia-Herzegovina").adicionarVizinho(capitais.get("Montenegro"), 230); // Podgorica

        // Conexões para Sofia
        capitais.get("Bulgária").adicionarVizinho(capitais.get("Romênia"), 297); // Bucareste
        capitais.get("Bulgária").adicionarVizinho(capitais.get("Sérvia"), 395); // Belgrado
        capitais.get("Bulgária").adicionarVizinho(capitais.get("Macedônia do Norte"), 240); // Skopje
        capitais.get("Bulgária").adicionarVizinho(capitais.get("Grécia"), 785); // Atenas
        capitais.get("Bulgária").adicionarVizinho(capitais.get("Turquia"), 800); // Ancara

        // Conexões para Nur-Sultan
        capitais.get("Cazaquistão").adicionarVizinho(capitais.get("Rússia"), 2271); // Moscou
        capitais.get("Cazaquistão").adicionarVizinho(capitais.get("China"), 2860); // Pequim
        capitais.get("Cazaquistão").adicionarVizinho(capitais.get("Quirguistão"), 1040); // Bishkek
        capitais.get("Cazaquistão").adicionarVizinho(capitais.get("Uzbequistão"), 1740); // Tashkent
        capitais.get("Cazaquistão").adicionarVizinho(capitais.get("Turcomenistão"), 2650); // Ashgabat

        // Conexões para Zagreb
        capitais.get("Croácia").adicionarVizinho(capitais.get("Eslovênia"), 140); // Ljubljana
        capitais.get("Croácia").adicionarVizinho(capitais.get("Hungria"), 345); // Budapeste
        capitais.get("Croácia").adicionarVizinho(capitais.get("Sérvia"), 500); // Belgrado
        capitais.get("Croácia").adicionarVizinho(capitais.get("Bósnia-Herzegovina"), 430); // Sarajevo
        capitais.get("Croácia").adicionarVizinho(capitais.get("Montenegro"), 610); // Podgorica

        // Conexões para Copenhague
        capitais.get("Dinamarca").adicionarVizinho(capitais.get("Suécia"), 522); // Estocolmo
        capitais.get("Dinamarca").adicionarVizinho(capitais.get("Noruega"), 483); // Oslo
        capitais.get("Dinamarca").adicionarVizinho(capitais.get("Alemanha"), 356); // Berlim

        // Conexões para Bratislava
        capitais.get("Eslováquia").adicionarVizinho(capitais.get("Áustria"), 65); // Viena
        capitais.get("Eslováquia").adicionarVizinho(capitais.get("Hungria"), 200); // Budapeste
        capitais.get("Eslováquia").adicionarVizinho(capitais.get("República Tcheca"), 330); // Praga
        capitais.get("Eslováquia").adicionarVizinho(capitais.get("Polônia"), 500); // Varsóvia
        capitais.get("Eslováquia").adicionarVizinho(capitais.get("Ucrânia"), 800); // Kiev

        // Conexões para Liubliana
        capitais.get("Eslovênia").adicionarVizinho(capitais.get("Croácia"), 112); // Zagreb
        capitais.get("Eslovênia").adicionarVizinho(capitais.get("Áustria"), 380); // Viena
        capitais.get("Eslovênia").adicionarVizinho(capitais.get("Hungria"), 460); // Budapeste
        capitais.get("Eslovênia").adicionarVizinho(capitais.get("Itália"), 600); // Roma

        // Conexões para Madri
        capitais.get("Espanha").adicionarVizinho(capitais.get("Portugal"), 640); // Lisboa
        capitais.get("Espanha").adicionarVizinho(capitais.get("França"), 1300); // Paris
        capitais.get("Espanha").adicionarVizinho(capitais.get("Andorra"), 200); // Andorra la Vella

        // Conexões para Tallinn
        capitais.get("Estônia").adicionarVizinho(capitais.get("Letônia"), 213); // Riga
        capitais.get("Estônia").adicionarVizinho(capitais.get("Finlândia"), 80); // Helsinque (por ferry)

        // Conexões para Helsinque
        capitais.get("Finlândia").adicionarVizinho(capitais.get("Estônia"), 80); // Tallinn (por ferry)
        capitais.get("Finlândia").adicionarVizinho(capitais.get("Suécia"), 765); // Estocolmo (por ferry)

        // Conexões para Paris
        capitais.get("França").adicionarVizinho(capitais.get("Bélgica"), 320); // Bruxelas
        capitais.get("França").adicionarVizinho(capitais.get("Luxemburgo"), 290); // Luxemburgo
        capitais.get("França").adicionarVizinho(capitais.get("Alemanha"), 1050); // Berlim
        capitais.get("França").adicionarVizinho(capitais.get("Suíça"), 650); // Bern
        capitais.get("França").adicionarVizinho(capitais.get("Espanha"), 1300); // Madri

        // Conexões para Tbilisi
        capitais.get("Geórgia").adicionarVizinho(capitais.get("Armênia"), 262); // Yerevan
        capitais.get("Geórgia").adicionarVizinho(capitais.get("Azerbaijão"), 532); // Baku
        capitais.get("Geórgia").adicionarVizinho(capitais.get("Turquia"), 1446); // Ancara

        // Conexões para Atenas
        capitais.get("Grécia").adicionarVizinho(capitais.get("Albânia"), 452); // Tirana
        capitais.get("Grécia").adicionarVizinho(capitais.get("Macedônia do Norte"), 792); // Skopje
        capitais.get("Grécia").adicionarVizinho(capitais.get("Bulgária"), 493); // Sofia
        capitais.get("Grécia").adicionarVizinho(capitais.get("Turquia"), 869); // Ancara

        // Conexões para Budapeste
        capitais.get("Hungria").adicionarVizinho(capitais.get("Áustria"), 243); // Viena
        capitais.get("Hungria").adicionarVizinho(capitais.get("Eslováquia"), 200); // Bratislava
        capitais.get("Hungria").adicionarVizinho(capitais.get("Ucrânia"), 832); // Kyiv
        capitais.get("Hungria").adicionarVizinho(capitais.get("Romênia"), 842); // Bucareste
        capitais.get("Hungria").adicionarVizinho(capitais.get("Sérvia"), 370); // Belgrado
        capitais.get("Hungria").adicionarVizinho(capitais.get("Croácia"), 345); // Zagreb

        // Conexões para Roma
        capitais.get("Itália").adicionarVizinho(capitais.get("França"), 1140); // Paris
        capitais.get("Itália").adicionarVizinho(capitais.get("Suíça"), 695); // Berna
        capitais.get("Itália").adicionarVizinho(capitais.get("Áustria"), 765); // Viena
        capitais.get("Itália").adicionarVizinho(capitais.get("Eslovênia"), 485); // Liubliana
        capitais.get("Itália").adicionarVizinho(capitais.get("São Marino"), 210); // São Marino

        // Conexões para Pristina
        capitais.get("Kosovo").adicionarVizinho(capitais.get("Albânia"), 100); // Tirana
        capitais.get("Kosovo").adicionarVizinho(capitais.get("Macedônia do Norte"), 80); // Skopje
        capitais.get("Kosovo").adicionarVizinho(capitais.get("Sérvia"), 250); // Belgrado
        capitais.get("Kosovo").adicionarVizinho(capitais.get("Montenegro"), 210); // Podgorica

        // Conexões para Riga
        capitais.get("Letônia").adicionarVizinho(capitais.get("Estônia"), 280); // Tallinn
        capitais.get("Letônia").adicionarVizinho(capitais.get("Lituânia"), 300); // Vilnius
        capitais.get("Letônia").adicionarVizinho(capitais.get("Bielorrússia"), 580); // Minsk
        capitais.get("Letônia").adicionarVizinho(capitais.get("Rússia"), 840); // Moscovo

        // Conexões para Vilnius
        capitais.get("Lituânia").adicionarVizinho(capitais.get("Letônia"), 300); // Riga
        capitais.get("Lituânia").adicionarVizinho(capitais.get("Polônia"), 450); // Varsóvia
        capitais.get("Lituânia").adicionarVizinho(capitais.get("Bielorrússia"), 180); // Minsk
        capitais.get("Lituânia").adicionarVizinho(capitais.get("Rússia"), 900); // Moscou

        // Conexões para Vaduz
        capitais.get("Liechtenstein").adicionarVizinho(capitais.get("Suíça"), 79); // Berna
        capitais.get("Liechtenstein").adicionarVizinho(capitais.get("Áustria"), 671); // Viena

        // Conexões para Luxemburgo
        capitais.get("Luxemburgo").adicionarVizinho(capitais.get("Bélgica"), 187); // Bruxelas
        capitais.get("Luxemburgo").adicionarVizinho(capitais.get("França"), 290); // Paris
        capitais.get("Luxemburgo").adicionarVizinho(capitais.get("Alemanha"), 600); // Berlim

        // Conexões para Escópia
        capitais.get("Macedônia do Norte").adicionarVizinho(capitais.get("Kosovo"), 78); // Pristina
        capitais.get("Macedônia do Norte").adicionarVizinho(capitais.get("Sérvia"), 321); // Belgrado
        capitais.get("Macedônia do Norte").adicionarVizinho(capitais.get("Bulgária"), 172); // Sofia
        capitais.get("Macedônia do Norte").adicionarVizinho(capitais.get("Grécia"), 648); // Atenas
        capitais.get("Macedônia do Norte").adicionarVizinho(capitais.get("Albânia"), 155); // Tirana

        // Conexões para Chișinău
        capitais.get("Moldávia").adicionarVizinho(capitais.get("Romênia"), 435); // Bucareste
        capitais.get("Moldávia").adicionarVizinho(capitais.get("Ucrânia"), 537); // Quiieve

        // Conexões para Mônaco
        capitais.get("Mônaco").adicionarVizinho(capitais.get("França"), 950); // Paris
        capitais.get("Mônaco").adicionarVizinho(capitais.get("Itália"), 680); // Roma

        // Conexões para Podgorica
        capitais.get("Montenegro").adicionarVizinho(capitais.get("Bósnia-Herzegovina"), 173); // Sarajevo
        capitais.get("Montenegro").adicionarVizinho(capitais.get("Croácia"), 570); // Zagreb
        capitais.get("Montenegro").adicionarVizinho(capitais.get("Sérvia"), 200); // Belgrado
        capitais.get("Montenegro").adicionarVizinho(capitais.get("Albânia"), 110); // Tirana

        // Conexões para Oslo
        capitais.get("Noruega").adicionarVizinho(capitais.get("Suécia"), 566); // Estocolmo
        capitais.get("Noruega").adicionarVizinho(capitais.get("Finlândia"), 1157); // Helsinque

        // Conexões para Amsterdã
        capitais.get("Países Baixos").adicionarVizinho(capitais.get("Bélgica"), 173); // Bruxelas
        capitais.get("Países Baixos").adicionarVizinho(capitais.get("Alemanha"), 577); // Berlim

        // Conexões para Varsóvia
        capitais.get("Polônia").adicionarVizinho(capitais.get("Alemanha"), 570); // Berlim
        capitais.get("Polônia").adicionarVizinho(capitais.get("República Tcheca"), 680); // Praga
        capitais.get("Polônia").adicionarVizinho(capitais.get("Eslováquia"), 660); // Bratislava
        capitais.get("Polônia").adicionarVizinho(capitais.get("Ucrânia"), 783); // Quiieve
        capitais.get("Polônia").adicionarVizinho(capitais.get("Bielorrússia"), 490); // Minsk
        capitais.get("Polônia").adicionarVizinho(capitais.get("Lituânia"), 450); // Vilnius

        // Conexões para Lisboa
        capitais.get("Portugal").adicionarVizinho(capitais.get("Espanha"), 514); // Madrid

        // Conexões para Londres
        capitais.get("Inglaterra").adicionarVizinho(capitais.get("França"), 460); // Paris

        // Conexões para Bucareste
        capitais.get("Romênia").adicionarVizinho(capitais.get("Moldávia"), 430); // Chișinău
        capitais.get("Romênia").adicionarVizinho(capitais.get("Hungria"), 830); // Budapeste
        capitais.get("Romênia").adicionarVizinho(capitais.get("Sérvia"), 376); // Belgrado
        capitais.get("Romênia").adicionarVizinho(capitais.get("Bulgária"), 360); // Sófia
        capitais.get("Romênia").adicionarVizinho(capitais.get("Ucrânia"), 660); // Quiieve

        // Conexões para Moscovo
        capitais.get("Rússia").adicionarVizinho(capitais.get("Noruega"), 1570); // Oslo
        capitais.get("Rússia").adicionarVizinho(capitais.get("Finlândia"), 1300); // Helsinque
        capitais.get("Rússia").adicionarVizinho(capitais.get("Estônia"), 1150); // Tallin
        capitais.get("Rússia").adicionarVizinho(capitais.get("Letônia"), 1150); // Riga
        capitais.get("Rússia").adicionarVizinho(capitais.get("Lituânia"), 1055); // Vilnius
        capitais.get("Rússia").adicionarVizinho(capitais.get("Polônia"), 1200); // Varsóvia
        capitais.get("Rússia").adicionarVizinho(capitais.get("Bielorrússia"), 700); // Minsk
        capitais.get("Rússia").adicionarVizinho(capitais.get("Ucrânia"), 850); // Kyiv
        capitais.get("Rússia").adicionarVizinho(capitais.get("Geórgia"), 1850); // Tbilisi

        // Conexões para San Marino
        capitais.get("San Marino").adicionarVizinho(capitais.get("Itália"), 180); // Roma

        // Conexões para Belgrado
        capitais.get("Sérvia").adicionarVizinho(capitais.get("Hungria"), 375); // Budapeste
        capitais.get("Sérvia").adicionarVizinho(capitais.get("Romênia"), 448); // Bucareste
        capitais.get("Sérvia").adicionarVizinho(capitais.get("Bósnia-Herzegovina"), 300); // Sarajevo
        capitais.get("Sérvia").adicionarVizinho(capitais.get("Montenegro"), 225); // Podgorica
        capitais.get("Sérvia").adicionarVizinho(capitais.get("Macedônia do Norte"), 430); // Escópia

        // Conexões para Estocolmo
        capitais.get("Suécia").adicionarVizinho(capitais.get("Noruega"), 554); // Oslo
        capitais.get("Suécia").adicionarVizinho(capitais.get("Finlândia"), 398); // Helsinque
        capitais.get("Suécia").adicionarVizinho(capitais.get("Dinamarca"), 650); // Copenhague

        // Conexões para Berna
        capitais.get("Suíça").adicionarVizinho(capitais.get("França"), 658); // Paris
        capitais.get("Suíça").adicionarVizinho(capitais.get("Alemanha"), 1010); // Berlim
        capitais.get("Suíça").adicionarVizinho(capitais.get("Itália"), 1050); // Roma
        capitais.get("Suíça").adicionarVizinho(capitais.get("Áustria"), 790); // Viena

        // Conexões para Praga
        capitais.get("República Tcheca").adicionarVizinho(capitais.get("Alemanha"), 280); // Berlim
        capitais.get("República Tcheca").adicionarVizinho(capitais.get("Polônia"), 519); // Varsóvia
        capitais.get("República Tcheca").adicionarVizinho(capitais.get("Áustria"), 330); // Viena
        capitais.get("República Tcheca").adicionarVizinho(capitais.get("Eslováquia"), 330); // Bratislava

        // Conexões para Kyiv
        capitais.get("Ucrânia").adicionarVizinho(capitais.get("Rússia"), 756); // Moscovo
        capitais.get("Ucrânia").adicionarVizinho(capitais.get("Romênia"), 920); // Bucareste
        capitais.get("Ucrânia").adicionarVizinho(capitais.get("Bielorrússia"), 539); // Minsk
        capitais.get("Ucrânia").adicionarVizinho(capitais.get("Polônia"), 690); // Varsóvia
        capitais.get("Ucrânia").adicionarVizinho(capitais.get("Eslováquia"), 1067); // Bratislava
        capitais.get("Ucrânia").adicionarVizinho(capitais.get("Hungria"), 1073); // Budapeste
        capitais.get("Ucrânia").adicionarVizinho(capitais.get("Moldávia"), 485); // Chisinau

        // Conexões para Cidade do Vaticano
        capitais.get("Vaticano").adicionarVizinho(capitais.get("Itália"), 4); // Roma
        capitais.get("Vaticano").adicionarVizinho(capitais.get("San Marino"), 227); // San Marino

    }

    public Capital getCapital(String nome) {
        return capitais.get(nome);
    }

    public Map<String, Capital> getCapitais() {
        return capitais;
    }
}
