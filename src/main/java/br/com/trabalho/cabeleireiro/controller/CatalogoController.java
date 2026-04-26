//import de todos os pacotes necessários para o catalogo controller
//catalogo controller é responsável por controlar o catálogo de produtos do salão heaven

package br.com.trabalho.cabeleireiro.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.trabalho.cabeleireiro.model.Curso;
import br.com.trabalho.cabeleireiro.model.Produto;
import br.com.trabalho.cabeleireiro.model.Servico;
import br.com.trabalho.cabeleireiro.service.CatalogoService;


@RestController
@RequestMapping("/catalogo")
public class CatalogoController {

    private final CatalogoService catalogoService;

    // recebimento do service do catalogo, ou seja, todas as regras de negócio do catálogo, descritas no readME

    public CatalogoController(CatalogoService catalogoService) {
        this.catalogoService = catalogoService;
    }

    // Endpoint GET /catalogo/produtos -> lista os produtos do catálogo (ex: shampoo, condicionador, etc)
    @GetMapping("/produtos")
    public List<Produto> listarProdutos() {
        return catalogoService.listarProdutos();
    }

    // Endpoint GET /catalogo/servicos -> lista os serviços do catálogo (ex: corte, coloração, etc)
    @GetMapping("/servicos")
    public List<Servico> listarServicos() {
        return catalogoService.listarServicos();
    }

    // Endpoint GET /catalogo/cursos -> lista os cursos do catálogo (ex: curso de corte, curso de coloração, etc)
    @GetMapping("/cursos")
    public List<Curso> listarCursos() {
        return catalogoService.listarCursos();
    }
}
