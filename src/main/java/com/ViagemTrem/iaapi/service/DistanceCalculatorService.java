package com.ViagemTrem.iaapi.service;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Properties;

@Service
public class DistanceCalculatorService {

    private final String API_KEY = loadApiKey();
    private static final String CSV_FILE_PATH = "src/main/java/com/ViagemTrem/iaapi/Dados/conteudo.csv"; // Caminho do
                                                                                                         // arquivo CSV
    private final Map<String, Integer> distanceMap = new HashMap<>();
    public Map<String, String> countryToCapitalMap = new HashMap<>(); // Mapeia países para suas capitais

    // Inicializa o mapeamento de países para capitais
    private void initializeCountryToCapitalMap() {
        countryToCapitalMap.put("Albânia", "Tirana");
        countryToCapitalMap.put("Alemanha", "Berlim");
        countryToCapitalMap.put("Andorra", "Andorra-a-Velha");
        countryToCapitalMap.put("Armênia", "Yerevan");
        countryToCapitalMap.put("Áustria", "Viena");
        countryToCapitalMap.put("Azerbaijão", "Baku");
        countryToCapitalMap.put("Bélgica", "Bruxelas");
        countryToCapitalMap.put("Bielorrússia", "Minsk");
        countryToCapitalMap.put("Bósnia-Herzegovina", "Sarajevo");
        countryToCapitalMap.put("Bulgária", "Sófia");
        countryToCapitalMap.put("Cazaquistão", "Astana");
        countryToCapitalMap.put("Croácia", "Zagreb");
        countryToCapitalMap.put("Dinamarca", "Copenhague");
        countryToCapitalMap.put("Eslováquia", "Bratislava");
        countryToCapitalMap.put("Eslovênia", "Liubliana");
        countryToCapitalMap.put("Espanha", "Madrid");
        countryToCapitalMap.put("Estônia", "Talín");
        countryToCapitalMap.put("Finlândia", "Helsinque");
        countryToCapitalMap.put("França", "Paris");
        countryToCapitalMap.put("Geórgia", "Tiblissi");
        countryToCapitalMap.put("Grécia", "Atenas");
        countryToCapitalMap.put("Hungria", "Budapeste");
        countryToCapitalMap.put("Itália", "Roma");
        countryToCapitalMap.put("Kosovo", "Pristina");
        countryToCapitalMap.put("Letônia", "Riga");
        countryToCapitalMap.put("Lituânia", "Vilnius");
        countryToCapitalMap.put("Liechtenstein", "Vaduz");
        countryToCapitalMap.put("Luxemburgo", "Cidade de Luxemburgo");
        countryToCapitalMap.put("Macedônia do Norte", "Escópia");
        countryToCapitalMap.put("Moldávia", "Chisinau");
        countryToCapitalMap.put("Montenegro", "Podgorica");
        countryToCapitalMap.put("Noruega", "Oslo");
        countryToCapitalMap.put("Países Baixos", "Amsterdã");
        countryToCapitalMap.put("Polônia", "Varsóvia");
        countryToCapitalMap.put("Portugal", "Lisboa");
        countryToCapitalMap.put("Inglaterra", "Londres");
        countryToCapitalMap.put("Romênia", "Bucareste");
        countryToCapitalMap.put("Rússia", "Moscou");
        countryToCapitalMap.put("San Marino", "San Marino");
        countryToCapitalMap.put("Sérvia", "Belgrado");
        countryToCapitalMap.put("Suécia", "Estocolmo");
        countryToCapitalMap.put("Suíça", "Berna");
        countryToCapitalMap.put("República Tcheca", "Praga");
        countryToCapitalMap.put("Ucrânia", "Kiev");
        countryToCapitalMap.put("Vaticano", "Cidade do Vaticano");
    }
  // Carrega a chave da API de um arquivo de propriedades
    private String loadApiKey() throws IOException {
        Properties properties = new Properties();

        try (InputStream input = new FileInputStream( "src\\main\\resources\\application.properties")) {        
            properties.load(input);
            return properties.getProperty("API_KEY");
        }
    }

