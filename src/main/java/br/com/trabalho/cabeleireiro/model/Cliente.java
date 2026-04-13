package br.com.trabalho.cabeleireiro.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

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

    // Indica se a pessoa e um profissional que pode comprar cursos
    // e receber alguns descontos.
    private boolean profissional;

    // Construtor vazio.
    // O Spring e o Jackson usam este construtor para criar objetos automaticamente.
    public Cliente() {
    }

    // Construtor completo usado quando queremos montar o objeto com todos os dados.
    public Cliente(Long id, String nome, String telefone, String email, boolean profissional) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
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

    // Informa se a pessoa e profissional.
    public boolean isProfissional() {
        return profissional;
    }

    // Marca se a pessoa e ou nao profissional.
    public void setProfissional(boolean profissional) {
        this.profissional = profissional;
    }
}
