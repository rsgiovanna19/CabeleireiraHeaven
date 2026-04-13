package br.com.trabalho.cabeleireiro.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.trabalho.cabeleireiro.model.Curso;
import br.com.trabalho.cabeleireiro.model.Produto;
import br.com.trabalho.cabeleireiro.model.Servico;
import br.com.trabalho.cabeleireiro.service.CatalogoService;

// Controller de consulta do catalogo do salao.
@RestController
@RequestMapping("/catalogo")
public class CatalogoController {

    private final CatalogoService catalogoService;

    // Recebe o service do catalogo.
    public CatalogoController(CatalogoService catalogoService) {
        this.catalogoService = catalogoService;
    }

    // Endpoint GET /catalogo/produtos.
    @GetMapping("/produtos")
    public List<Produto> listarProdutos() {
        return catalogoService.listarProdutos();
    }

    // Endpoint GET /catalogo/servicos.
    @GetMapping("/servicos")
    public List<Servico> listarServicos() {
        return catalogoService.listarServicos();
    }

    // Endpoint GET /catalogo/cursos.
    @GetMapping("/cursos")
    public List<Curso> listarCursos() {
        return catalogoService.listarCursos();
    }
}
