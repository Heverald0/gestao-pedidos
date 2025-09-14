package br.com.heveraldo.gestao_pedidos.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.UUID;

@Getter
@Setter
public class EstoqueRequestDTO {
    private UUID produtoId;
    private UUID cdId;      
    private int quantidade;
}