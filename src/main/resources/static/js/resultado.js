// Função responsável por realizar a requisição para buscar a rota
const buscaRota = (origem, destino, algoritmo) => {
  // Codifica os parâmetros de origem, destino e algoritmo para garantir que são passados corretamente na URL
  const buscaOrigem = encodeURIComponent(origem);
  const buscaDestino = encodeURIComponent(destino);
  const buscaAlgoritmo = encodeURIComponent(algoritmo);
  
  // Realiza a requisição para o endpoint de busca com os parâmetros codificados via método POST
  return fetch(`/api/buscar?origem=${buscaOrigem}&destino=${buscaDestino}&algoritmo=${buscaAlgoritmo}`, {
      method: 'POST', // Método HTTP POST
      headers: {
          'Content-Type': 'application/json', // Define o tipo de conteúdo como JSON
      },
  })
  .then(response => {
      // Verifica se a resposta foi bem-sucedida (status >= 400 indica erro)
      if (response.status >= 400) {
          throw new Error('Erro na requisição: ' + response.statusText); // Lança um erro caso a resposta seja um erro HTTP
      }
      // Converte a resposta em formato JSON e retorna o resultado
      return response.json();
  });
};

// Função responsável por mostrar os resultados da busca de rota na interface
const mostraResultado = (resultado) => {
  document.getElementById("rota").innerHTML = "Rota: " + resultado.rota.join(" &rarr; ");
  document.getElementById("distancia").textContent = "Distância Total: " + resultado.distanciaTotal + " km";
  document.getElementById("nosGerados").textContent = "Nós Gerados: " + resultado.nosGerados;
  document.getElementById("nosExpandidos").textContent = "Nós Expandidos: " + resultado.nosExpandidos;
  document.getElementById("tempoExecucao").textContent = "Tempo de Execução: " + resultado.tempoExecucao + " ms";
};

// Função responsável por limpar os resultados exibidos na interface
const limpaResultado = () => {
  document.getElementById("rota").innerHTML = "";
  document.getElementById("distancia").textContent = "";
  document.getElementById("nosGerados").textContent = "";
  document.getElementById("nosExpandidos").textContent = "";
  document.getElementById("tempoExecucao").textContent = "";
};
