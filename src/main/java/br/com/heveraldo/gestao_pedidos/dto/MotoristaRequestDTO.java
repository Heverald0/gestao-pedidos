package br.com.heveraldo.gestao_pedidos.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.UUID;

@Getter
@Setter
public class MotoristaRequestDTO {
    private String nome;
    private String cnh;
    private UUID centroDistribuicaoId;
}