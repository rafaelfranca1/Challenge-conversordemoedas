import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conversao {
    private String result;
    private ConversionRates conversion_rates;
    private String moedaAtual;
    private String moedaDestino;

    public Conversao(String moedaAtual, String moedaDestino) {
        this.moedaAtual = moedaAtual;
        this.moedaDestino = moedaDestino;

        String key = "0f288f53f3d08a334bc80309";
        String endereco = "https://v6.exchangerate-api.com/v6/" + key + "/latest/" + moedaAtual;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco)).build();
        String json;

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            json = response.body();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Conversao conversaoTemp = gson.fromJson(json, Conversao.class);

        this.result = conversaoTemp.result;
        this.conversion_rates = conversaoTemp.conversion_rates;
    }

    public double converteMoeda(double valor) {
        switch (moedaDestino) {
            case "BRL":
                return valor * conversion_rates.BRL();
            case "USD":
                return valor * conversion_rates.USD();
            case "EUR":
                return valor * conversion_rates.EUR();
            case "JPY":
                return valor * conversion_rates.JPY();
            default:
                return valor;
        }
    }
}
