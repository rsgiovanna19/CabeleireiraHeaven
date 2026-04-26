//simulação de um cliente para testar a API sem uso do postman. 

//importando os pacotes necessários p funcionar a aplicação
package br.com.trabalho.cabeleireiro.client;

// Importações de classes Java para lidar com conexões HTTP, fluxos de entrada/saída e manipulação de JSON.
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;

// Importação da classe ObjectMapper do Jackson para converter objetos Java em JSON e vice-versa.
import com.fasterxml.jackson.databind.ObjectMapper;

// Cliente Java simples para testar a API sem usar Postman - simular o consumo da API, sem necessitar do Postman nesse momento.
// Ele envia uma requisicao HTTP e mostra a resposta no console.
public class ApiDemoClient {

    // Metodo principal do cliente de teste.
    public static void main(String[] args) throws Exception {
        //transformação de objetos java p json e vice-versa.
        ObjectMapper mapper = new ObjectMapper().findAndRegisterModules();

        //preenchimento dos dados do agendamento em um mapa, que depois será convertido para JSON
        Map<String, Object> payload = new LinkedHashMap<>();
        payload.put("clienteId", 1);
        payload.put("servicoId", 1);
        payload.put("dataHora", "2026-04-27T14:00:00");
        payload.put("observacoes", "Cliente prefere corte em camadas");

        // Converte os dados em texto JSON.
        String json = mapper.writeValueAsString(payload);

        // Abre a conexao HTTP com a rota da API de agendamento
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
            //resposta formatada na saída do console 
            System.out.println("Resposta da API:");
            System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(resposta));
        }
    }
}
