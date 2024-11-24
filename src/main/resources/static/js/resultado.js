// Dicionário de países e capitais 
const traducoes = {
  "Albânia": "Tirana",
  "Alemanha": "Berlin",
  "Andorra": "Andorra la Vella",
  "Armênia": "Yerevan",
  "Áustria": "Vienna",
  "Azerbaijão": "Baku",
  "Bélgica": "Brussels",
  "Bielorrússia": "Minsk",
  "Bósnia-Herzegovina": "Sarajevo",
  "Bulgária": "Sofia",
  "Cazaquistão": "Astana",
  "Croácia": "Zagreb",
  "Dinamarca": "Copenhagen",
  "Eslováquia": "Bratislava",
  "Eslovênia": "Ljubljana",
  "Espanha": "Madrid",
  "Estônia": "Tallinn",
  "Finlândia": "Helsinki",
  "França": "Paris",
  "Geórgia": "Tbilisi",
  "Grécia": "Athens",
  "Hungria": "Budapest",
  "Itália": "Rome",
  "Kosovo": "Pristina",
  "Letônia": "Riga",
  "Lituânia": "Vilnius",
  "Liechtenstein": "Vaduz",
  "Luxemburgo": "Luxembourg",
  "Macedônia do Norte": "Skopje",
  "Moldávia": "Chișinău",
  "Montenegro": "Podgorica",
  "Noruega": "Oslo",
  "Países Baixos": "Amsterdam",
  "Polônia": "Warsaw",
  "Portugal": "Lisbon",
  "Inglaterra": "London",
  "Romênia": "Bucharest",
  "Rússia": "Moscow",
  "San Marino": "San Marino",
  "Sérvia": "Belgrade",
  "Suécia": "Stockholm",
  "Suíça": "Zurique",
  "República Tcheca": "Prague",
  "Ucrânia": "Kyiv",
  "Vaticano": "Vatican City"
};

// Traduz localidade
function traduzirLocalizacao(localizacao) {
  if (traducoes[localizacao]) {
    return traducoes[localizacao];
  } else {
    return localizacao;
  }
}

function exibeRotaNoMapa(rota, traduzir = true) {
  if (!Array.isArray(rota) || rota.length === 0) {
    console.error("Erro: A rota fornecida está vazia ou não é um array válido.", rota);
    return;
  }

  let origemTraduzida;
  let destinoTraduzido;

  // Se traduzir for verdadeiro realiza a tradução das localizações
  if (traduzir) {
    origemTraduzida = traduzirLocalizacao(rota[0]);
    destinoTraduzido = traduzirLocalizacao(rota[rota.length - 1]);
  } else {
    // Se não mantém as localizações originais
    origemTraduzida = rota[0];
    destinoTraduzido = rota[rota.length - 1];
  }

  const pontosRotaTraduzidos = [];

  for (let i = 1; i < rota.length - 1; i++) {
    let localizacao = rota[i]; // Pega a localização do ponto da rota

    // Se traduzir for verdadeiro traduz o ponto da rota
    if (traduzir) {
      localizacao = traduzirLocalizacao(localizacao);
    }

    // Adiciona o ponto da rota ao array de rotas traduzidas
    pontosRotaTraduzidos.push({
      location: localizacao,
      stopover: true
    });
  }

  // Configuração da requisição para o serviço de direções do Google Maps
  const requisicao = {
    origin: origemTraduzida,
    destination: destinoTraduzido,
    waypoints: pontosRotaTraduzidos,
    travelMode: google.maps.TravelMode.DRIVING,
  };

  // Envia a requisição para o Google Maps
  servicoDirecoes.route(requisicao, (resultado, status) => {
    if (status === google.maps.DirectionsStatus.OK) {
      renderizadorDirecoes.setDirections(resultado);

      // Verifica o status de cada ponto de rota
      resultado.geocoded_waypoints.forEach((pontoRota, index) => {
        console.log(`Ponto da Rota ${index + 1}:`, pontoRota.geocoder_status);
      });
    } else {
      console.error("Erro ao calcular a rota: ", status);
    }
  });
}

// Formata a rota no formato adequado para o Google Maps
const formataRotaParaMaps = (rota) => {
  return rota.map(local => local);
};

const mostraResultado = (resultado) => {
  if (resultado.rota) {
    document.getElementById("rota").innerHTML = "Rota: " + resultado.rota.join(" &rarr; ");
  }
  document.getElementById("distancia").textContent = "Distância Total: " + (resultado.distanciaTotal || "N/A") + " km";
  document.getElementById("nosGerados").textContent = "Nós Gerados: " + (resultado.nosGerados || "N/A");
  document.getElementById("nosExpandidos").textContent = "Nós Expandidos: " + (resultado.nosExpandidos || "N/A");
  document.getElementById("tempoExecucao").textContent = "Tempo de Execução: " + (resultado.tempoExecucao || "N/A") + " ms";

  const rotaFormatada = formataRotaParaMaps(resultado.rota);
  exibeRotaNoMapa(rotaFormatada);
};

const limpaResultado = () => {
  document.getElementById("rota").innerHTML = "";
  document.getElementById("distancia").textContent = "";
  document.getElementById("nosGerados").textContent = "";
  document.getElementById("nosExpandidos").textContent = "";
  document.getElementById("tempoExecucao").textContent = "";
};

// Realiza a requisição e busca a rota
const buscaRota = (origem, destino, algoritmo) => {
  const buscaOrigem = encodeURIComponent(origem);
  const buscaDestino = encodeURIComponent(destino);
  const buscaAlgoritmo = encodeURIComponent(algoritmo);

  return fetch(`/api/buscar?origem=${buscaOrigem}&destino=${buscaDestino}&algoritmo=${buscaAlgoritmo}`, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
  })
    .then(response => {
      if (response.status >= 400) {
        throw new Error('Erro na requisição: ' + response.statusText);
      }
      return response.json();
    });
};

// Executa a busca e processa o resultado
const executaBusca = (origem, destino, algoritmo) => {
  buscaRota(origem, destino, algoritmo)
    .then(resultado => {
      // Verifica se a rota está na resposta antes de tentar acessar
      if (resultado && resultado.rota && Array.isArray(resultado.rota)) {
        mostraResultado(resultado);
      } else {
        console.error("Erro: A propriedade 'rota' não foi encontrada no resultado.", resultado);
      }
    })
    .catch(error => {
      console.error("Erro ao buscar a rota: ", error);
    });
};
