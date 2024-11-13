package br.com.moedaconversor.modelo;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conversor {

    public ConversorRecord retornaMoeda (Conversor conversor, String moeda_base) {

        String apiKey = System.getenv("api_key");
        if (apiKey == null) {
            throw new RuntimeException("apikey não encontrada");
        }

        URI url = URI.create("https://v6.exchangerate-api.com/v6/"+apiKey+"/latest/"+moeda_base);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(url)
                .build();

        HttpResponse<String> response = null;
        try {
            response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Runtime Exception: " + e.getMessage());
        }

        return new Gson().fromJson(response.body(), ConversorRecord.class);

    }
}