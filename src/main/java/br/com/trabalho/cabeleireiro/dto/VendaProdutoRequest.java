package br.com.trabalho.cabeleireiro.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

// Este objeto representa os dados enviados para vender um produto.
public class VendaProdutoRequest {
    // Cliente que esta comprando.
    @NotNull(message = "Cliente e obrigatorio")
    private Long clienteId;

    // Produto escolhido.
    @NotNull(message = "Produto e obrigatorio")
    private Long produtoId;

    // Quantidade comprada.
    @Min(value = 1, message = "Quantidade minima e 1")
    private int quantidade;

    // Construtor vazio para conversao de JSON.
    public VendaProdutoRequest() {
    }

    // Devolve o cliente da compra.
    public Long getClienteId() {
        return clienteId;
    }

    // Altera o cliente da compra.
    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    // Devolve o produto da compra.
    public Long getProdutoId() {
        return produtoId;
    }

    // Altera o produto da compra.
    public void setProdutoId(Long produtoId) {
        this.produtoId = produtoId;
    }

    // Devolve a quantidade comprada.
    public int getQuantidade() {
        return quantidade;
    }

    // Altera a quantidade comprada.
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
