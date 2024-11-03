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

const mostraResultado = (resultado) => {
  document.getElementById("rota").innerHTML = "Rota: " + resultado.rota.join(" &rarr; ");
  document.getElementById("distancia").textContent = "Distância Total: " + resultado.distanciaTotal + " km";
  document.getElementById("nosGerados").textContent = "Nós Gerados: " + resultado.nosGerados;
  document.getElementById("nosExpandidos").textContent = "Nós Expandidos: " + resultado.nosExpandidos;
  document.getElementById("tempoExecucao").textContent = "Tempo de Execução: " + resultado.tempoExecucao + " ms";
};

const limpaResultado = () => {
  document.getElementById("rota").innerHTML = "";
  document.getElementById("distancia").textContent = "";
  document.getElementById("nosGerados").textContent = "";
  document.getElementById("nosExpandidos").textContent = "";
  document.getElementById("tempoExecucao").textContent = "";
};
