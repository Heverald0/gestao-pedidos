package br.com.heveraldo.gestao_pedidos.controller;

import br.com.heveraldo.gestao_pedidos.model.CentroDistribuicao;
import br.com.heveraldo.gestao_pedidos.repository.CentroDistribuicaoRepository;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cds")
public class CentroDistribuicaoController {

    @Autowired
    private CentroDistribuicaoRepository cdRepository;

    @Operation(summary = "Cria um novo Centro de Distribuição")
    @PostMapping
    public CentroDistribuicao criarCD(@RequestBody CentroDistribuicao centroDistribuicao) {
        return cdRepository.save(centroDistribuicao);
    }

    @Operation(summary = "Lista todos os Centros de Distribuição")
    @GetMapping
    public List<CentroDistribuicao> listarCDs() {
        return cdRepository.findAll();
    }
}