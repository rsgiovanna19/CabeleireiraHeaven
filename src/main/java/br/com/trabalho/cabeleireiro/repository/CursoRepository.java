package br.com.trabalho.cabeleireiro.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.trabalho.cabeleireiro.model.Curso;

// Acessa a tabela de cursos.
@Repository
public class CursoRepository {

    private final JdbcTemplate jdbcTemplate;

    // Recebe a ferramenta de consulta SQL.
    public CursoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Lista todos os cursos.
    public List<Curso> findAll() {
        return jdbcTemplate.query("select * from cursos order by titulo",
                (rs, rowNum) -> new Curso(
                        rs.getLong("id"),
                        rs.getString("titulo"),
                        rs.getBigDecimal("preco"),
                        rs.getInt("vagas"),
                        rs.getString("nivel")));
    }

    // Busca um curso pelo id.
    public Optional<Curso> findById(Long id) {
        List<Curso> cursos = jdbcTemplate.query("select * from cursos where id = ?",
                (rs, rowNum) -> new Curso(
                        rs.getLong("id"),
                        rs.getString("titulo"),
                        rs.getBigDecimal("preco"),
                        rs.getInt("vagas"),
                        rs.getString("nivel")),
                id);

        return cursos.stream().findFirst();
    }

    // Atualiza o numero de vagas quando alguem compra o curso.
    public void atualizarVagas(Long id, int vagas) {
        jdbcTemplate.update("update cursos set vagas = ? where id = ?", vagas, id);
    }
}
