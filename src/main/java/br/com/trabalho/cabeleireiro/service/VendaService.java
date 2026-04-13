package br.com.trabalho.cabeleireiro.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Service;

import br.com.trabalho.cabeleireiro.dto.VendaProdutoRequest;
import br.com.trabalho.cabeleireiro.dto.VendaResumoResponse;
import br.com.trabalho.cabeleireiro.exception.BusinessException;
import br.com.trabalho.cabeleireiro.exception.ResourceNotFoundException;
import br.com.trabalho.cabeleireiro.model.Cliente;
import br.com.trabalho.cabeleireiro.model.Produto;
import br.com.trabalho.cabeleireiro.repository.ClienteRepository;
import br.com.trabalho.cabeleireiro.repository.ProdutoRepository;

// Regras de negocio das vendas de produtos.
@Service
public class VendaService {

    private final ClienteRepository clienteRepository;
    private final ProdutoRepository produtoRepository;

    // Recebe os repositorios usados na venda.
    public VendaService(ClienteRepository clienteRepository, ProdutoRepository produtoRepository) {
        this.clienteRepository = clienteRepository;
        this.produtoRepository = produtoRepository;
    }

    // Realiza a venda do produto, calcula desconto e reduz o estoque.
    public VendaResumoResponse venderProduto(VendaProdutoRequest request) {
        Cliente cliente = clienteRepository.findById(request.getClienteId())
                .orElseThrow(() -> new ResourceNotFoundException("Cliente nao encontrado"));
        Produto produto = produtoRepository.findById(request.getProdutoId())
                .orElseThrow(() -> new ResourceNotFoundException("Produto nao encontrado"));

        if (produto.getEstoque() < request.getQuantidade()) {
            throw new BusinessException("Estoque insuficiente para a venda");
        }

        BigDecimal subtotal = produto.getPreco().multiply(BigDecimal.valueOf(request.getQuantidade()));
        BigDecimal desconto = classificarCliente(cliente)
                .equals("PROFISSIONAL")
                        ? subtotal.multiply(BigDecimal.valueOf(0.10))
                        : BigDecimal.ZERO;
        BigDecimal total = subtotal.subtract(desconto).setScale(2, RoundingMode.HALF_UP);

        produtoRepository.atualizarEstoque(produto.getId(), produto.getEstoque() - request.getQuantidade());

        return new VendaResumoResponse(
                produto.getNome(),
                request.getQuantidade(),
                subtotal.setScale(2, RoundingMode.HALF_UP),
                desconto.setScale(2, RoundingMode.HALF_UP),
                total,
                classificarCliente(cliente));
    }

    // Classifica o cliente para uso na regra de desconto e na resposta final.
    private String classificarCliente(Cliente cliente) {
        return cliente.isProfissional() ? "PROFISSIONAL" : "CLIENTE_FINAL";
    }
}
