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
        Capital franca = new Capital("França");
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
        capitais.put("França", franca);
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
        capitais.get("Albânia").adicionarVizinho(capitais.get("Montenegro"), 160, 130); // Podgorica
        capitais.get("Albânia").adicionarVizinho(capitais.get("Kosovo"), 250, 185); // Pristina
        capitais.get("Albânia").adicionarVizinho(capitais.get("Macedônia do Norte"), 290, 153); // Skopje
        capitais.get("Albânia").adicionarVizinho(capitais.get("Grécia"), 530, 500); // Atenas

        // Conexões para Berlim
        capitais.get("Alemanha").adicionarVizinho(capitais.get("Polônia"), 570, 515); // Varsóvia
        capitais.get("Alemanha").adicionarVizinho(capitais.get("República Tcheca"), 350, 280); // Praga
        capitais.get("Alemanha").adicionarVizinho(capitais.get("Áustria"), 680, 520); // Viena
        capitais.get("Alemanha").adicionarVizinho(capitais.get("Suíça"), 850, 670); // Zurique
        capitais.get("Alemanha").adicionarVizinho(capitais.get("França"), 1050, 878); // Paris
        capitais.get("Alemanha").adicionarVizinho(capitais.get("Luxemburgo"), 750, 600); // Luxemburgo
        capitais.get("Alemanha").adicionarVizinho(capitais.get("Bélgica"), 770, 650); // Bruxelas
        capitais.get("Alemanha").adicionarVizinho(capitais.get("Países Baixos"), 577, 570); // Amsterdã
        capitais.get("Alemanha").adicionarVizinho(capitais.get("Dinamarca"), 356, 350); // Copenhague

        // Conexões para Andorra
        capitais.get("Andorra").adicionarVizinho(capitais.get("Espanha"), 494, 490); // Madrid
        capitais.get("Andorra").adicionarVizinho(capitais.get("França"), 864, 710); // Paris

        // Conexões para Yerevan
        capitais.get("Armênia").adicionarVizinho(capitais.get("Geórgia"), 375, 170); // Tbilisi
        capitais.get("Armênia").adicionarVizinho(capitais.get("Azerbaijão"), 460, 450); // Baku

        // Conexões para Viena
        capitais.get("Áustria").adicionarVizinho(capitais.get("Eslováquia"), 82, 60); // Bratislava
        capitais.get("Áustria").adicionarVizinho(capitais.get("República Tcheca"), 254, 250); // Praga
        capitais.get("Áustria").adicionarVizinho(capitais.get("Hungria"), 212, 210); // Budapeste
        capitais.get("Áustria").adicionarVizinho(capitais.get("Eslovênia"), 380, 280); // Ljubljana
        capitais.get("Áustria").adicionarVizinho(capitais.get("Suíça"), 800, 680); // Berna
        capitais.get("Áustria").adicionarVizinho(capitais.get("Itália"), 1150, 765); // Roma
        capitais.get("Áustria").adicionarVizinho(capitais.get("Liechtenstein"), 600, 520); // Vaduz
        capitais.get("Áustria").adicionarVizinho(capitais.get("Alemanha"), 680, 520); // Berlim

        // Conexões para Baku
        capitais.get("Azerbaijão").adicionarVizinho(capitais.get("Armênia"), 460, 450); // Ierevan
        capitais.get("Azerbaijão").adicionarVizinho(capitais.get("Geórgia"), 546, 440); // Tbilisi
        capitais.get("Azerbaijão").adicionarVizinho(capitais.get("Rússia"), 2300, 2000); // Moscovo

        // Conexões para Bruxelas
        capitais.get("Bélgica").adicionarVizinho(capitais.get("França"), 264, 260); // Paris
        capitais.get("Bélgica").adicionarVizinho(capitais.get("Países Baixos"), 173, 170); // Amsterdã
        capitais.get("Bélgica").adicionarVizinho(capitais.get("Luxemburgo"), 183, 170); // Luxemburgo
        capitais.get("Bélgica").adicionarVizinho(capitais.get("Alemanha"), 650, 650); // Berlim

        // Conexões para Minsk
        capitais.get("Bielorrússia").adicionarVizinho(capitais.get("Rússia"), 675, 670); // Moscou
        capitais.get("Bielorrússia").adicionarVizinho(capitais.get("Ucrânia"), 560, 430); // Kiev
        capitais.get("Bielorrússia").adicionarVizinho(capitais.get("Polônia"), 558, 470); // Varsóvia
        capitais.get("Bielorrússia").adicionarVizinho(capitais.get("Lituânia"), 180, 170); // Vilnius
        capitais.get("Bielorrússia").adicionarVizinho(capitais.get("Letônia"), 550, 400); // Riga

        // Conexões para Sarajevo
        capitais.get("Bósnia-Herzegovina").adicionarVizinho(capitais.get("Croácia"), 390, 290); // Zagreb
        capitais.get("Bósnia-Herzegovina").adicionarVizinho(capitais.get("Sérvia"), 300, 190); // Belgrado
        capitais.get("Bósnia-Herzegovina").adicionarVizinho(capitais.get("Montenegro"), 230, 170); // Podgorica

        // Conexões para Sofia
        capitais.get("Bulgária").adicionarVizinho(capitais.get("Romênia"), 297, 190); // Bucareste
        capitais.get("Bulgária").adicionarVizinho(capitais.get("Sérvia"), 395, 290); // Belgrado
        capitais.get("Bulgária").adicionarVizinho(capitais.get("Macedônia do Norte"), 240, 170); // Skopje
        capitais.get("Bulgária").adicionarVizinho(capitais.get("Grécia"), 785, 520); // Atenas

        // Conexões para Nur-Sultan
        capitais.get("Cazaquistão").adicionarVizinho(capitais.get("Rússia"), 2271, 2200); // Moscou

        // Conexões para Zagreb
        capitais.get("Croácia").adicionarVizinho(capitais.get("Eslovênia"), 140, 120); // Ljubljana
        capitais.get("Croácia").adicionarVizinho(capitais.get("Hungria"), 345, 300); // Budapeste
        capitais.get("Croácia").adicionarVizinho(capitais.get("Sérvia"), 500, 370); // Belgrado
        capitais.get("Croácia").adicionarVizinho(capitais.get("Bósnia-Herzegovina"), 430, 290); // Sarajevo
        capitais.get("Croácia").adicionarVizinho(capitais.get("Montenegro"), 610, 460); // Podgorica

        // Conexões para Copenhague
        capitais.get("Dinamarca").adicionarVizinho(capitais.get("Suécia"), 522, 510); // Estocolmo
        capitais.get("Dinamarca").adicionarVizinho(capitais.get("Alemanha"), 356, 340); // Berlim

        // Conexões para Bratislava
        capitais.get("Eslováquia").adicionarVizinho(capitais.get("Áustria"), 65, 50); // Viena
        capitais.get("Eslováquia").adicionarVizinho(capitais.get("Hungria"), 200, 160); // Budapeste
        capitais.get("Eslováquia").adicionarVizinho(capitais.get("República Tcheca"), 330, 270); // Praga
        capitais.get("Eslováquia").adicionarVizinho(capitais.get("Polônia"), 650, 530); // Varsóvia
        capitais.get("Eslováquia").adicionarVizinho(capitais.get("Ucrânia"), 1325, 1000); // Kiev

        // Conexões para Liubliana
        capitais.get("Eslovênia").adicionarVizinho(capitais.get("Croácia"), 140, 115); // Zagreb
        capitais.get("Eslovênia").adicionarVizinho(capitais.get("Áustria"), 380, 270); // Viena
        capitais.get("Eslovênia").adicionarVizinho(capitais.get("Hungria"), 460, 380); // Budapeste
        capitais.get("Eslovênia").adicionarVizinho(capitais.get("Itália"), 600, 490); // Roma

        // Conexões para Madri
        capitais.get("Espanha").adicionarVizinho(capitais.get("Portugal"), 640, 504); // Lisboa
        capitais.get("Espanha").adicionarVizinho(capitais.get("França"), 1300, 1050); // Paris
        capitais.get("Espanha").adicionarVizinho(capitais.get("Andorra"), 650, 492); // Andorra la Vella

        // Conexões para Tallinn
        capitais.get("Estônia").adicionarVizinho(capitais.get("Letônia"), 310, 280); // Riga
        capitais.get("Estônia").adicionarVizinho(capitais.get("Rússia"), 1150, 867); // Moscou

        // Conexões para Helsinque
        capitais.get("Finlândia").adicionarVizinho(capitais.get("Suécia"), 765, 400); // Estocolmo
        capitais.get("Finlândia").adicionarVizinho(capitais.get("Noruega"), 1157, 780); // Oslo
        capitais.get("Finlândia").adicionarVizinho(capitais.get("Rússia"), 1300, 890); // Moscou

        // Conexões para Paris
        capitais.get("França").adicionarVizinho(capitais.get("Bélgica"), 320, 260); // Bruxelas
        capitais.get("França").adicionarVizinho(capitais.get("Luxemburgo"), 380, 280); // Luxemburgo
        capitais.get("França").adicionarVizinho(capitais.get("Alemanha"), 1050, 870); // Berlim
        capitais.get("França").adicionarVizinho(capitais.get("Suíça"), 490, 430); // Berna

        capitais.get("França").adicionarVizinho(capitais.get("Espanha"), 1275, 1050); // Madri
        capitais.get("França").adicionarVizinho(capitais.get("Andorra"), 894, 710); // Andorra-a-Velha
        capitais.get("França").adicionarVizinho(capitais.get("Itália"), 1420, 1100); // Roma
        capitais.get("França").adicionarVizinho(capitais.get("Inglaterra"), 460, 340); // Londres

        // Conexões para Tbilisi
        capitais.get("Geórgia").adicionarVizinho(capitais.get("Armênia"), 262, 170); // Yerevan
        capitais.get("Geórgia").adicionarVizinho(capitais.get("Azerbaijão"), 546, 440); // Baku
        capitais.get("Geórgia").adicionarVizinho(capitais.get("Rússia"), 1970, 1640); // Moscou

        // Conexões para Atenas
        capitais.get("Grécia").adicionarVizinho(capitais.get("Albânia"), 680, 501); // Tirana
        capitais.get("Grécia").adicionarVizinho(capitais.get("Macedônia do Norte"), 792, 487); // Skopje
        capitais.get("Grécia").adicionarVizinho(capitais.get("Bulgária"), 792, 520); // Sofia

        // Conexões para Budapeste
        capitais.get("Hungria").adicionarVizinho(capitais.get("Áustria"), 243, 215); // Viena
        capitais.get("Hungria").adicionarVizinho(capitais.get("Eslováquia"), 200, 160); // Bratislava
        capitais.get("Hungria").adicionarVizinho(capitais.get("Ucrânia"), 1132, 900); // Kyiv
        capitais.get("Hungria").adicionarVizinho(capitais.get("Romênia"), 842, 640); // Bucareste
        capitais.get("Hungria").adicionarVizinho(capitais.get("Sérvia"), 370, 320); // Belgrado
        capitais.get("Hungria").adicionarVizinho(capitais.get("Croácia"), 345, 300); // Zagreb
        capitais.get("Hungria").adicionarVizinho(capitais.get("Eslovênia"), 460, 383); // Ljubljana

        // Conexões para Roma
        capitais.get("Itália").adicionarVizinho(capitais.get("França"), 1140, 1100); // Paris
        capitais.get("Itália").adicionarVizinho(capitais.get("Suíça"), 860, 690); // Berna
        capitais.get("Itália").adicionarVizinho(capitais.get("Áustria"), 1120, 765); // Viena
        capitais.get("Itália").adicionarVizinho(capitais.get("Eslovênia"), 750, 490); // Liubliana
        capitais.get("Itália").adicionarVizinho(capitais.get("San Marino"), 320, 220); // São Marino
        capitais.get("Itália").adicionarVizinho(capitais.get("Vaticano"), 4, 2); // Vaticano

        // Conexões para Pristina
        capitais.get("Kosovo").adicionarVizinho(capitais.get("Albânia"), 250, 185); // Tirana
        capitais.get("Kosovo").adicionarVizinho(capitais.get("Macedônia do Norte"), 80, 70); // Skopje
        capitais.get("Kosovo").adicionarVizinho(capitais.get("Sérvia"), 520, 240); // Belgrado
        capitais.get("Kosovo").adicionarVizinho(capitais.get("Montenegro"), 250, 150); // Podgorica

        // Conexões para Riga
        capitais.get("Letônia").adicionarVizinho(capitais.get("Estônia"), 310, 280); // Tallinn
        capitais.get("Letônia").adicionarVizinho(capitais.get("Lituânia"), 300, 260); // Vilnius
        capitais.get("Letônia").adicionarVizinho(capitais.get("Bielorrússia"), 580, 400); // Minsk
        capitais.get("Letônia").adicionarVizinho(capitais.get("Rússia"), 930, 840); // Moscovo

        // Conexões para Vilnius
        capitais.get("Lituânia").adicionarVizinho(capitais.get("Letônia"), 300, 260); // Riga
        capitais.get("Lituânia").adicionarVizinho(capitais.get("Polônia"), 450, 390); // Varsóvia
        capitais.get("Lituânia").adicionarVizinho(capitais.get("Bielorrússia"), 180, 170); // Minsk
        capitais.get("Lituânia").adicionarVizinho(capitais.get("Rússia"), 900, 800); // Moscou

        // Conexões para Vaduz
        capitais.get("Liechtenstein").adicionarVizinho(capitais.get("Suíça"), 200, 160); // Berna
        capitais.get("Liechtenstein").adicionarVizinho(capitais.get("Áustria"), 600, 520); // Viena

        // Conexões para Luxemburgo
        capitais.get("Luxemburgo").adicionarVizinho(capitais.get("Bélgica"), 220, 180); // Bruxelas
        capitais.get("Luxemburgo").adicionarVizinho(capitais.get("França"), 310, 280); // Paris
        capitais.get("Luxemburgo").adicionarVizinho(capitais.get("Alemanha"), 740, 600); // Berlim

        // Conexões para Escópia
        capitais.get("Macedônia do Norte").adicionarVizinho(capitais.get("Kosovo"), 78, 70); // Pristina
        capitais.get("Macedônia do Norte").adicionarVizinho(capitais.get("Sérvia"), 430, 320); // Belgrado
        capitais.get("Macedônia do Norte").adicionarVizinho(capitais.get("Bulgária"), 240, 170); // Sofia
        capitais.get("Macedônia do Norte").adicionarVizinho(capitais.get("Grécia"), 648, 480); // Atenas
        capitais.get("Macedônia do Norte").adicionarVizinho(capitais.get("Albânia"), 230, 150); // Tirana

        // Conexões para Chișinău
        capitais.get("Moldávia").adicionarVizinho(capitais.get("Romênia"), 435, 360); // Bucareste
        capitais.get("Moldávia").adicionarVizinho(capitais.get("Ucrânia"), 537, 400); // Kiev

        // Conexões para Podgorica
        capitais.get("Montenegro").adicionarVizinho(capitais.get("Bósnia-Herzegovina"), 230, 170); // Sarajevo
        capitais.get("Montenegro").adicionarVizinho(capitais.get("Croácia"), 570, 460); // Zagreb
        capitais.get("Montenegro").adicionarVizinho(capitais.get("Sérvia"), 447, 260); // Belgrado
        capitais.get("Montenegro").adicionarVizinho(capitais.get("Albânia"), 157, 130); // Tirana
        capitais.get("Montenegro").adicionarVizinho(capitais.get("Kosovo"), 255, 150); // Pristina

        // Conexões para Oslo
        capitais.get("Noruega").adicionarVizinho(capitais.get("Suécia"), 566, 400); // Estocolmo
        capitais.get("Noruega").adicionarVizinho(capitais.get("Finlândia"), 1157, 780); // Helsinque
        capitais.get("Noruega").adicionarVizinho(capitais.get("Rússia"), 1920, 1600); // Moscou

        // Conexões para Amsterdã
        capitais.get("Países Baixos").adicionarVizinho(capitais.get("Bélgica"), 210, 170); // Bruxelas
        capitais.get("Países Baixos").adicionarVizinho(capitais.get("Alemanha"), 650, 570); // Berlim

        // Conexões para Varsóvia
        capitais.get("Polônia").adicionarVizinho(capitais.get("Alemanha"), 570, 510); // Berlim
        capitais.get("Polônia").adicionarVizinho(capitais.get("República Tcheca"), 680, 510); // Praga
        capitais.get("Polônia").adicionarVizinho(capitais.get("Eslováquia"), 660, 530); // Bratislava
        capitais.get("Polônia").adicionarVizinho(capitais.get("Ucrânia"), 820, 680); // Kiev
        capitais.get("Polônia").adicionarVizinho(capitais.get("Bielorrússia"), 555, 470); // Minsk
        capitais.get("Polônia").adicionarVizinho(capitais.get("Lituânia"), 450, 390); // Vilnius
        capitais.get("Polônia").adicionarVizinho(capitais.get("Rússia"), 1250, 1150); // Moscou

        // Conexões para Lisboa
        capitais.get("Portugal").adicionarVizinho(capitais.get("Espanha"), 514, 500); // Madrid

        // Conexões para Londres
        capitais.get("Inglaterra").adicionarVizinho(capitais.get("França"), 460, 340); // Paris

        // Conexões para Bucareste
        capitais.get("Romênia").adicionarVizinho(capitais.get("Moldávia"), 430, 350); // Chișinău
        capitais.get("Romênia").adicionarVizinho(capitais.get("Hungria"), 830, 640); // Budapeste
        capitais.get("Romênia").adicionarVizinho(capitais.get("Sérvia"), 597, 440); // Belgrado
        capitais.get("Romênia").adicionarVizinho(capitais.get("Bulgária"), 360, 290); // Sófia
        capitais.get("Romênia").adicionarVizinho(capitais.get("Ucrânia"), 1500, 740); // Kiev

        // Conexões para Moscovo
        capitais.get("Rússia").adicionarVizinho(capitais.get("Noruega"), 2400, 1600); // Oslo
        capitais.get("Rússia").adicionarVizinho(capitais.get("Finlândia"), 1300, 870); // Helsinque
        capitais.get("Rússia").adicionarVizinho(capitais.get("Estônia"), 1150, 860); // Tallin
        capitais.get("Rússia").adicionarVizinho(capitais.get("Letônia"), 1150, 840); // Riga
        capitais.get("Rússia").adicionarVizinho(capitais.get("Lituânia"), 1055, 790); // Vilnius
        capitais.get("Rússia").adicionarVizinho(capitais.get("Polônia"), 1200, 715); // Varsóvia
        capitais.get("Rússia").adicionarVizinho(capitais.get("Bielorrússia"), 700, 670); // Minsk
        capitais.get("Rússia").adicionarVizinho(capitais.get("Ucrânia"), 1660, 1100); // Kyiv
        capitais.get("Rússia").adicionarVizinho(capitais.get("Geórgia"), 1900, 1600); // Tbilisi
        capitais.get("Rússia").adicionarVizinho(capitais.get("Azerbaijão"), 2300, 1900); // Baku
        capitais.get("Rússia").adicionarVizinho(capitais.get("Cazaquistão"), 2800, 2200); // Nur-Sultan

        // Conexões para San Marino
        capitais.get("San Marino").adicionarVizinho(capitais.get("Itália"), 180, 150); // Roma

        // Conexões para Belgrado
        capitais.get("Sérvia").adicionarVizinho(capitais.get("Hungria"), 375, 320); // Budapeste
        capitais.get("Sérvia").adicionarVizinho(capitais.get("Romênia"), 600, 440); // Bucareste
        capitais.get("Sérvia").adicionarVizinho(capitais.get("Bósnia-Herzegovina"), 300, 200); // Sarajevo
        capitais.get("Sérvia").adicionarVizinho(capitais.get("Montenegro"), 450, 280); // Podgorica
        capitais.get("Sérvia").adicionarVizinho(capitais.get("Macedônia do Norte"), 430, 320); // Escópia
        capitais.get("Sérvia").adicionarVizinho(capitais.get("Bulgária"), 395, 320); // Sofia
        capitais.get("Sérvia").adicionarVizinho(capitais.get("Kosovo"), 550, 250); // Pristina
        capitais.get("Sérvia").adicionarVizinho(capitais.get("Croácia"), 500, 370); // Zagreb

        // Conexões para Estocolmo
        capitais.get("Suécia").adicionarVizinho(capitais.get("Noruega"), 554, 400); // Oslo
        capitais.get("Suécia").adicionarVizinho(capitais.get("Finlândia"), 485, 415); // Helsinque
        capitais.get("Suécia").adicionarVizinho(capitais.get("Dinamarca"), 650, 520); // Copenhague

        // Conexões para Berna
        capitais.get("Suíça").adicionarVizinho(capitais.get("França"), 658, 430); // Paris
        capitais.get("Suíça").adicionarVizinho(capitais.get("Alemanha"), 1010, 750); // Berlim
        capitais.get("Suíça").adicionarVizinho(capitais.get("Itália"), 1050, 700); // Roma
        capitais.get("Suíça").adicionarVizinho(capitais.get("Áustria"), 790, 680); // Viena
        capitais.get("Suíça").adicionarVizinho(capitais.get("Liechtenstein"), 200, 150); // Liechtenstein

        // Conexões para Praga
        capitais.get("República Tcheca").adicionarVizinho(capitais.get("Alemanha"), 350, 280); // Berlim
        capitais.get("República Tcheca").adicionarVizinho(capitais.get("Polônia"), 635, 515); // Varsóvia
        capitais.get("República Tcheca").adicionarVizinho(capitais.get("Áustria"), 330, 250); // Viena
        capitais.get("República Tcheca").adicionarVizinho(capitais.get("Eslováquia"), 330, 280); // Bratislava

        // Conexões para Kyiv
        capitais.get("Ucrânia").adicionarVizinho(capitais.get("Rússia"), 1690, 755); // Moscovo
        capitais.get("Ucrânia").adicionarVizinho(capitais.get("Romênia"), 920, 750); // Bucareste
        capitais.get("Ucrânia").adicionarVizinho(capitais.get("Bielorrússia"), 539, 430); // Minsk
        capitais.get("Ucrânia").adicionarVizinho(capitais.get("Polônia"), 690, 600); // Varsóvia
        capitais.get("Ucrânia").adicionarVizinho(capitais.get("Eslováquia"), 1067, 680); // Bratislava
        capitais.get("Ucrânia").adicionarVizinho(capitais.get("Hungria"), 1073, 900); // Budapeste
        capitais.get("Ucrânia").adicionarVizinho(capitais.get("Moldávia"), 485, 400); // Chișinău

        // Conexões para Cidade do Vaticano
        capitais.get("Vaticano").adicionarVizinho(capitais.get("Itália"), 4, 3); // Roma

    }

    public Capital getCapital(String nome) {
        return capitais.get(nome);
    }

    public Map<String, Capital> getCapitais() {
        return capitais;
    }
}
