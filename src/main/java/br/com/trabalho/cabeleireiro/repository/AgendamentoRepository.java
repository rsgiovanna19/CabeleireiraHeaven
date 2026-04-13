package br.com.trabalho.cabeleireiro.repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import br.com.trabalho.cabeleireiro.model.Agendamento;
import br.com.trabalho.cabeleireiro.model.AgendamentoStatus;

// Acessa a tabela de agendamentos.
@Repository
public class AgendamentoRepository {

    private final JdbcTemplate jdbcTemplate;

    // Recebe a ferramenta que executa SQL no banco.
    public AgendamentoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Lista todos os agendamentos.
    public List<Agendamento> findAll() {
        return jdbcTemplate.query("select * from agendamentos order by data_hora",
                (rs, rowNum) -> new Agendamento(
                        rs.getLong("id"),
                        rs.getLong("cliente_id"),
                        rs.getLong("servico_id"),
                        rs.getTimestamp("data_hora").toLocalDateTime(),
                        rs.getString("observacoes"),
                        AgendamentoStatus.valueOf(rs.getString("status")),
                        rs.getBigDecimal("valor_cobrado")));
    }

    // Busca um agendamento pelo id.
    public Optional<Agendamento> findById(Long id) {
        List<Agendamento> agendamentos = jdbcTemplate.query("select * from agendamentos where id = ?",
                (rs, rowNum) -> new Agendamento(
                        rs.getLong("id"),
                        rs.getLong("cliente_id"),
                        rs.getLong("servico_id"),
                        rs.getTimestamp("data_hora").toLocalDateTime(),
                        rs.getString("observacoes"),
                        AgendamentoStatus.valueOf(rs.getString("status")),
                        rs.getBigDecimal("valor_cobrado")),
                id);

        return agendamentos.stream().findFirst();
    }

    // Verifica se ja existe um atendimento no mesmo horario
    // para evitar conflito de agenda.
    public boolean existsByHorario(Long servicoId, Timestamp dataHora, Long ignoreId) {
        Integer total = jdbcTemplate.queryForObject(
                "select count(*) from agendamentos where servico_id = ? and data_hora = ? and status <> 'CANCELADO' and (? is null or id <> ?)",
                Integer.class,
                servicoId,
                dataHora,
                ignoreId,
                ignoreId);

        return total != null && total > 0;
    }

    // Salva um novo agendamento no banco.
    public Agendamento save(Agendamento agendamento) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement statement = connection.prepareStatement(
                    "insert into agendamentos (cliente_id, servico_id, data_hora, observacoes, status, valor_cobrado) values (?, ?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, agendamento.getClienteId());
            statement.setLong(2, agendamento.getServicoId());
            statement.setTimestamp(3, Timestamp.valueOf(agendamento.getDataHora()));
            statement.setString(4, agendamento.getObservacoes());
            statement.setString(5, agendamento.getStatus().name());
            statement.setBigDecimal(6, agendamento.getValorCobrado());
            return statement;
        }, keyHolder);

        agendamento.setId(keyHolder.getKey().longValue());
        return agendamento;
    }

    // Atualiza um agendamento existente.
    public Agendamento update(Agendamento agendamento) {
        jdbcTemplate.update(
                "update agendamentos set cliente_id = ?, servico_id = ?, data_hora = ?, observacoes = ?, status = ?, valor_cobrado = ? where id = ?",
                agendamento.getClienteId(),
                agendamento.getServicoId(),
                Timestamp.valueOf(agendamento.getDataHora()),
                agendamento.getObservacoes(),
                agendamento.getStatus().name(),
                agendamento.getValorCobrado(),
                agendamento.getId());
        return agendamento;
    }

    // Remove um agendamento.
    public void deleteById(Long id) {
        jdbcTemplate.update("delete from agendamentos where id = ?", id);
    }
}
