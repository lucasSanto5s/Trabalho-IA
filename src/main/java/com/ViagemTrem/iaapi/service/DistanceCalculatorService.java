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
        adicionarDistanciasMapaBrasil();
    }

    private void adicionarDistanciasMapaBrasil() {
        // Porto Alegre
        distanceMap.put("Porto Alegre-Porto Alegre", 0);
        distanceMap.put("Porto Alegre-Florianópolis", 376);
        distanceMap.put("Porto Alegre-Curitiba", 547);
        distanceMap.put("Porto Alegre-São Paulo", 852);
        distanceMap.put("Porto Alegre-Rio de Janeiro", 1124);
        distanceMap.put("Porto Alegre-Belo Horizonte", 1341);
        distanceMap.put("Porto Alegre-Brasília", 1621);
        distanceMap.put("Porto Alegre-Cuiabá", 1679);
        distanceMap.put("Porto Alegre-Salvador", 2303);
        distanceMap.put("Porto Alegre-Fortaleza", 3241);
        distanceMap.put("Porto Alegre-Manaus", 3132);

        // Florianópolis
        distanceMap.put("Florianópolis-Porto Alegre", 376);
        distanceMap.put("Florianópolis-Florianópolis", 0);
        distanceMap.put("Florianópolis-Curitiba", 251);
        distanceMap.put("Florianópolis-São Paulo", 489);
        distanceMap.put("Florianópolis-Rio de Janeiro", 748);
        distanceMap.put("Florianópolis-Belo Horizonte", 973);
        distanceMap.put("Florianópolis-Brasília", 1315);
        distanceMap.put("Florianópolis-Cuiabá", 1544);
        distanceMap.put("Florianópolis-Salvador", 1931);
        distanceMap.put("Florianópolis-Fortaleza", 2858);
        distanceMap.put("Florianópolis-Manaus", 2982);

        // Curitiba
        distanceMap.put("Curitiba-Porto Alegre", 547);
        distanceMap.put("Curitiba-Florianópolis", 251);
        distanceMap.put("Curitiba-Curitiba", 0);
        distanceMap.put("Curitiba-São Paulo", 339);
        distanceMap.put("Curitiba-Rio de Janeiro", 676);
        distanceMap.put("Curitiba-Belo Horizonte", 821);
        distanceMap.put("Curitiba-Brasília", 1081);
        distanceMap.put("Curitiba-Cuiabá", 1302);
        distanceMap.put("Curitiba-Salvador", 1784);
        distanceMap.put("Curitiba-Fortaleza", 2671);
        distanceMap.put("Curitiba-Manaus", 2734);

        // São Paulo
        distanceMap.put("São Paulo-Porto Alegre", 852);
        distanceMap.put("São Paulo-Florianópolis", 489);
        distanceMap.put("São Paulo-Curitiba", 339);
        distanceMap.put("São Paulo-São Paulo", 0);
        distanceMap.put("São Paulo-Rio de Janeiro", 357);
        distanceMap.put("São Paulo-Belo Horizonte", 490);
        distanceMap.put("São Paulo-Brasília", 873);
        distanceMap.put("São Paulo-Cuiabá", 1326);
        distanceMap.put("São Paulo-Salvador", 1454);
        distanceMap.put("São Paulo-Fortaleza", 2369);
        distanceMap.put("São Paulo-Manaus", 2598);

        // Rio de Janeiro
        distanceMap.put("Rio de Janeiro-Porto Alegre", 1124);
        distanceMap.put("Rio de Janeiro-Florianópolis", 748);
        distanceMap.put("Rio de Janeiro-Curitiba", 676);
        distanceMap.put("Rio de Janeiro-São Paulo", 357);
        distanceMap.put("Rio de Janeiro-Rio de Janeiro", 0);
        distanceMap.put("Rio de Janeiro-Belo Horizonte", 340);
        distanceMap.put("Rio de Janeiro-Brasília", 933);
        distanceMap.put("Rio de Janeiro-Cuiabá", 1576);
        distanceMap.put("Rio de Janeiro-Salvador", 1210);
        distanceMap.put("Rio de Janeiro-Fortaleza", 2190);
        distanceMap.put("Rio de Janeiro-Manaus", 2849);

        // Belo Horizonte
        distanceMap.put("Belo Horizonte-Porto Alegre", 1341);
        distanceMap.put("Belo Horizonte-Florianópolis", 973);
        distanceMap.put("Belo Horizonte-Curitiba", 821);
        distanceMap.put("Belo Horizonte-São Paulo", 490);
        distanceMap.put("Belo Horizonte-Rio de Janeiro", 340);
        distanceMap.put("Belo Horizonte-Belo Horizonte", 0);
        distanceMap.put("Belo Horizonte-Brasília", 621);
        distanceMap.put("Belo Horizonte-Cuiabá", 1373);
        distanceMap.put("Belo Horizonte-Salvador", 964);
        distanceMap.put("Belo Horizonte-Fortaleza", 1893);
        distanceMap.put("Belo Horizonte-Manaus", 2446);

        // Brasília
        distanceMap.put("Brasília-Porto Alegre", 1621);
        distanceMap.put("Brasília-Florianópolis", 1315);
        distanceMap.put("Brasília-Curitiba", 1081);
        distanceMap.put("Brasília-São Paulo", 873);
        distanceMap.put("Brasília-Rio de Janeiro", 933);
        distanceMap.put("Brasília-Belo Horizonte", 621);
        distanceMap.put("Brasília-Brasília", 0);
        distanceMap.put("Brasília-Cuiabá", 880);
        distanceMap.put("Brasília-Salvador", 1059);
        distanceMap.put("Brasília-Fortaleza", 1688);
        distanceMap.put("Brasília-Manaus", 1939);

        // Salvador
        distanceMap.put("Salvador-Porto Alegre", 2303);
        distanceMap.put("Salvador-Florianópolis", 1931);
        distanceMap.put("Salvador-Curitiba", 1784);
        distanceMap.put("Salvador-São Paulo", 1454);
        distanceMap.put("Salvador-Rio de Janeiro", 1210);
        distanceMap.put("Salvador-Belo Horizonte", 964);
        distanceMap.put("Salvador-Brasília", 1059);
        distanceMap.put("Salvador-Cuiabá", 1915);
        distanceMap.put("Salvador-Salvador", 0);
        distanceMap.put("Salvador-Fortaleza", 1028);
        distanceMap.put("Salvador-Manaus", 2606);

        // Cuiabá
        distanceMap.put("Cuiabá-Porto Alegre", 1679);
        distanceMap.put("Cuiabá-Florianópolis", 1544);
        distanceMap.put("Cuiabá-Curitiba", 1302);
        distanceMap.put("Cuiabá-São Paulo", 1326);
        distanceMap.put("Cuiabá-Rio de Janeiro", 1576);
        distanceMap.put("Cuiabá-Belo Horizonte", 1373);
        distanceMap.put("Cuiabá-Brasília", 880);
        distanceMap.put("Cuiabá-Cuiabá", 0);
        distanceMap.put("Cuiabá-Salvador", 1915);
        distanceMap.put("Cuiabá-Fortaleza", 2329);
        distanceMap.put("Cuiabá-Manaus", 1453);

        // Fortaleza
        distanceMap.put("Fortaleza-Porto Alegre", 3241);
        distanceMap.put("Fortaleza-Florianópolis", 2858);
        distanceMap.put("Fortaleza-Curitiba", 2671);
        distanceMap.put("Fortaleza-São Paulo", 2369);
        distanceMap.put("Fortaleza-Rio de Janeiro", 2190);
        distanceMap.put("Fortaleza-Belo Horizonte", 1893);
        distanceMap.put("Fortaleza-Brasília", 1688);
        distanceMap.put("Fortaleza-Cuiabá", 2329);
        distanceMap.put("Fortaleza-Salvador", 1028);
        distanceMap.put("Fortaleza-Fortaleza", 0);
        distanceMap.put("Fortaleza-Manaus", 2384);

        // Manaus
        distanceMap.put("Manaus-Porto Alegre", 3132);
        distanceMap.put("Manaus-Florianópolis", 2982);
        distanceMap.put("Manaus-Curitiba", 2734);
        distanceMap.put("Manaus-São Paulo", 2589);
        distanceMap.put("Manaus-Rio de Janeiro", 2849);
        distanceMap.put("Manaus-Belo Horizonte", 2446);
        distanceMap.put("Manaus-Brasília", 1939);
        distanceMap.put("Manaus-Cuiabá", 1453);
        distanceMap.put("Manaus-Salvador", 2606);
        distanceMap.put("Manaus-Fortaleza", 2384);
        distanceMap.put("Manaus-Manaus", 0);
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
        return distanceMap.getOrDefault(key, 0); 
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