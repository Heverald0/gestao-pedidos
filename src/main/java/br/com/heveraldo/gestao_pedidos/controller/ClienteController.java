package br.com.heveraldo.gestao_pedidos.controller;

import br.com.heveraldo.gestao_pedidos.dto.ClienteRequestDTO;
import br.com.heveraldo.gestao_pedidos.model.Cliente;
import br.com.heveraldo.gestao_pedidos.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Operation(summary = "Cria um novo cliente")
    @PostMapping
    public Cliente criarCliente(@RequestBody ClienteRequestDTO clienteRequestDTO) {
        return clienteService.criarCliente(clienteRequestDTO);
    }

    @Operation(summary = "Lista todos os clientes")
    @GetMapping
    public List<Cliente> listarClientes() {
        return clienteService.listarTodos();
    }

    @Operation(summary = "Busca um cliente por ID")
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarClientePorId(@PathVariable UUID id) {
        return clienteService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}