// Intercepta erros e evita popups ou logs de erro padrão
window.onerror = function (msg, url, lineNo, columnNo, error) {
    console.log("Erro interceptado:", msg);
    console.log(error);
    return true;
};

// Inicializa o mapa
let mapa;
let servicoDirecoes;
let renderizadorDirecoes;

function inicializaMapa() {
    mapa = new google.maps.Map(document.getElementById("map"), {
        center: { lat: 50.8503, lng: 4.3517 }, // Inicializa mapa no centro da Europa
        zoom: 4,
    });

    servicoDirecoes = new google.maps.DirectionsService();
    renderizadorDirecoes = new google.maps.DirectionsRenderer();
    renderizadorDirecoes.setMap(mapa);
}
