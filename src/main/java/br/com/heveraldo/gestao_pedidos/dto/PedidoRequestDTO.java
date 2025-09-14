package br.com.heveraldo.gestao_pedidos.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class PedidoRequestDTO {
    private UUID clienteId;
    private List<ItemPedidoRequestDTO> itens;
}