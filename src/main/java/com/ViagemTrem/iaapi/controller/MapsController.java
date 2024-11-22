package com.ViagemTrem.iaapi.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MapsController {

    @GetMapping("/maps-key")
    public ResponseEntity<String> getApiKey() {
        try {
            String apiKey = loadApiKey();
            return ResponseEntity.ok(apiKey);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao carregar a chave da API");
        }
    }

    private String loadApiKey() throws IOException {
        Properties properties = new Properties();
        try (InputStream input = new FileInputStream("src\\main\\resources\\application.properties")) {
            properties.load(input);
            return properties.getProperty("API_KEY");
        }
    }
}
