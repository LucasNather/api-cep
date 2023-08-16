package br.com.lucasnather.apicep.modelos;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaCep {
    public ViaCep buscaApi(String cep) {
        String url = "https://viacep.com.br/ws/" + cep + "/json/";

        try {

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();

            return new Gson().fromJson(json, ViaCep.class);
        } catch (Exception e) {
            throw new RuntimeException("Nao foi possivel obter o cep: Deve possuir 8 numeros");
        }
    }
}
