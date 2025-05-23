package com.sc30.conversor.service;

import com.google.gson.Gson;
import com.sc30.conversor.dto.ConversorDto;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversorService {
    private static final String API_KEY = "4df3966442cca204736d0aea";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    public double convertirMoneda(String base, String destino, double cantidad) throws IOException, InterruptedException {
        String url = BASE_URL + API_KEY+ "/pair/" + base + "/" + destino;

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

//        System.out.println("Respuesta de la API: " + response.body());


        Gson gson = new Gson();
        ConversorDto dto = gson.fromJson(response.body(), ConversorDto.class);

        return cantidad*dto.getConversion_rate();
    }
}
