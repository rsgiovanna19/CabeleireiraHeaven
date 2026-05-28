package br.com.trabalho.cabeleireiro.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;

import br.com.trabalho.cabeleireiro.dto.ViaCepResponse;
import br.com.trabalho.cabeleireiro.exception.BusinessException;

// Cliente HTTP simples para consumir a API ViaCEP.
@Service
public class ViaCepService {

    // Cliente HTTP usado para chamar a API externa.
    private final RestClient restClient;

    public ViaCepService(@Value("${integracao.viacep.url}") String viaCepUrl) {
        this.restClient = RestClient.builder()
                .baseUrl(viaCepUrl)
                .build();
    }

    // Busca os dados do CEP informado na API externa.
    public ViaCepResponse buscarCep(String cep) {
        try {
            ViaCepResponse response = restClient.get()
                    .uri("/{cep}/json/", cep)
                    .retrieve()
                    .body(ViaCepResponse.class);

            // Se a API disser que o CEP nao existe, o cadastro falha.
            if (response == null || response.isErro()) {
                throw new BusinessException("CEP nao encontrado na API ViaCEP");
            }

            return response;
        } catch (RestClientException exception) {
            // Erro simples para quando a API externa estiver fora do ar.
            throw new BusinessException("Falha ao consultar API externa de CEP");
        }
    }
}
