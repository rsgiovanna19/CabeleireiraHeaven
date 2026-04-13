package br.com.trabalho.cabeleireiro.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.trabalho.cabeleireiro.model.Produto;

// Acessa a tabela de produtos.
@Repository
public class ProdutoRepository {

    private final JdbcTemplate jdbcTemplate;

    // Recebe a ferramenta de consulta SQL.
    public ProdutoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Lista todos os produtos.
    public List<Produto> findAll() {
        return jdbcTemplate.query("select * from produtos order by nome",
                (rs, rowNum) -> new Produto(
                        rs.getLong("id"),
                        rs.getString("nome"),
                        rs.getBigDecimal("preco"),
                        rs.getInt("estoque"),
                        rs.getString("categoria")));
    }

    // Busca um produto pelo id.
    public Optional<Produto> findById(Long id) {
        List<Produto> produtos = jdbcTemplate.query("select * from produtos where id = ?",
                (rs, rowNum) -> new Produto(
                        rs.getLong("id"),
                        rs.getString("nome"),
                        rs.getBigDecimal("preco"),
                        rs.getInt("estoque"),
                        rs.getString("categoria")),
                id);

        return produtos.stream().findFirst();
    }

    // Atualiza o estoque apos uma venda.
    public void atualizarEstoque(Long id, int novoEstoque) {
        jdbcTemplate.update("update produtos set estoque = ? where id = ?", novoEstoque, id);
    }
}
