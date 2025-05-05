import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversorApp {

    public Conversor buscaConversor (String moeda){
        URI endereco = URI.create("https://v6.exchangerate-api.com/v6/YOUR_API_KEY_HERE/latest/" + moeda);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();

        try {
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            return  new Gson().fromJson(response.body(),  Conversor.class);
        } catch (IOException |InterruptedException e) {
            throw new RuntimeException("Sem respostas por aqui...", e);
        }

    }
}
