package br.com.trabalho.cabeleireiro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Ponto de entrada da aplicacao.
// Quando executamos este arquivo, o Spring Boot sobe o servidor,
// cria os objetos do sistema e disponibiliza a API HTTP.
@SpringBootApplication
public class SistemaCabeleireiroApplication {

    // Metodo principal do Java.
    // Ele inicializa toda a aplicacao web.
    public static void main(String[] args) {
        SpringApplication.run(SistemaCabeleireiroApplication.class, args);
    }
}
