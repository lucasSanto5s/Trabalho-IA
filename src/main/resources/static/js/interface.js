document.addEventListener("DOMContentLoaded", () => {
    const btnBuscar = document.getElementById("btnBuscar");
    const btnLimpar = document.getElementById("btnLimpar");
    const selecionaOrigem = document.getElementById("origem");
    const selecionaDestino = document.getElementById("destino");
    const selecionaAlgoritmo = document.getElementById("algoritmo");
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

    const opcoesAlgoritmo = [
        { valor: "Largura", nome: "Busca em Largura" },
        { valor: "Aprofundamento Iterativo", nome: "Aprofundamento Iterativo" },
        { valor: "A*", nome: "A*" }
    ];

    const opcoesAlgoritmos = () => {
        return opcoesAlgoritmo.map(algoritmo =>
            `<option value="${algoritmo.valor}">${algoritmo.nome}</option>`
        ).join('');
    };

    selecionaAlgoritmo.innerHTML = opcoesAlgoritmos();

    validacaoEventos(selecionaOrigem, selecionaDestino, btnBuscar, mensagemErro);

    validacaoValoresIguais(selecionaOrigem.value, selecionaDestino.value, btnBuscar, mensagemErro);

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
        const algoritmo = selecionaAlgoritmo.value;

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
        loader.style.display = 'block';

        setTimeout(() => {
            limpaResultado();
            selecionaOrigem.selectedIndex = 0;
            selecionaDestino.selectedIndex = 0;
            selecionaAlgoritmo.selectedIndex = 0;

            validacaoValoresIguais(selecionaOrigem.value, selecionaDestino.value, btnBuscar, mensagemErro);
            
            loader.style.display = 'none';
        }, 10);
    });

    document.addEventListener("keydown", (event) => {
        if (event.key === "ArrowDown" || event.key === "ArrowUp") {
            event.preventDefault();

            const campos = [selecionaOrigem, selecionaDestino, selecionaAlgoritmo];
            const indiceAtual = campos.indexOf(document.activeElement);

            if (event.key === "ArrowDown") {

                const proximoIndice = (indiceAtual + 1) % campos.length;
                campos[proximoIndice].focus();
            } else if (event.key === "ArrowUp") {

                const indiceAnterior = (indiceAtual - 1 + campos.length) % campos.length;
                campos[indiceAnterior].focus();
            }
        }
    });
});
