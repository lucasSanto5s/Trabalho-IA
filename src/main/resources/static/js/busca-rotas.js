document.addEventListener("DOMContentLoaded", () => {
  const btnBuscar = document.getElementById("btnBuscar");
  const btnLimpar = document.getElementById("btnLimpar");

  btnBuscar.addEventListener("click", (event) => {
      event.preventDefault(); 
      const origem = document.getElementById("origem").value;
      const destino = document.getElementById("destino").value;
      const algoritmo = document.getElementById("algoritmo").value;

      buscaRota(origem, destino, algoritmo)
      .then(resultado => {
          mostraResultado(resultado);
      })
      .catch(erro => {
          let mensagemErro; 
          if (erro.response) {
              erro.response.json().then(data => {
                  mensagemErro = data;
                  alert("Erro ao buscar a rota: " + mensagemErro.message);
              });
          } else {
              mensagemErro = { message: erro.message };
              alert("Erro ao buscar a rota: " + mensagemErro.message);
          }
      });  
  });

  btnLimpar.addEventListener("click", () => {
      limpaResultado();
  });
});

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
  document.getElementById("tempoExecucao").textContent = "Tempo de Execução: " + resultado.tempoExecucao + " ns";
};

const limpaResultado = () => {
  document.getElementById("rota").textContent = "";
  document.getElementById("distancia").textContent = "";
  document.getElementById("nosGerados").textContent = "";
  document.getElementById("nosExpandidos").textContent = "";
  document.getElementById("tempoExecucao").textContent = "";
};
