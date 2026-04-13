package br.com.trabalho.cabeleireiro.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Service;

import br.com.trabalho.cabeleireiro.dto.MatriculaCursoRequest;
import br.com.trabalho.cabeleireiro.dto.MatriculaResumoResponse;
import br.com.trabalho.cabeleireiro.exception.BusinessException;
import br.com.trabalho.cabeleireiro.exception.ResourceNotFoundException;
import br.com.trabalho.cabeleireiro.model.Cliente;
import br.com.trabalho.cabeleireiro.model.Curso;
import br.com.trabalho.cabeleireiro.repository.ClienteRepository;
import br.com.trabalho.cabeleireiro.repository.CursoRepository;

// Regras de negocio para venda de cursos.
@Service
public class CursoService {

    private final ClienteRepository clienteRepository;
    private final CursoRepository cursoRepository;

    // Recebe os repositorios usados na matricula.
    public CursoService(ClienteRepository clienteRepository, CursoRepository cursoRepository) {
        this.clienteRepository = clienteRepository;
        this.cursoRepository = cursoRepository;
    }

    // Matricula um cliente em um curso se ele for profissional e houver vagas.
    public MatriculaResumoResponse matricular(MatriculaCursoRequest request) {
        Cliente cliente = clienteRepository.findById(request.getClienteId())
                .orElseThrow(() -> new ResourceNotFoundException("Cliente nao encontrado"));
        Curso curso = cursoRepository.findById(request.getCursoId())
                .orElseThrow(() -> new ResourceNotFoundException("Curso nao encontrado"));

        if (!cliente.isProfissional()) {
            throw new BusinessException("A venda de cursos e exclusiva para profissionais");
        }

        if (curso.getVagas() <= 0) {
            throw new BusinessException("Curso sem vagas disponiveis");
        }

        BigDecimal desconto = "INICIANTE".equalsIgnoreCase(curso.getNivel())
                ? curso.getPreco().multiply(BigDecimal.valueOf(0.05))
                : BigDecimal.ZERO;
        BigDecimal valorFinal = curso.getPreco().subtract(desconto).setScale(2, RoundingMode.HALF_UP);

        cursoRepository.atualizarVagas(curso.getId(), curso.getVagas() - 1);

        return new MatriculaResumoResponse(
                curso.getTitulo(),
                curso.getNivel(),
                valorFinal,
                "MATRICULA_CONFIRMADA");
    }
}
