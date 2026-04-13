package br.com.trabalho.cabeleireiro.repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import br.com.trabalho.cabeleireiro.model.Cliente;

// Camada responsavel por acessar a tabela de clientes no banco.
// Aqui ficam apenas comandos de leitura e escrita no banco de dados.
@Repository
public class ClienteRepository {

    private final JdbcTemplate jdbcTemplate;

    // Recebe o objeto que faz consultas SQL no banco.
    public ClienteRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Busca todos os clientes cadastrados.
    public List<Cliente> findAll() {
        return jdbcTemplate.query("select * from clientes order by id",
                (rs, rowNum) -> new Cliente(
                        rs.getLong("id"),
                        rs.getString("nome"),
                        rs.getString("telefone"),
                        rs.getString("email"),
                        rs.getBoolean("profissional")));
    }

    // Busca um cliente pelo codigo.
    public Optional<Cliente> findById(Long id) {
        List<Cliente> clientes = jdbcTemplate.query("select * from clientes where id = ?",
                (rs, rowNum) -> new Cliente(
                        rs.getLong("id"),
                        rs.getString("nome"),
                        rs.getString("telefone"),
                        rs.getString("email"),
                        rs.getBoolean("profissional")),
                id);

        return clientes.stream().findFirst();
    }

    // Insere um novo cliente no banco e devolve o objeto com o id gerado.
    public Cliente save(Cliente cliente) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement statement = connection.prepareStatement(
                    "insert into clientes (nome, telefone, email, profissional) values (?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, cliente.getNome());
            statement.setString(2, cliente.getTelefone());
            statement.setString(3, cliente.getEmail());
            statement.setBoolean(4, cliente.isProfissional());
            return statement;
        }, keyHolder);

        cliente.setId(keyHolder.getKey().longValue());
        return cliente;
    }

    // Atualiza um cliente ja existente.
    public Cliente update(Cliente cliente) {
        jdbcTemplate.update("update clientes set nome = ?, telefone = ?, email = ?, profissional = ? where id = ?",
                cliente.getNome(),
                cliente.getTelefone(),
                cliente.getEmail(),
                cliente.isProfissional(),
                cliente.getId());
        return cliente;
    }

    // Remove um cliente pelo codigo.
    public void deleteById(Long id) {
        jdbcTemplate.update("delete from clientes where id = ?", id);
    }
}
