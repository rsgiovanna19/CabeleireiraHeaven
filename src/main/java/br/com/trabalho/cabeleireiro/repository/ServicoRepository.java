package br.com.trabalho.cabeleireiro.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.trabalho.cabeleireiro.model.Servico;

// Acessa a tabela de servicos.
@Repository
public class ServicoRepository {

    private final JdbcTemplate jdbcTemplate;

    // Recebe a ferramenta de consulta SQL.
    public ServicoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Lista todos os servicos do sistema.
    public List<Servico> findAll() {
        return jdbcTemplate.query("select * from servicos order by nome",
                (rs, rowNum) -> new Servico(
                        rs.getLong("id"),
                        rs.getString("nome"),
                        rs.getBigDecimal("preco_base"),
                        rs.getString("categoria")));
    }

    // Busca um servico especifico pelo id.
    public Optional<Servico> findById(Long id) {
        List<Servico> servicos = jdbcTemplate.query("select * from servicos where id = ?",
                (rs, rowNum) -> new Servico(
                        rs.getLong("id"),
                        rs.getString("nome"),
                        rs.getBigDecimal("preco_base"),
                        rs.getString("categoria")),
                id);

        return servicos.stream().findFirst();
    }
}
