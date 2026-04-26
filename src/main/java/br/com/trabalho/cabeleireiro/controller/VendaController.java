//importação dos pacotes necessários para o controller de vendas do salão heaven

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

// Controller de vendas = controla as vendas de produtos do salão, recebendo os pedidos de venda e devolvendo o resumo calculado
@RestController
@RequestMapping("/vendas")
public class VendaController {

    private final VendaService vendaService;

    // recebendo o vendasService com a lógica de negócio
    public VendaController(VendaService vendaService) {
        this.vendaService = vendaService;
    }
    
    //POST -> nova venda de produto, recebendo os dados necessários para a venda, como o id do cliente, id do produto e quantidade
    @PostMapping("/produtos")
    @ResponseStatus(HttpStatus.CREATED) //se a venda for realizada com sucesso, retorna o status 201
    public VendaResumoResponse venderProduto(@Valid @RequestBody VendaProdutoRequest request) {
        return vendaService.venderProduto(request);
    }
}
