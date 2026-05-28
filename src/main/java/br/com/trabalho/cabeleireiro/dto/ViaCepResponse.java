package br.com.trabalho.cabeleireiro.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

// Resposta simplificada da API ViaCEP.
@JsonIgnoreProperties(ignoreUnknown = true)
public class ViaCepResponse {
    // CEP devolvido pela API.
    private String cep;
    // Rua ou avenida do endereco.
    private String logradouro;
    // Bairro do endereco.
    private String bairro;
    // Cidade devolvida pelo ViaCEP.
    private String localidade;
    // Estado do endereco.
    private String uf;

    // Quando vier true, significa que o CEP nao foi encontrado.
    @JsonProperty("erro")
    private boolean erro;

    public ViaCepResponse() {
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public boolean isErro() {
        return erro;
    }

    public void setErro(boolean erro) {
        this.erro = erro;
    }
}
