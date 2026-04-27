//import dos pacotes necessários para a classe de tratamento de exceções da API

package br.com.trabalho.cabeleireiro.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//Excception = exceção. Trata-se de erros do sistema. neste caso, trata dos erros relacionados a API, como validação, regras de negócio...
@RestControllerAdvice
public class ApiExceptionHandler {

    // captura os casos em que o registro pedido nao existe
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleNotFound(ResourceNotFoundException exception) { 
            //por que 'string, object' ? para criar um corpo de resposta padronizado, com informações como timestamp, status e mensagem de erro. O Map permite armazenar esses dados de forma flexível.
            //retorna um status 404 e a mensagem de erro personalizada
        return buildResponse(HttpStatus.NOT_FOUND, exception.getMessage());
    }

    // Trata casos em que alguma regra de negocio foi violada -> seguindo os services.
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Map<String, Object>> handleBusiness(BusinessException exception) {
        return buildResponse(HttpStatus.BAD_REQUEST, exception.getMessage());
    }

    // Trata erros de validacao nos dados enviados pelo usuario
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidation(MethodArgumentNotValidException exception) {
        String message = exception.getBindingResult().getFieldErrors().stream()
                .findFirst()
                .map(fieldError -> fieldError.getDefaultMessage())
                .orElse("Dados invalidos");

        return buildResponse(HttpStatus.BAD_REQUEST, message);
    }

    // Trata qualquer outro erro inesperado.
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGeneric(Exception exception) {
        return buildResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Erro interno: " + exception.getMessage());
    }

    // Monta um corpo JSON padronizado para os erros
    //para que? para garantir que todas as respostas de erro tenham um formato consistente, facilitando a compreensão e o 
    // tratamento dos erros pelos clientes da API
    private ResponseEntity<Map<String, Object>> buildResponse(HttpStatus status, String message) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", status.value());
        body.put("erro", message);
        return ResponseEntity.status(status).body(body);
    }
}
