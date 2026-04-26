//pacotes e importacoes necessárias
//o agendamento controller é responsável pelas requisicoes http sobre agendamentos
//le, deleta, cria ou modifica os agendamentos 

//ps: controller recebe a lógica do service. O controller recebe e envia dados, chamando o service p processar as regras de negócio.
package br.com.trabalho.cabeleireiro.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.trabalho.cabeleireiro.dto.AgendamentoRequest;
import br.com.trabalho.cabeleireiro.model.Agendamento;
import br.com.trabalho.cabeleireiro.service.AgendamentoService;
import jakarta.validation.Valid;

// Porta de entrada HTTP para os agendamentos
@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {

    private final AgendamentoService agendamentoService;

    // Recebe o service que cuida das regras da agenda.
    //as regras, descritas no readme, estão no service. o controlle precisa delas para funcionar com as regras de negócio.
    public AgendamentoController(AgendamentoService agendamentoService) {
        this.agendamentoService = agendamentoService;
    }

    // GET para agendamentos - conseguimos ler todos os agendamentos
    @GetMapping
    public List<Agendamento> listar() {
        return agendamentoService.listarTodos();
    }

    // GET para agendamentos por ID - leitura dos agendamentos por ID
    @GetMapping("/{id}")
    public Agendamento buscarPorId(@PathVariable Long id) {
        return agendamentoService.buscarPorId(id);
    }

    // POST para agendamentos - cria um novo agendamento
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Agendamento criar(@Valid @RequestBody AgendamentoRequest request) {
        return agendamentoService.criar(request);
    }

    // PUT para agendamentos - atualiza um agendamento que já existe, obviamente, por ID
    @PutMapping("/{id}")
    public Agendamento atualizar(@PathVariable Long id, @Valid @RequestBody AgendamentoRequest request) {
        return agendamentoService.atualizar(id, request);
    }

    // DELETE para agendamentos - deletar um agendamento por id
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id) {
        agendamentoService.remover(id);
    }
}
