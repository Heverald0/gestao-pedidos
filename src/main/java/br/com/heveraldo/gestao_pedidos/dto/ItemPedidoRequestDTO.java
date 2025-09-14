package br.com.heveraldo.gestao_pedidos.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.UUID;

@Getter
@Setter
public class ItemPedidoRequestDTO {
    private UUID produtoId;
    private int quantidade;
}