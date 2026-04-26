//importacao dos pacotes necessários para o controller do curso do salão heaven

package br.com.trabalho.cabeleireiro.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.trabalho.cabeleireiro.dto.MatriculaCursoRequest;
import br.com.trabalho.cabeleireiro.dto.MatriculaResumoResponse;
import br.com.trabalho.cabeleireiro.service.CursoService;
import jakarta.validation.Valid;

//O controller curso controla as requisições dos cursos, como matrícula e etc. 
@RestController
@RequestMapping("/cursos")
public class CursoController {

    private final CursoService cursoService;

    //Recebe o service das matriculas por conta das regras de negócio implementaadas em Curso Service.
    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    // POST matriculas -> matricula um cliente em um curso, recebendo os dados necessários para a matrícula
    @PostMapping("/matriculas")
    @ResponseStatus(HttpStatus.CREATED) //se retornar com sucesso, retorna o status 201
    public MatriculaResumoResponse matricular(@Valid @RequestBody MatriculaCursoRequest request) {
        return cursoService.matricular(request);
        //aqui, retornamos tambem um resumo da matrícula, para que o cliente possa ver os detalhes da
        // matrícula realizada, como o nome do curso, data da matrícula e etc
    }   //valid = validacao automatica dos dados recebidos, garantindo que o request esteja correto antes de processar a matrícula.
}
