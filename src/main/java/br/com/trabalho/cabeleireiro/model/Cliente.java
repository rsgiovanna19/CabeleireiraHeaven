package br.com.trabalho.cabeleireiro.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

// Representa uma pessoa cadastrada no sistema.
// Pode ser um cliente comum ou um profissional da area.
public class Cliente {
    private Long id;

    // Nome da pessoa.
    @NotBlank(message = "Nome do cliente e obrigatorio")
    private String nome;

    // Telefone para contato.
    @NotBlank(message = "Telefone e obrigatorio")
    private String telefone;

    // Email para cadastro e comunicacao.
    @Email(message = "Email invalido")
    private String email;

    // CEP usado para buscar endereco em API externa.
    @Pattern(regexp = "\\d{8}", message = "CEP deve conter 8 digitos")
    private String cep;

    // Campos preenchidos automaticamente a partir do CEP.
    private String logradouro;
    private String bairro;
    private String cidade;
    private String uf;

    // Indica se a pessoa e um profissional que pode comprar cursos
    // e receber alguns descontos.
    private boolean profissional;

    // Construtor vazio.
    // O Spring e o Jackson usam este construtor para criar objetos automaticamente.
    public Cliente() {
    }

    // Construtor completo usado quando queremos montar o objeto com todos os dados.
    // Construtor completo, agora incluindo os dados de endereco.
    public Cliente(Long id, String nome, String telefone, String email, String cep, String logradouro, String bairro,
            String cidade, String uf, boolean profissional) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.cep = cep;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.profissional = profissional;
    }

    // Devolve o codigo do cliente.
    public Long getId() {
        return id;
    }

    // Define o codigo do cliente.
    public void setId(Long id) {
        this.id = id;
    }

    // Devolve o nome.
    public String getNome() {
        return nome;
    }

    // Altera o nome.
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Devolve o telefone.
    public String getTelefone() {
        return telefone;
    }

    // Altera o telefone.
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    // Devolve o email.
    public String getEmail() {
        return email;
    }

    // Altera o email.
    public void setEmail(String email) {
        this.email = email;
    }

    // CEP informado no cadastro.
    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    // Rua ou avenida preenchida pelo ViaCEP.
    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    // Bairro preenchido pelo ViaCEP.
    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    // Cidade preenchida pelo ViaCEP.
    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    // UF preenchida pelo ViaCEP.
    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    // Informa se a pessoa e profissional.
    public boolean isProfissional() {
        return profissional;
    }

    // Marca se a pessoa e ou nao profissional.
    public void setProfissional(boolean profissional) {
        this.profissional = profissional;
    }
}
