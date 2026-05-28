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
        // Agora tambem le os campos de endereco salvos no banco.
        return jdbcTemplate.query("select * from clientes order by id",
                (rs, rowNum) -> new Cliente(
                        rs.getLong("id"),
                        rs.getString("nome"),
                        rs.getString("telefone"),
                        rs.getString("email"),
                        rs.getString("cep"),
                        rs.getString("logradouro"),
                        rs.getString("bairro"),
                        rs.getString("cidade"),
                        rs.getString("uf"),
                        rs.getBoolean("profissional")));
    }

    // Busca um cliente pelo codigo.
    public Optional<Cliente> findById(Long id) {
        // Retorna o cliente completo, incluindo endereco.
        List<Cliente> clientes = jdbcTemplate.query("select * from clientes where id = ?",
                (rs, rowNum) -> new Cliente(
                        rs.getLong("id"),
                        rs.getString("nome"),
                        rs.getString("telefone"),
                        rs.getString("email"),
                        rs.getString("cep"),
                        rs.getString("logradouro"),
                        rs.getString("bairro"),
                        rs.getString("cidade"),
                        rs.getString("uf"),
                        rs.getBoolean("profissional")),
                id);

        return clientes.stream().findFirst();
    }

    // Insere um novo cliente no banco e devolve o objeto com o id gerado.
    public Cliente save(Cliente cliente) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            // Salva tambem os dados buscados pelo ViaCEP.
            PreparedStatement statement = connection.prepareStatement(
                    "insert into clientes (nome, telefone, email, cep, logradouro, bairro, cidade, uf, profissional) values (?, ?, ?, ?, ?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, cliente.getNome());
            statement.setString(2, cliente.getTelefone());
            statement.setString(3, cliente.getEmail());
            statement.setString(4, cliente.getCep());
            statement.setString(5, cliente.getLogradouro());
            statement.setString(6, cliente.getBairro());
            statement.setString(7, cliente.getCidade());
            statement.setString(8, cliente.getUf());
            statement.setBoolean(9, cliente.isProfissional());
            return statement;
        }, keyHolder);

        cliente.setId(keyHolder.getKey().longValue());
        return cliente;
    }

    // Atualiza um cliente ja existente.
    public Cliente update(Cliente cliente) {
        // Atualiza tambem os campos de endereco.
        jdbcTemplate.update(
                "update clientes set nome = ?, telefone = ?, email = ?, cep = ?, logradouro = ?, bairro = ?, cidade = ?, uf = ?, profissional = ? where id = ?",
                cliente.getNome(),
                cliente.getTelefone(),
                cliente.getEmail(),
                cliente.getCep(),
                cliente.getLogradouro(),
                cliente.getBairro(),
                cliente.getCidade(),
                cliente.getUf(),
                cliente.isProfissional(),
                cliente.getId());
        return cliente;
    }

    // Remove um cliente pelo codigo.
    public void deleteById(Long id) {
        jdbcTemplate.update("delete from clientes where id = ?", id);
    }
}
