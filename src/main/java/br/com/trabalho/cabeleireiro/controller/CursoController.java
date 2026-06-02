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

// Controller que recebe as requisicoes de matricula em cursos.
@RestController
@RequestMapping("/cursos")
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @PostMapping("/matriculas")
    @ResponseStatus(HttpStatus.CREATED)
    public MatriculaResumoResponse matricular(@Valid @RequestBody MatriculaCursoRequest request) {
        return cursoService.matricular(request);
    }
}
