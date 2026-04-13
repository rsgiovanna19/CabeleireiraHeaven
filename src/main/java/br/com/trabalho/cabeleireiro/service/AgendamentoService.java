package br.com.trabalho.cabeleireiro.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.trabalho.cabeleireiro.dto.AgendamentoRequest;
import br.com.trabalho.cabeleireiro.exception.BusinessException;
import br.com.trabalho.cabeleireiro.exception.ResourceNotFoundException;
import br.com.trabalho.cabeleireiro.model.Agendamento;
import br.com.trabalho.cabeleireiro.model.AgendamentoStatus;
import br.com.trabalho.cabeleireiro.model.Cliente;
import br.com.trabalho.cabeleireiro.model.Servico;
import br.com.trabalho.cabeleireiro.repository.AgendamentoRepository;
import br.com.trabalho.cabeleireiro.repository.ClienteRepository;
import br.com.trabalho.cabeleireiro.repository.ServicoRepository;

// Centraliza as regras de negocio dos agendamentos.
@Service
public class AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;
    private final ClienteRepository clienteRepository;
    private final ServicoRepository servicoRepository;

    // Recebe os repositorios necessarios para validar cliente, servico e agenda.
    public AgendamentoService(AgendamentoRepository agendamentoRepository, ClienteRepository clienteRepository,
            ServicoRepository servicoRepository) {
        this.agendamentoRepository = agendamentoRepository;
        this.clienteRepository = clienteRepository;
        this.servicoRepository = servicoRepository;
    }

    // Lista todos os agendamentos.
    public List<Agendamento> listarTodos() {
        return agendamentoRepository.findAll();
    }

    // Busca um agendamento ou gera erro se nao existir.
    public Agendamento buscarPorId(Long id) {
        return agendamentoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Agendamento nao encontrado"));
    }

    // Cria um novo agendamento.
    public Agendamento criar(AgendamentoRequest request) {
        return salvar(null, request);
    }

    // Atualiza um agendamento existente.
    public Agendamento atualizar(Long id, AgendamentoRequest request) {
        buscarPorId(id);
        return salvar(id, request);
    }

    // Remove um agendamento.
    public void remover(Long id) {
        buscarPorId(id);
        agendamentoRepository.deleteById(id);
    }

    // Concentra a logica de salvar, tanto na criacao quanto na atualizacao.
    private Agendamento salvar(Long id, AgendamentoRequest request) {
        Cliente cliente = clienteRepository.findById(request.getClienteId())
                .orElseThrow(() -> new ResourceNotFoundException("Cliente nao encontrado"));
        Servico servico = servicoRepository.findById(request.getServicoId())
                .orElseThrow(() -> new ResourceNotFoundException("Servico nao encontrado"));

        validarHorario(request.getDataHora(), request.getServicoId(), id);
        BigDecimal valorFinal = calcularValor(servico.getPrecoBase(), request.getDataHora(), cliente.isProfissional());

        Agendamento agendamento = new Agendamento(
                id,
                cliente.getId(),
                servico.getId(),
                request.getDataHora(),
                request.getObservacoes(),
                classificarStatus(request.getDataHora()),
                valorFinal);

        if (id == null) {
            return agendamentoRepository.save(agendamento);
        }
        return agendamentoRepository.update(agendamento);
    }

    // Verifica se o horario esta dentro do expediente e se nao ha conflito.
    private void validarHorario(LocalDateTime dataHora, Long servicoId, Long ignoreId) {
        if (dataHora.getHour() < 8 || dataHora.getHour() > 19) {
            throw new BusinessException("Horario fora do expediente do salao");
        }

        if (agendamentoRepository.existsByHorario(servicoId, Timestamp.valueOf(dataHora), ignoreId)) {
            throw new BusinessException("Ja existe um atendimento desse servico nesse horario");
        }
    }

    // Calcula o valor final do servico considerando sabado e desconto para profissional.
    private BigDecimal calcularValor(BigDecimal precoBase, LocalDateTime dataHora, boolean profissional) {
        BigDecimal taxaFinalSemana = dataHora.getDayOfWeek() == DayOfWeek.SATURDAY
                ? precoBase.multiply(BigDecimal.valueOf(0.10))
                : BigDecimal.ZERO;

        BigDecimal descontoProfissional = profissional
                ? precoBase.multiply(BigDecimal.valueOf(0.15))
                : BigDecimal.ZERO;

        return precoBase.add(taxaFinalSemana).subtract(descontoProfissional).setScale(2, RoundingMode.HALF_UP);
    }

    // Decide se o atendimento fica apenas agendado ou ja confirmado.
    private AgendamentoStatus classificarStatus(LocalDateTime dataHora) {
        if (dataHora.isBefore(LocalDateTime.now().plusHours(24))) {
            return AgendamentoStatus.CONFIRMADO;
        }
        return AgendamentoStatus.AGENDADO;
    }
}
