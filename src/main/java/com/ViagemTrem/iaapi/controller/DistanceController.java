
package com.ViagemTrem.iaapi.controller;

import com.ViagemTrem.iaapi.service.DistanceCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DistanceController {

    @Autowired
    private DistanceCalculatorService distanceCalculatorService;

    @GetMapping("/calcularDistancia")
    public String calcularDistancia(@RequestParam String origem, @RequestParam String destino) {
        try {
            double distancia = distanceCalculatorService.getDistance(origem, destino);
            return String.format("Distância em linha reta: %.2f km", distancia);
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }
}
