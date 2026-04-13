package br.com.trabalho.cabeleireiro.exception;

// Excecao personalizada para quando algum registro nao existe no banco.
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
