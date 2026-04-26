//imports necessários

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

// o controller cliente recebe as requisições sobre os clientes
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    // Recebendo o clienteService via injeção de dependência, pois necessitamos das regras de negócio para os clientes
        public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    //GET clientes -> lista todos os clientes do sistema
    @GetMapping
    public List<Cliente> listar() {
        return clienteService.listarTodos();
    }

    //GET clientes por id -> lista os clientes por id.
    @GetMapping("/{id}")
    public Cliente buscarPorId(@PathVariable Long id) {
        return clienteService.buscarPorId(id);
    }

    //POST clientes -> cria um novo cliente no sistema
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) //se retornar com sucesso, retorna o status 201
    public Cliente criar(@Valid @RequestBody Cliente cliente) {
        return clienteService.criar(cliente);
    }

    //PUT clientes por id -> atualiza os clientes via id
    @PutMapping("/{id}")
    public Cliente atualizar(@PathVariable Long id, @Valid @RequestBody Cliente cliente) {
        return clienteService.atualizar(id, cliente);
    }

    // Delete por id -> remove o cliente por id 
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id) {
        clienteService.remover(id);
    }
}
