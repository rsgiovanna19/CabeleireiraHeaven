package br.com.trabalho.cabeleireiro.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.trabalho.cabeleireiro.model.Curso;
import br.com.trabalho.cabeleireiro.model.Produto;
import br.com.trabalho.cabeleireiro.model.Servico;
import br.com.trabalho.cabeleireiro.repository.CursoRepository;
import br.com.trabalho.cabeleireiro.repository.ProdutoRepository;
import br.com.trabalho.cabeleireiro.repository.ServicoRepository;

// Reune consultas de leitura do catalogo do salao.
@Service
public class CatalogoService {

    private final ProdutoRepository produtoRepository;
    private final ServicoRepository servicoRepository;
    private final CursoRepository cursoRepository;

    // Recebe os repositorios de consulta.
    public CatalogoService(ProdutoRepository produtoRepository, ServicoRepository servicoRepository,
            CursoRepository cursoRepository) {
        this.produtoRepository = produtoRepository;
        this.servicoRepository = servicoRepository;
        this.cursoRepository = cursoRepository;
    }

    // Lista produtos.
    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    // Lista servicos.
    public List<Servico> listarServicos() {
        return servicoRepository.findAll();
    }

    // Lista cursos.
    public List<Curso> listarCursos() {
        return cursoRepository.findAll();
    }
}
