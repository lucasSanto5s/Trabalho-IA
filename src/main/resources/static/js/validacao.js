const validacaoValoresIguais = (origem, destino, btnBuscar, mensagemErro) => {
  if (origem === destino) {
      btnBuscar.disabled = true;
      mensagemErro.textContent = 'Selecione países diferentes em origem e destino.';
      mensagemErro.style.display = "block";
  } else {
      btnBuscar.disabled = false;
      mensagemErro.style.display = "none";
  }
};

const validacaoEventos = (selecionaOrigem, selecionaDestino, btnBuscar, mensagemErro) => {
  selecionaOrigem.addEventListener("change", () => {
    validacaoValoresIguais(selecionaOrigem.value, selecionaDestino.value, btnBuscar, mensagemErro);
  });

  selecionaDestino.addEventListener("change", () => {
    validacaoValoresIguais(selecionaOrigem.value, selecionaDestino.value, btnBuscar, mensagemErro);
  });
};