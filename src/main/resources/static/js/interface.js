document.addEventListener("DOMContentLoaded", () => {
    const btnBuscar = document.getElementById("btnBuscar");
    const btnLimpar = document.getElementById("btnLimpar");
    const selecionaOrigem = document.getElementById("origem");
    const selecionaDestino = document.getElementById("destino");
    const mensagemErro = document.getElementById("mensagemErro");
    const loader = document.getElementById("loader");
  
    const capitais = [
      "Albânia", "Alemanha", "Andorra", "Armênia", "Áustria",
      "Azerbaijão", "Bélgica", "Bielorrússia", "Bósnia-Herzegovina",
      "Bulgária", "Cazaquistão", "Croácia", "Dinamarca", "Eslováquia",
      "Eslovênia", "Espanha", "Estônia", "Finlândia", "França",
      "Geórgia", "Grécia", "Hungria", "Itália", "Kosovo", "Letônia",
      "Lituânia", "Liechtenstein", "Luxemburgo", "Macedônia do Norte",
      "Moldávia", "Montenegro", "Noruega", "Países Baixos", "Polônia",
      "Portugal", "Inglaterra", "Romênia", "Rússia", "San Marino",
      "Sérvia", "Suécia", "Suíça", "República Tcheca", "Ucrânia", "Vaticano"
    ];
  
    const opcoes = () => {
      return capitais.map(pais => `<option value="${pais}">${pais}</option>`).join('');
    };
  
    selecionaOrigem.innerHTML = opcoes();
    selecionaDestino.innerHTML = opcoes();
  
    const validacaoValoresIguais = () => {
      const origem = selecionaOrigem.value;
      const destino = selecionaDestino.value;
  
      if (origem === destino) {
        btnBuscar.disabled = true;
        mensagemErro.textContent = 'Selecione países diferentes em origem e destino.';
        mensagemErro.style.display = "block";
      } else {
        btnBuscar.disabled = false;
        mensagemErro.style.display = "none";
      }
    };
  
    selecionaOrigem.addEventListener("change", validacaoValoresIguais);
    selecionaDestino.addEventListener("change", validacaoValoresIguais);
  
    document.addEventListener("keydown", (event) => {
      if (event.key === "Enter") {
        event.preventDefault();

        if (!btnBuscar.disabled) {
          btnBuscar.click();
        }
      }
    });
  
    document.addEventListener("keydown", (event) => {
      if (event.ctrlKey && event.key === "l") {
        event.preventDefault();
        btnLimpar.click();
      }
    });
  
    btnBuscar.addEventListener("click", (event) => {
      event.preventDefault();
      const origem = selecionaOrigem.value;
      const destino = selecionaDestino.value;
      const algoritmo = document.getElementById("algoritmo").value;
  
      loader.style.display = 'block';
  
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
        })
        .finally(() => {
          loader.style.display = 'none';
        });
    });
  
    btnLimpar.addEventListener("click", () => {
      limpaResultado();
      selecionaOrigem.selectedIndex = 0;
      selecionaDestino.selectedIndex = 0;
      validacaoValoresIguais();
    });
  
    validacaoValoresIguais();
  });
  