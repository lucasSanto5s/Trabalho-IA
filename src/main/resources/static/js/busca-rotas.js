document.addEventListener("DOMContentLoaded", () => {
    const btnBuscar = document.getElementById("btnBuscar");
    const btnLimpar = document.getElementById("btnLimpar");
    const selecionaOrigem = document.getElementById("origem");
    const selecionaDestino = document.getElementById("destino");
    const mensagemErro = document.getElementById("mensagemErro");

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

    btnBuscar.addEventListener("click", (event) => {
        event.preventDefault();
        const origem = selecionaOrigem.value;
        const destino = selecionaDestino.value;
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
        selecionaOrigem.selectedIndex = 0;
        selecionaDestino.selectedIndex = 0;
        validacaoValoresIguais();
    });

    validacaoValoresIguais();
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
