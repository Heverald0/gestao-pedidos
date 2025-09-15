package br.com.heveraldo.gestao_pedidos.controller;

import br.com.heveraldo.gestao_pedidos.dto.CaminhaoRequestDTO;
import br.com.heveraldo.gestao_pedidos.model.Caminhao;
import br.com.heveraldo.gestao_pedidos.service.CaminhaoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/caminhoes")
public class CaminhaoController {

    @Autowired
    private CaminhaoService caminhaoService;

    @Operation(summary = "Cria um novo caminhão")
    @PostMapping
    public Caminhao criarCaminhao(@RequestBody CaminhaoRequestDTO caminhaoRequestDTO) {
        return caminhaoService.criarCaminhao(caminhaoRequestDTO);
    }

    @Operation(summary = "Lista todos os caminhões")
    @GetMapping
    public List<Caminhao> listarCaminhoes() {
        return caminhaoService.listarTodos();
    }

    @Operation(summary = "Busca um caminhão por ID")
    @GetMapping("/{id}")
    public ResponseEntity<Caminhao> buscarPorId(@PathVariable UUID id) {
        return caminhaoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}