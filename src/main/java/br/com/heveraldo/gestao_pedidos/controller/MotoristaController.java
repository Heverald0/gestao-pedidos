package br.com.heveraldo.gestao_pedidos.controller;

import br.com.heveraldo.gestao_pedidos.dto.MotoristaRequestDTO;
import br.com.heveraldo.gestao_pedidos.model.Motorista;
import br.com.heveraldo.gestao_pedidos.service.MotoristaService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/motoristas")
public class MotoristaController {

    @Autowired
    private MotoristaService motoristaService;

    @Operation(summary = "Cria um novo motorista")
    @PostMapping
    public Motorista criarMotorista(@RequestBody MotoristaRequestDTO motoristaRequestDTO) {
        return motoristaService.criarMotorista(motoristaRequestDTO);
    }

    @Operation(summary = "Lista todos os motoristas")
    @GetMapping
    public List<Motorista> listarMotoristas() {
        return motoristaService.listarTodos();
    }
    
    @Operation(summary = "Busca um motorista por ID")
    @GetMapping("/{id}")
    public ResponseEntity<Motorista> buscarPorId(@PathVariable UUID id) {
        return motoristaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}