//importando pacotes necessários para a classe de requisição da venda de produto
package br.com.trabalho.cabeleireiro.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

//DTO = Data Transfer Object, ou seja, um objeto usado para transferir dados entre camadas da aplicação
//Este objeto representa os dados enviados para vender um produto

public class VendaProdutoRequest {
    // Cliente que esta comprando
    @NotNull(message = "Cliente é obrigatorio")    //evita que o cliente seja nulo. Preciso de um usuário para comprar o produto
    private Long clienteId;

    // Produto escolhido.
    @NotNull(message = "Produto é obrigatorio") //evita que o produto seja nulo.
    private Long produtoId;

    // Quantidade comprada.
    @Min(value = 1, message = "Quantidade minima é 1")  //necessário no minimo 1 produto para ter uma compra
    private int quantidade;

    // Construtor vazio para conversao de JSON para objeto funcionar sem erros
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
