//imports necessários para a classe de exceção personalizada de recurso não encontrado ex: cliente nao encontrado
//resources not found é para que o sistema informe os erros em tempo de execução
package br.com.trabalho.cabeleireiro.exception;

// Excecao personalizada para quando algum registro nao existe no banco
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
