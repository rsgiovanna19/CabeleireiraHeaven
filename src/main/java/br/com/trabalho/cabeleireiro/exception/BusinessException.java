package br.com.trabalho.cabeleireiro.exception;

// Excecao personalizada para erros de regra de negocio.
// Exemplo: estoque insuficiente ou tentativa de vender curso para cliente comum.
public class BusinessException extends RuntimeException {
    public BusinessException(String message) {
        super(message);
    }
}
