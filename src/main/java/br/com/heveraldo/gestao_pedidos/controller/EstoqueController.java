package br.com.heveraldo.gestao_pedidos.controller;

import br.com.heveraldo.gestao_pedidos.dto.EstoqueRequestDTO;
import br.com.heveraldo.gestao_pedidos.model.Estoque;
import br.com.heveraldo.gestao_pedidos.service.EstoqueService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/estoque")
public class EstoqueController {

    @Autowired
    private EstoqueService estoqueService;

    @Operation(summary = "Adiciona ou atualiza a quantidade de um produto em um CD")
    @PostMapping("/adicionar")
    public Estoque adicionarEstoque(@RequestBody EstoqueRequestDTO estoqueRequestDTO) {
        return estoqueService.atualizarEstoque(estoqueRequestDTO);
    }
}