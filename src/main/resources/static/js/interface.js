document.addEventListener("DOMContentLoaded", () => {
    // Obtém os elementos HTML que são manipulados no script
    const btnBuscar = document.getElementById("btnBuscar");
    const btnLimpar = document.getElementById("btnLimpar");
    const selecionaOrigem = document.getElementById("origem");
    const selecionaDestino = document.getElementById("destino");
    const selecionaAlgoritmo = document.getElementById("algoritmo");
    const mensagemErro = document.getElementById("mensagemErro");
    const loader = document.getElementById("loader");

    // Lista de países/capitais que serão usadas nas opções dos selects
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
    
    // Função que retorna as opções para os selects de origem e destino
    const opcoes = () => {
        return capitais.map(pais => `<option value="${pais}">${pais}</option>`).join('');
    };

    // Preenche os selects de origem e destino com as opções de capitais
    selecionaOrigem.innerHTML = opcoes();
    selecionaDestino.innerHTML = opcoes();

    // Lista de algoritmos que serão usados nas opções do select de algoritmos
    const opcoesAlgoritmo = [
        { valor: "Largura", nome: "Busca em Largura" },
        { valor: "Aprofundamento Iterativo", nome: "Aprofundamento Iterativo" },
        { valor: "A*", nome: "A*" }
    ];

    // Função que retorna as opções para o select de algoritmos
    const opcoesAlgoritmos = () => {
        return opcoesAlgoritmo.map(algoritmo =>
            `<option value="${algoritmo.valor}">${algoritmo.nome}</option>`
        ).join('');
    };

    // Preenche o select de algoritmos com as opções de algoritmos
    selecionaAlgoritmo.innerHTML = opcoesAlgoritmos();

    // Validação dos campos de origem e destino para garantir que não sejam iguais
    validacaoEventos(selecionaOrigem, selecionaDestino, btnBuscar, mensagemErro);

    validacaoValoresIguais(selecionaOrigem.value, selecionaDestino.value, btnBuscar, mensagemErro);

    // Adiciona um listener para pressionamento da tecla "Enter", que aciona o botão "Buscar"
    document.addEventListener("keydown", (event) => {
        if (event.key === "Enter") {
            event.preventDefault();

            if (!btnBuscar.disabled) {
                btnBuscar.click();
            }
        }
    });

    // Adiciona um listener para pressionamento da tecla "Ctrl + L", que aciona o botão "Limpar"
    document.addEventListener("keydown", (event) => {
        if (event.ctrlKey && event.key === "l") {
            event.preventDefault();
            btnLimpar.click();
        }
    });

    // Evento de clique no botão "Buscar" para buscar a rota entre origem e destino
    btnBuscar.addEventListener("click", (event) => {
        event.preventDefault();
        const origem = selecionaOrigem.value;
        const destino = selecionaDestino.value;
        const algoritmo = selecionaAlgoritmo.value;

        loader.style.display = 'block';// Mostra o loader/carregando

        // Chama a função buscaRota e trata o resultado ou erro
        buscaRota(origem, destino, algoritmo)
            .then(resultado => {
                mostraResultado(resultado);// Mostra o resultado da busca
            })
            .catch(erro => {
                let mensagemErro;
                // Trata o erro, exibindo uma mensagem
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
                loader.style.display = 'none';// Esconde o carregando
            });
    });

    // Evento de clique no botão "Limpar" para resetar os campos e resultados
    btnLimpar.addEventListener("click", () => {
        loader.style.display = 'block'; // Mostra o louder/carregando

        setTimeout(() => {
            // Limpa os resultados e reseta os selects
            limpaResultado();
            selecionaOrigem.selectedIndex = 0;
            selecionaDestino.selectedIndex = 0;
            selecionaAlgoritmo.selectedIndex = 0;

            // Valida novamente para garantir que os campos de origem e destino não sejam iguais
            validacaoValoresIguais(selecionaOrigem.value, selecionaDestino.value, btnBuscar, mensagemErro);
            
            loader.style.display = 'none';// Esconde o loader/carregando
        }, 10);
    });

    // Adiciona um listener para navegação nos selects com as teclas "ArrowDown" e "ArrowUp"
    document.addEventListener("keydown", (event) => {
        if (event.key === "ArrowDown" || event.key === "ArrowUp") {
            event.preventDefault();

            // Lista de campos que podem ser navegados
            const campos = [selecionaOrigem, selecionaDestino, selecionaAlgoritmo];
            const indiceAtual = campos.indexOf(document.activeElement);

            // Se pressionado "ArrowDown", move o foco para o próximo campo
            if (event.key === "ArrowDown") {

                const proximoIndice = (indiceAtual + 1) % campos.length;
                campos[proximoIndice].focus();
            } 
            // Se pressionado "ArrowUp", move o foco para o campo anterior
            else if (event.key === "ArrowUp") {

                const indiceAnterior = (indiceAtual - 1 + campos.length) % campos.length;
                campos[indiceAnterior].focus();
            }
        }
    });
});
