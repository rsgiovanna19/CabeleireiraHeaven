package br.com.trabalho.cabeleireiro.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.trabalho.cabeleireiro.model.Cliente;
import br.com.trabalho.cabeleireiro.service.ClienteService;
import jakarta.validation.Valid;

// Controller e a porta de entrada HTTP.
// Esta classe recebe requisicoes da internet para a entidade cliente.
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    // Recebe o service responsavel pelas regras de negocio.
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    // Endpoint GET /clientes.
    // Lista todos os clientes.
    @GetMapping
    public List<Cliente> listar() {
        return clienteService.listarTodos();
    }

    // Endpoint GET /clientes/{id}.
    // Busca um cliente especifico.
    @GetMapping("/{id}")
    public Cliente buscarPorId(@PathVariable Long id) {
        return clienteService.buscarPorId(id);
    }

    // Endpoint POST /clientes.
    // Cria um novo cliente com base no JSON enviado.
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente criar(@Valid @RequestBody Cliente cliente) {
        return clienteService.criar(cliente);
    }

    // Endpoint PUT /clientes/{id}.
    // Atualiza um cliente existente.
    @PutMapping("/{id}")
    public Cliente atualizar(@PathVariable Long id, @Valid @RequestBody Cliente cliente) {
        return clienteService.atualizar(id, cliente);
    }

    // Endpoint DELETE /clientes/{id}.
    // Remove um cliente do sistema.
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id) {
        clienteService.remover(id);
    }
}
