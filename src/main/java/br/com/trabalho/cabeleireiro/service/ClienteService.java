package br.com.trabalho.cabeleireiro.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.trabalho.cabeleireiro.exception.BusinessException;
import br.com.trabalho.cabeleireiro.exception.ResourceNotFoundException;
import br.com.trabalho.cabeleireiro.dto.ViaCepResponse;
import br.com.trabalho.cabeleireiro.model.Cliente;
import br.com.trabalho.cabeleireiro.repository.ClienteRepository;

// Camada de regra de negocio dos clientes.
// O controller chama esta classe, e ela decide o que pode ou nao pode ser feito.
@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;
    // Service que chama a API externa do ViaCEP.
    private final ViaCepService viaCepService;

    // Recebe o repositorio que fala com o banco.
    public ClienteService(ClienteRepository clienteRepository, ViaCepService viaCepService) {
        this.clienteRepository = clienteRepository;
        this.viaCepService = viaCepService;
    }

    // Lista todos os clientes.
    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    // Busca um cliente e dispara erro se ele nao existir.
    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente nao encontrado"));
    }

    // Cria um novo cliente depois de validar os dados.
    public Cliente criar(Cliente cliente) {
        validarCliente(cliente);
        // Se vier CEP, busca o endereco antes de salvar.
        preencherEnderecoPorCep(cliente);
        return clienteRepository.save(cliente);
    }

    // Atualiza um cliente existente.
    public Cliente atualizar(Long id, Cliente cliente) {
        buscarPorId(id);
        cliente.setId(id);
        validarCliente(cliente);
        // Atualiza o endereco de novo quando o CEP for informado.
        preencherEnderecoPorCep(cliente);
        return clienteRepository.update(cliente);
    }

    // Remove um cliente existente.
    public void remover(Long id) {
        buscarPorId(id);
        clienteRepository.deleteById(id);
    }

    // Regra simples de validacao do telefone.
    private void validarCliente(Cliente cliente) {
        if (cliente.getTelefone() != null && cliente.getTelefone().replaceAll("\\D", "").length() < 10) {
            throw new BusinessException("Telefone deve conter ao menos 10 digitos");
        }
    }

    // Quando o CEP e informado, a API busca o endereco automaticamente.
    private void preencherEnderecoPorCep(Cliente cliente) {
        if (cliente.getCep() == null || cliente.getCep().isBlank()) {
            return;
        }

        // Consulta o ViaCEP e copia os dados mais importantes para o cliente.
        ViaCepResponse response = viaCepService.buscarCep(cliente.getCep());
        cliente.setCep(response.getCep().replaceAll("\\D", ""));
        cliente.setLogradouro(response.getLogradouro());
        cliente.setBairro(response.getBairro());
        cliente.setCidade(response.getLocalidade());
        cliente.setUf(response.getUf());
    }
}
