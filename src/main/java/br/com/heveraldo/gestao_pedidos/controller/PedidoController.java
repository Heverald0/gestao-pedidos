package br.com.heveraldo.gestao_pedidos.controller;

import br.com.heveraldo.gestao_pedidos.dto.PedidoRequestDTO;
import br.com.heveraldo.gestao_pedidos.model.Pedido;
import br.com.heveraldo.gestao_pedidos.service.PedidoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @Operation(summary = "Cria um novo pedido")
    @PostMapping
    public ResponseEntity<Pedido> criarPedido(@RequestBody PedidoRequestDTO pedidoRequestDTO) {
        try {
            Pedido novoPedido = pedidoService.criarPedido(pedidoRequestDTO);
            return ResponseEntity.ok(novoPedido);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
    
    @Operation(summary = "Lista todos os pedidos")
    @GetMapping
    public List<Pedido> listarPedidos() {
        return pedidoService.listarTodos();
    }
    
    @Operation(summary = "Busca um pedido por ID")
    @GetMapping("/{id}")
    public ResponseEntity<Pedido> buscarPedidoPorId(@PathVariable UUID id) {
        return pedidoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}