    // Construtor para verificar ou preencher o CSV e carregar os dados no Map
    public DistanceCalculatorService() throws IOException {
        initializeCountryToCapitalMap(); // Inicializa o mapeamento de países para capitais

    
        File csvFile = new File(CSV_FILE_PATH);

        if (csvFile.exists() && csvFile.length() > 0) {
            loadDistancesFromFile(CSV_FILE_PATH); // Se o CSV já estiver preenchido, carrega os dados
        } else {
            precalculateDistances(); // Se o CSV estiver vazio ou não existir, calcula as distâncias
            loadDistancesFromFile(CSV_FILE_PATH); // Carrega os dados no Map após a criação
        }

       
    }

    // Método para pré-calcular as distâncias e armazená-las no CSV
    private void precalculateDistances() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CSV_FILE_PATH))) {
            writer.write("Pais1,Pais2,Distancia\n"); // Cabeçalho do CSV

            // Lista de países para calcular as distâncias
            String[] countries = {
                    "Albânia", "Alemanha", "Andorra", "Armênia", "Áustria", "Azerbaijão",
                    "Bélgica", "Bielorrússia", "Bósnia-Herzegovina", "Bulgária", "Cazaquistão",
                    "Croácia", "Dinamarca", "Eslováquia", "Eslovênia", "Espanha", "Estônia",
                    "Finlândia", "França", "Geórgia", "Grécia", "Hungria", "Itália", "Kosovo",
                    "Letônia", "Lituânia", "Liechtenstein", "Luxemburgo", "Macedônia do Norte",
                    "Moldávia", "Montenegro", "Noruega", "Países Baixos", "Polônia", "Portugal",
                    "Inglaterra", "Romênia", "Rússia", "San Marino", "Sérvia", "Suécia",
                    "Suíça", "República Tcheca", "Ucrânia", "Vaticano"
            };

            for (int i = 0; i < countries.length; i++) {
                for (int j = i + 1; j < countries.length; j++) {
                    String origem = countries[i];
                    String destino = countries[j];
                    double distance = calculateDistance(origem, destino);

                    // Escreve no arquivo CSV
                    writer.write(origem + "," + destino + "," + distance + "\n");
                    writer.write(destino + "," + origem + "," + distance + "\n");
                }
            }
        }
    }

    // Método para carregar as distâncias do arquivo CSV para o Map
    private void loadDistancesFromFile(String filepath) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line;
            br.readLine(); // Pula o cabeçalho
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String key = data[0] + "-" + data[1];
                distanceMap.put(key, (int) Double.parseDouble(data[2]));
            }
        }
    }

    // Método para obter a distância entre duas capitais dos paises correspondentes;
    public int getDistance(String origem, String destino) {
        String key = origem + "-" + destino;
        return distanceMap.getOrDefault(key, -1); // Retorna -1 se a distância não for encontrada
    }

    // Método para calcular a distância usando as capitais dos países
    private double calculateDistance(String origem, String destino) throws IOException {
        String capitalOrigem = countryToCapitalMap.get(origem);
        String capitalDestino = countryToCapitalMap.get(destino);

        if (capitalOrigem == null || capitalDestino == null) {
            throw new IllegalArgumentException("Não foi possível encontrar a capital de um dos países.");
        }

        double[] coords1 = getCoordinates(capitalOrigem);
        double[] coords2 = getCoordinates(capitalDestino);

        if (coords1 != null && coords2 != null) {
            return calculateDistance(coords1[0], coords1[1], coords2[0], coords2[1]);
        } else {
            throw new IllegalArgumentException("Não foi possível obter as coordenadas entre "+capitalOrigem +" e "+capitalDestino );
        }
    }

    // Método auxiliar para obter coordenadas
    private double[] getCoordinates(String location) throws IOException {
        String urlString = "https://maps.googleapis.com/maps/api/geocode/json?address=" +
                location.replace(" ", "+") + "&key=" + API_KEY;
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        if (responseCode == 200) {
            Scanner scanner = new Scanner(url.openStream());
            StringBuilder response = new StringBuilder();
            while (scanner.hasNext()) {
                response.append(scanner.nextLine());
            }
            scanner.close();

            JSONObject json = new JSONObject(response.toString());
            if (!json.getJSONArray("results").isEmpty()) {
                JSONObject locationJson = json.getJSONArray("results").getJSONObject(0)
                        .getJSONObject("geometry").getJSONObject("location");
                double lat = locationJson.getDouble("lat");
                double lng = locationJson.getDouble("lng");
                return new double[] { lat, lng };
            }
        }
        return null;
    }

    // Método para calcular a distância entre duas coordenadas
    private double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        final int R = 6371; // Raio da Terra em km
        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                        * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return R * c;
    }
}