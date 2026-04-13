package br.com.trabalho.cabeleireiro.client;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

// Cliente Java simples para testar a API sem usar Postman.
// Ele envia uma requisicao HTTP e mostra a resposta no console.
public class ApiDemoClient {

    // Metodo principal do cliente de teste.
    public static void main(String[] args) throws Exception {
        // ObjectMapper e a classe do Jackson que converte objetos para JSON
        // e JSON para objetos.
        ObjectMapper mapper = new ObjectMapper().findAndRegisterModules();

        // Mapa que representa o corpo JSON da requisicao.
        Map<String, Object> payload = new LinkedHashMap<>();
        payload.put("clienteId", 1);
        payload.put("servicoId", 1);
        payload.put("dataHora", "2026-04-27T14:00:00");
        payload.put("observacoes", "Cliente prefere corte em camadas");

        // Converte os dados em texto JSON.
        String json = mapper.writeValueAsString(payload);

        // Abre a conexao HTTP com a rota da API.
        HttpURLConnection connection = (HttpURLConnection) new URL("http://localhost:8080/agendamentos").openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);

        // Envia o JSON para a API.
        try (OutputStream outputStream = connection.getOutputStream()) {
            outputStream.write(json.getBytes(StandardCharsets.UTF_8));
        }

        // Le a resposta da API e converte de volta para objeto Java.
        try (InputStream inputStream = connection.getInputStream()) {
            Map<?, ?> resposta = mapper.readValue(inputStream, Map.class);
            System.out.println("Resposta da API:");
            System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(resposta));
        }
    }
}
