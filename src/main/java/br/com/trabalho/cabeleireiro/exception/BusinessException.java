//imports necessários para a classe de exceção personalizada de regras de negócio
package br.com.trabalho.cabeleireiro.exception;

// Excecao personalizada para erros de regra de negocio do nosso sistema
// Exemplo: estoque insuficiente ou tentativa de vender curso para cliente comum
public class BusinessException extends RuntimeException {
    public BusinessException(String message) {
        super(message);
    }
}
