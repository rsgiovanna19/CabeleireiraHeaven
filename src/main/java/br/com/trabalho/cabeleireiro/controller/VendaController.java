package br.com.trabalho.cabeleireiro.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.trabalho.cabeleireiro.dto.VendaProdutoRequest;
import br.com.trabalho.cabeleireiro.dto.VendaResumoResponse;
import br.com.trabalho.cabeleireiro.service.VendaService;
import jakarta.validation.Valid;

// Controller responsavel pelas requisicoes de venda de produtos.
@RestController
@RequestMapping("/vendas")
public class VendaController {

    private final VendaService vendaService;

    // Recebe o service que processa as vendas.
    public VendaController(VendaService vendaService) {
        this.vendaService = vendaService;
    }

    // Endpoint POST /vendas/produtos.
    // Recebe o pedido de venda e devolve o resumo calculado.
    @PostMapping("/produtos")
    @ResponseStatus(HttpStatus.CREATED)
    public VendaResumoResponse venderProduto(@Valid @RequestBody VendaProdutoRequest request) {
        return vendaService.venderProduto(request);
    }
}
