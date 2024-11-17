// Função de validação para garantir que os valores de origem e destino sejam diferentes
const validacaoValoresIguais = (origem, destino, btnBuscar, mensagemErro) => {
  // Se origem e destino forem iguais, desabilita o botão de busca e exibe a mensagem de erro
  if (origem === destino) {
      btnBuscar.disabled = true;
      mensagemErro.textContent = 'Selecione países diferentes em origem e destino.';
      mensagemErro.style.display = "block"; // Torna a mensagem de erro visível
  } else {
      // Caso contrário, habilita o botão de busca e esconde a mensagem de erro
      btnBuscar.disabled = false;
      mensagemErro.style.display = "none";
  }
};

// Função que adiciona os eventos de validação para os campos de origem e destino
const validacaoEventos = (selecionaOrigem, selecionaDestino, btnBuscar, mensagemErro) => {
  // Quando o valor do select "origem" é alterado, a validação é chamada
  selecionaOrigem.addEventListener("change", () => {
    validacaoValoresIguais(selecionaOrigem.value, selecionaDestino.value, btnBuscar, mensagemErro);
  });

  // Quando o valor do select "destino" é alterado, a validação também é chamada
  selecionaDestino.addEventListener("change", () => {
    validacaoValoresIguais(selecionaOrigem.value, selecionaDestino.value, btnBuscar, mensagemErro);
  });
};