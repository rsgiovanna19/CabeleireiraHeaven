package br.com.trabalho.cabeleireiro.dto;

import java.math.BigDecimal;

// Este objeto e a resposta pronta para o usuario depois de uma venda.
public class VendaResumoResponse {
    private String item;
    private int quantidade;
    private BigDecimal subtotal;
    private BigDecimal desconto;
    private BigDecimal total;
    private String categoriaCliente;

    // Construtor vazio para serializacao e desserializacao.
    public VendaResumoResponse() {
    }

    // Construtor completo para montar a resposta de forma pratica.
    public VendaResumoResponse(String item, int quantidade, BigDecimal subtotal, BigDecimal desconto, BigDecimal total,
            String categoriaCliente) {
        this.item = item;
        this.quantidade = quantidade;
        this.subtotal = subtotal;
        this.desconto = desconto;
        this.total = total;
        this.categoriaCliente = categoriaCliente;
    }

    // Devolve o nome do item vendido.
    public String getItem() {
        return item;
    }

    // Altera o nome do item vendido.
    public void setItem(String item) {
        this.item = item;
    }

    // Devolve a quantidade vendida.
    public int getQuantidade() {
        return quantidade;
    }

    // Altera a quantidade vendida.
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    // Devolve o valor antes dos descontos.
    public BigDecimal getSubtotal() {
        return subtotal;
    }

    // Altera o subtotal.
    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    // Devolve o valor abatido em desconto.
    public BigDecimal getDesconto() {
        return desconto;
    }

    // Altera o desconto.
    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

    // Devolve o valor final da compra.
    public BigDecimal getTotal() {
        return total;
    }

    // Altera o valor final da compra.
    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    // Devolve a classificacao do cliente.
    public String getCategoriaCliente() {
        return categoriaCliente;
    }

    // Altera a classificacao do cliente.
    public void setCategoriaCliente(String categoriaCliente) {
        this.categoriaCliente = categoriaCliente;
    }
}
